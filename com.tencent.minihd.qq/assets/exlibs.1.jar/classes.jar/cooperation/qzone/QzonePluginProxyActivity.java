package cooperation.qzone;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.mobileqq.activity.QQBasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.Iterator;
import java.util.List;
import mbg;
import mbh;

public class QzonePluginProxyActivity
  extends QQBasePluginActivity
{
  private static final String[] a = { "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.LocalPictureViewer" };
  private static final String[] b = { "com.qzone.vip.QZoneOpenVIPActivity", "com.qzone.common.activities.QzoneAdaptVideoActivity", "com.qzone.cover.ui.activity.QZoneCoverPreviewActivity", "com.qzone.log.CrashNotificationActivity", "com.qzone.common.activities.NotificationActivity", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity" };
  public static final String f = "com.qzone";
  static final String g = "QZone";
  static final String h = "qzone_plugin.apk";
  public static final String i = "qzone_plugin_activity_name";
  public static final String j = "QZoneExtra.Plugin.isloading";
  private static final String k = "Crash_Count_In_CNFException";
  
  public static ClassLoader a(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qzone_plugin.apk");
  }
  
  public static String a()
  {
    return "qzone_plugin.apk";
  }
  
  static String a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qzone_plugin_activity_name");
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramString, paramIntent, paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    boolean bool = true;
    Object localObject;
    if (!a(paramActivity))
    {
      localObject = new QzoneProgressDialog(paramActivity, paramIntent);
      ((QzoneProgressDialog)localObject).a("正在加载...");
      ((QzoneProgressDialog)localObject).setOnDismissListener(new mbg(paramOnDismissListener));
    }
    for (paramOnDismissListener = (DialogInterface.OnDismissListener)localObject;; paramOnDismissListener = null)
    {
      localObject = a(paramIntent);
      Class localClass = mbh.a((String)localObject);
      paramIntent.putExtra("userQqResources", 1);
      if (paramOnDismissListener != null) {}
      for (;;)
      {
        paramIntent.putExtra("QZoneExtra.Plugin.isloading", bool);
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
        localPluginParams.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
        localPluginParams.d = "QZone";
        localPluginParams.jdField_a_of_type_JavaLangString = paramString;
        localPluginParams.e = ((String)localObject);
        localPluginParams.jdField_a_of_type_JavaLangClass = localClass;
        localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
        localPluginParams.jdField_b_of_type_Int = paramInt;
        localPluginParams.jdField_a_of_type_AndroidAppDialog = paramOnDismissListener;
        localPluginParams.c = 15000;
        localPluginParams.f = null;
        localPluginParams.jdField_a_of_type_Boolean = false;
        IPluginManager.a(paramActivity, localPluginParams);
        return;
        bool = false;
      }
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("qzone_plugin_activity_name", paramString);
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putBoolean("cleartop", true);
    paramBundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
    paramBundle.putString("PhotoConst.PLUGIN_NAME", "QZone");
    paramBundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
  }
  
  private static boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.minihd.qq".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int n = paramArrayOfString.length;
      int m = 0;
      while (m < n)
      {
        if (paramString.equals(paramArrayOfString[m])) {
          return true;
        }
        m += 1;
      }
    }
  }
  
  public String getPluginID()
  {
    return "qzone_plugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return mbh.a(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((!TextUtils.isEmpty(this.mCreateErrorInfo)) && (!this.mCreateErrorInfo.equals("success")))
    {
      if (paramBundle != null) {}
      for (;;)
      {
        paramBundle = paramBundle.getString("pluginsdk_launchActivity");
        localObject = new StringBuffer("[插件启动失败] ");
        ((StringBuffer)localObject).append(paramBundle).append(" ").append(this.mCreateErrorInfo);
        QLog.e("QZLog", 1, ((StringBuffer)localObject).toString());
        return;
        paramBundle = getIntent().getExtras();
      }
    }
    Object localObject = getIntent().getExtras();
    if (localObject != null)
    {
      paramBundle = ((Bundle)localObject).getString("from_plugin");
      localObject = ((Bundle)localObject).getString("uin");
      getIntent().putExtra("from_plugin", "");
      if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals("QZoneVideoPlugin"))) {
        a(this, (String)localObject, getIntent(), 1000);
      }
    }
    getWindow().setBackgroundDrawableResource(17170445);
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int m;
    label60:
    do
    {
      do
      {
        return false;
        if (QzoneConfig.a().a("QZoneSetting", "PluginPermissionErrorHandle", 1) != 0) {}
        int n;
        for (m = 1;; m = 0)
        {
          n = QzoneConfig.a().a("QZoneSetting", "PluginErrorHandleCount", -1);
          if (n != 0) {
            break label60;
          }
          if (m == 0) {
            break;
          }
          return super.shouldHandleStartPluginFailed(paramString);
        }
        paramString = paramString.toLowerCase();
        if (!paramString.contains("classnotfoundexception")) {
          break;
        }
        SharedPreferences localSharedPreferences = getSharedPreferences("Qz_setting", 0);
        int i1 = localSharedPreferences.getInt("Crash_Count_In_CNFException", 0);
        localSharedPreferences.edit().putInt("Crash_Count_In_CNFException", i1 + 1).commit();
        if (i1 == 0)
        {
          QLog.e("Plugin", 1, "kill process with first Exception:" + paramString);
          finish();
          Process.killProcess(Process.myPid());
        }
        for (;;)
        {
          return true;
          if ((n >= 0) && (i1 >= n)) {
            break;
          }
          QLog.e("Plugin", 1, "show dialog with non-first Exception:" + paramString);
          showNeedUninstanllAndInstallDialog();
        }
      } while (m == 0);
      return super.shouldHandleStartPluginFailed(paramString);
    } while (m == 0);
    return super.shouldHandleStartPluginFailed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */