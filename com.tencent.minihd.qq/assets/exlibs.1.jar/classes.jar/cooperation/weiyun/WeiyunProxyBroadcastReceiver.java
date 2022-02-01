package cooperation.weiyun;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import mqq.app.AppRuntime;

public class WeiyunProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  private static final String a = "com.weiyun.plugin.BROADCAST";
  
  public static void a(Context paramContext, String paramString, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setAction("com.weiyun.plugin.BROADCAST");
    paramIntent = new IPluginManager.PluginParams(0);
    paramIntent.b = "WeiyunPlugin.apk";
    paramIntent.d = paramContext.getResources().getString(2131370054);
    paramIntent.jdField_a_of_type_JavaLangString = BaseApplicationImpl.a().a().getAccount();
    paramIntent.e = paramString;
    paramIntent.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.a(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.weiyun.WeiyunProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */