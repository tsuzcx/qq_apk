package cooperation.qzone.video;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class QzoneVideoPluginProxyService
  extends PluginProxyService
{
  public static void a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("useSkinEngine", 1);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "QzoneVideoPlugin.apk";
    localPluginParams.d = "QZoneVideo";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.e = "com.tencent.maxvideo.remote.QzoneVideoPluginService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    IPluginManager.b(paramContext, localPluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVideoPluginProxyService
 * JD-Core Version:    0.7.0.1
 */