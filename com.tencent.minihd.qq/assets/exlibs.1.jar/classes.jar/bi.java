import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;
import mqq.app.permission.PermissionCallback;

class bi
  implements PermissionCallback
{
  bi(bh parambh, SplashActivity paramSplashActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, paramInt, paramArrayOfString, new bj(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    StatisticAssist.a(this.jdField_a_of_type_Bh.a.app.getApplication().getApplicationContext(), this.jdField_a_of_type_Bh.a.app.a(), "dl_cktkphoto");
    this.jdField_a_of_type_Bh.a.a();
    ReportController.b(this.jdField_a_of_type_Bh.a.app, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bi
 * JD-Core Version:    0.7.0.1
 */