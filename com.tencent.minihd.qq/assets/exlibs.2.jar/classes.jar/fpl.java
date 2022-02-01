import android.os.Bundle;
import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import mqq.app.permission.PermissionCallback;

public class fpl
  implements PermissionCallback
{
  public fpl(PlusPanel paramPlusPanel, SplashActivity paramSplashActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, paramInt, paramArrayOfString, new fpm(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Bundle();
    paramArrayOfString.putString("troop_uin", PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a);
    paramArrayOfString.putBoolean("hide_operation_bar", true);
    paramArrayOfString.putBoolean("hide_more_button", true);
    paramArrayOfString.putBoolean("isScreenOrientationPortrait", true);
    TroopUtils.b(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a(), paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fpl
 * JD-Core Version:    0.7.0.1
 */