package cooperation.qzone.coverstore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QZoneZebraAlbumJsHandleLogic
{
  public static final String a = QZoneZebraAlbumJsHandleLogic.class.getSimpleName() + QZonePersonalizePlugin.a;
  
  public static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    paramPluginRuntime = new Intent("action_js2qzone");
    paramVarArgs = new Bundle();
    paramVarArgs.putString("cmd", "CleanZebraNum");
    paramPluginRuntime.putExtras(paramVarArgs);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "actionString: " + paramPluginRuntime.getAction());
    }
    BaseApplication.getContext().sendBroadcast(paramPluginRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.coverstore.QZoneZebraAlbumJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */