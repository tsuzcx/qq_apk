package cooperation.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.feedback.eup.CrashReport;
import lxj;
import lxk;

public class PluginCrashReceiver
  extends BroadcastReceiver
{
  public static final String a = "pluginsdk_carsh_throwable";
  public static final String b = "pluginsdk_carsh_pluginID";
  public static final String c = "com.tencent.mobileqq.ACTION_PLUGIN_CRASH";
  public static final String d = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED";
  public static final String e = "com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramIntent.getAction();
        if (!"com.tencent.mobileqq.ACTION_PLUGIN_CRASH".equals(str)) {
          break;
        }
        paramContext = (Throwable)paramIntent.getSerializableExtra("pluginsdk_carsh_throwable");
        paramIntent = paramIntent.getStringExtra("pluginsdk_carsh_pluginID");
      } while (paramContext == null);
      try
      {
        CrashReport.handleCatchException(new Thread(), paramContext, paramIntent, null);
        return;
      }
      catch (Exception paramContext)
      {
        return;
      }
      if ("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED".equals(str)) {
        try
        {
          new lxk(paramIntent).execute(new String[] { "" });
          return;
        }
        catch (Throwable paramContext)
        {
          return;
        }
      }
    } while (!"com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG".equals(str));
    try
    {
      new lxj(paramContext).execute(new String[] { "" });
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.PluginCrashReceiver
 * JD-Core Version:    0.7.0.1
 */