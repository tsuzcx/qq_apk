package cooperation.qzone.coverstore;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QzonePluginProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneVisitorJsHandleLogic
{
  public static final String a = QZoneVisitorJsHandleLogic.class.getSimpleName();
  
  public static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      long l = paramVarArgs.getLong("uin");
      paramVarArgs.getString("nick");
      paramVarArgs = new Intent();
      QzonePluginProxyActivity.a(paramVarArgs, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
      paramVarArgs.putExtra("qqid", l);
      paramVarArgs.putExtra("refer", "H5VisitorList");
      QzonePluginProxyActivity.a(paramPluginRuntime.a(), paramPluginRuntime.a().getAccount(), paramVarArgs, 0);
      return;
    }
    catch (JSONException paramPluginRuntime)
    {
      paramPluginRuntime.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.coverstore.QZoneVisitorJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */