val limitMonth=600_000
val limitDay=150_000
val minCommissionVisa=35
val commissionVisa=0.0075
val commissionMastercard=0.006
val commissionFixMastercard=20
val commissionLimitMastercard=75000
var sumDay:Int=0;
fun main(){
    var sum=100_000
    var sumMonth=80_000
    if (sum+sumDay<limitDay){
        if (sum+sumMonth<limitMonth)
        println("Комиссия составит: "+commission("mastercard",sum=sum, sumMonth = sumMonth))
        else println("Превышен месячный лимит")
    }
    else println("Превышен дневной лимит")
}

fun commission(typeCard:String="mir",sumMonth:Int=0, sum:Int):Int{
   return     when (typeCard){
        "mir"->0
        "visa"->if(sum*commissionVisa<minCommissionVisa) minCommissionVisa else (sum*commissionVisa).toInt()
        "mastercard"-> if (sum+sumMonth<commissionLimitMastercard) 0 else if(sumMonth>=commissionLimitMastercard) (sum*commissionMastercard).toInt() else {
            ((sum+sumMonth-commissionLimitMastercard)*commissionMastercard+commissionFixMastercard).toInt() }

        else->0
        }
   }

