import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.open.downloadnew.MyAppApi;
import org.json.JSONObject;

public class enq
  implements DialogInterface.OnClickListener
{
  public enq(NotificationActivity paramNotificationActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface = new JSONObject();
      paramDialogInterface.put("appid", "100686848");
      paramDialogInterface.put("apkId", "6633");
      paramDialogInterface.put("versionCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.getPackageManager().getPackageInfo(this.jdField_a_of_type_JavaLangString, 16384).versionCode));
      paramDialogInterface.put("via", "ANDROIDQQ.NEICE.OTHER");
      paramDialogInterface.put("appPackageName", this.jdField_a_of_type_JavaLangString);
      paramDialogInterface.put("channel", "000316053134377c30");
      paramDialogInterface.put("appAuthorizedStr", NotificationActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity));
      paramDialogInterface = paramDialogInterface.toString();
      MyAppApi.a().a(paramDialogInterface, new enr(this), this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity);
      NotificationActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, true);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     enq
 * JD-Core Version:    0.7.0.1
 */