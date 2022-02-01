package cooperation.qzone.coverstore;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QzonePluginProxyActivity;

public class QZonePersonalizeJsHandleLogic
{
  public static final String a = QZonePersonalizeJsHandleLogic.class.getSimpleName() + QZonePersonalizePlugin.a;
  
  public static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    paramVarArgs = new Intent();
    QzonePluginProxyActivity.a(paramVarArgs, "com.qzone.personalize.QZonePersonalizeSettingActivity");
    QzonePluginProxyActivity.a(paramPluginRuntime.a(), paramPluginRuntime.a().getAccount(), paramVarArgs, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.coverstore.QZonePersonalizeJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */