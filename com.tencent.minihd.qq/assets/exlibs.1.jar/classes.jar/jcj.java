import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import mqq.app.AppActivity;
import mqq.app.permission.PermissionCallback;
import org.json.JSONObject;

public class jcj
  implements PermissionCallback
{
  public jcj(MediaApiPlugin paramMediaApiPlugin, Intent paramIntent, Context paramContext, String paramString, JSONObject paramJSONObject, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.jdField_a_of_type_MqqAppAppActivity, paramInt, paramArrayOfString, new jck(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, (byte)1);
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit().putString("camera_photo_path", this.jdField_a_of_type_JavaLangString).putString("getPictureParam", this.jdField_a_of_type_OrgJsonJSONObject.toString()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jcj
 * JD-Core Version:    0.7.0.1
 */