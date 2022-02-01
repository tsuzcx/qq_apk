package cooperation.qzone.video;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.Iterator;
import java.util.List;

public class QzoneVideoPluginProxyActivity
  extends PluginProxyActivity
{
  public static final String a = "com.tencent.maxvideo";
  static final String b = "QZoneVideo";
  static final String c = "QzoneVideoPlugin.apk";
  public static final String d = "qzone_video_plugin_activity_name";
  
  public static ClassLoader a(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "QzoneVideoPlugin.apk");
  }
  
  static String a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qzone_video_plugin_activity_name");
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramString, paramIntent, paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramOnDismissListener = null;
    boolean bool = a(paramActivity);
    String str = a(paramIntent);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    if (!bool)
    {
      if (!str.equals("com.tencent.maxvideo.activity.RecordActivity")) {
        break label149;
      }
      localPluginParams.f = "正在启动短视频，请稍候...";
      paramOnDismissListener = new QzoneVideoSplashDialog(paramActivity);
    }
    for (;;)
    {
      paramIntent.putExtra("userQqResources", -1);
      paramIntent.putExtra("useSkinEngine", true);
      paramIntent.putExtra("param_plugin_gesturelock", true);
      localPluginParams.jdField_b_of_type_JavaLangString = "QzoneVideoPlugin.apk";
      localPluginParams.d = "QZoneVideo";
      localPluginParams.jdField_a_of_type_JavaLangString = paramString;
      localPluginParams.e = str;
      localPluginParams.jdField_a_of_type_JavaLangClass = QzoneVideoPluginProxyActivity.class;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localPluginParams.jdField_b_of_type_Int = paramInt;
      localPluginParams.jdField_a_of_type_AndroidAppDialog = paramOnDismissListener;
      localPluginParams.c = 10000;
      IPluginManager.a(paramActivity, localPluginParams);
      return;
      label149:
      paramOnDismissListener = new QzoneProgressDialog(paramActivity, paramIntent);
      ((QzoneProgressDialog)paramOnDismissListener).a("正在启动短视频，请稍候...");
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("qzone_video_plugin_activity_name", paramString);
  }
  
  private static boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.minihd.qq:qzonevideo".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return getClass();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((!TextUtils.isEmpty(this.mCreateErrorInfo)) && (!this.mCreateErrorInfo.equals("success"))) {
      if (paramBundle == null) {
        break label77;
      }
    }
    for (;;)
    {
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer("[插件启动失败] ");
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      QLog.e("QZLog", 1, localStringBuffer.toString());
      return;
      label77:
      paramBundle = getIntent().getExtras();
    }
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    return super.shouldHandleStartPluginFailed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */