package cooperation.plugin;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.zebra.WatermarkPluginProxyActivity;
import cooperation.zebra.ZebraPluginProxyActivity;
import cooperation.zebra.ZebraPluginSplashDialog;
import java.io.File;

public class ActivityLauncher
{
  public static void a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(100);
      ((StringBuilder)localObject1).append("openStandaloneZebra").append(", activity = ").append(paramActivity);
      QLog.i("Q.zebra.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = AppConstants.cc;
    try
    {
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).getParentFile();
        if (localObject2 != null) {
          ((File)localObject2).mkdirs();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        if (QLog.isColorLevel()) {
          QLog.i("Q.zebra.", 2, localException.toString());
        }
      }
    }
    localObject2 = new Intent("android.media.action.IMAGE_CAPTURE");
    ((Intent)localObject2).setPackage("com.tencent.zebra");
    ((Intent)localObject2).putExtra("platform", 1);
    ((Intent)localObject2).putExtra("output", Uri.parse((String)localObject1));
    paramActivity.startActivityForResult((Intent)localObject2, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append("openBuiltInZebra").append(", activity = ").append(paramActivity).append(", selfUin = ").append(paramString1).append(", selfName = ").append(paramString2);
      QLog.i("Q.zebra.", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(paramActivity, WatermarkPluginProxyActivity.class);
    ((Intent)localObject).putExtra("market", "qqportal");
    if (paramString2 != null) {
      ((Intent)localObject).putExtra("self_nick", paramString2);
    }
    ((Intent)localObject).putExtra("pluginsdk_selfuin", paramString1);
    ((Intent)localObject).putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
    try
    {
      ((Intent)localObject).putExtra("qq", Long.parseLong(paramString1));
      ((Intent)localObject).putExtra("qq_face_file_path", paramString3);
      ((Intent)localObject).putExtra("load_from_third_app", true);
      ((Intent)localObject).putExtra("jump_to_mobileqq_share", true);
      ((Intent)localObject).putExtra("frommqq_conversation_btn", true);
      ((Intent)localObject).putExtra("param_plugin_gesturelock", true);
      paramString2 = new IPluginManager.PluginParams(0);
      paramString2.jdField_b_of_type_JavaLangString = "WaterMarkCamera.apk";
      paramString2.d = "水印相机";
      paramString2.jdField_a_of_type_JavaLangString = paramString1;
      paramString2.e = "com.tencent.cameraui.MqqCameraActivity";
      paramString2.jdField_a_of_type_JavaLangClass = ZebraPluginProxyActivity.class;
      paramString2.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
      paramString2.jdField_b_of_type_Int = -1;
      paramString2.jdField_a_of_type_AndroidAppDialog = new ZebraPluginSplashDialog(paramActivity, 0);
      paramString2.jdField_a_of_type_Boolean = false;
      paramString2.c = 10000;
      paramString2.f = "正在启动水印相机，请稍候";
      IPluginManager.a(paramActivity, paramString2);
      return;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(100);
      ((StringBuilder)localObject1).append("openZebra").append(", activity = ").append(paramActivity).append(", selfUin = ").append(paramString1).append(", selfName = ").append(paramString2);
      QLog.i("Q.zebra.", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramActivity == null) {
      return;
    }
    try
    {
      localObject1 = paramActivity.getPackageManager().getPackageInfo("com.tencent.zebra", 8192);
      if ((localObject1 != null) && (((PackageInfo)localObject1).versionCode >= 18))
      {
        a(paramActivity, paramInt);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.zebra.", 2, localNameNotFoundException.toString());
        }
        Object localObject2 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.zebra.", 2, localException.toString());
        }
        Object localObject3 = null;
      }
      a(paramActivity, paramString1, paramString2, paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.ActivityLauncher
 * JD-Core Version:    0.7.0.1
 */