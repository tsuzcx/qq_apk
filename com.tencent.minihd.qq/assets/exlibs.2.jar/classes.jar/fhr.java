import com.tencent.biz.helper.TroopInfoActivityHelper.ISetSameCityCheckTypeInfo;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class fhr
  implements TroopInfoActivityHelper.ISetSameCityCheckTypeInfo
{
  public fhr(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt = 4;
      ((FriendsManagerImp)this.a.app.getManager(8)).b(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
    }
    ReportController.b(this.a.app, "P_CliOper", "Grp_create", "", "edit_data", "local_suc", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, TroopInfoActivity.b(this.a), "", "");
    TroopInfoActivity.a(this.a, true, 0L, "");
  }
  
  public void b()
  {
    this.a.i();
    TroopInfoActivity.a(this.a, false, 0L, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhr
 * JD-Core Version:    0.7.0.1
 */