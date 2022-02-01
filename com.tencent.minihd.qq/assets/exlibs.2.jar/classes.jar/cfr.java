import android.media.MediaRecorder;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import java.io.IOException;
import mqq.app.AppActivity;
import mqq.app.permission.PermissionCallback;

public class cfr
  implements PermissionCallback
{
  public cfr(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.jdField_a_of_type_MqqAppAppActivity, paramInt, paramArrayOfString, new cfs(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.setAudioSource(1);
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.setOutputFormat(3);
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.setAudioEncoder(0);
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.setOutputFile("/dev/null");
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.setMaxDuration(600000);
    try
    {
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.prepare();
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.start();
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (IllegalStateException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
    catch (IOException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cfr
 * JD-Core Version:    0.7.0.1
 */