import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class fhc
  extends BizTroopObserver
{
  public fhc(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (paramLong1 != 0L) {}
    this.a.jdField_a_of_type_Long = paramLong2;
    this.a.b = paramLong3;
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (paramBoolean)) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r != 2) {
        break label140;
      }
    }
    label140:
    for (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt = 3;; this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r)
    {
      ((FriendsManagerImp)this.a.app.getManager(8)).b(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
      if ((this.a.aM == 0) || (1 == this.a.aM)) {
        ReportController.b(this.a.app, "P_CliOper", "Grp_create", "", "edit_data", "ordinary_suc", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, TroopInfoActivity.b(this.a), "", "");
      }
      TroopInfoActivity.a(this.a, paramBoolean, paramLong, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhc
 * JD-Core Version:    0.7.0.1
 */