import android.content.Intent;
import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.qav.activity.QavChatActivity;
import mqq.app.permission.PermissionCallback;

public class jpe
  implements PermissionCallback
{
  public jpe(QCallDetailActivity paramQCallDetailActivity, String paramString, SplashActivity paramSplashActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, paramInt, paramArrayOfString, new jpf(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, QavChatActivity.class);
    paramArrayOfString.addFlags(262144);
    paramArrayOfString.putExtra("key_peer_uin", this.jdField_a_of_type_JavaLangString);
    paramArrayOfString.putExtra("key_only_audio", true);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.startActivity(paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jpe
 * JD-Core Version:    0.7.0.1
 */