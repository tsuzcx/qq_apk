package cooperation.qzone.mood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

public class QzoneSelectMoodPictureJsPlugin
  extends WebViewPlugin
{
  public static final String a = "QzMoodSelectPicture";
  public static final String b = "selectPicture";
  private String c = QzoneSelectMoodPictureJsPlugin.class.getSimpleName();
  
  private void a(String paramString) {}
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    return super.handleEvent(paramString, paramInt, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("QzMoodSelectPicture")) {}
    while ((!paramString3.equals("selectPicture")) || (paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return false;
    }
    paramJsBridgeListener = new Intent();
    paramString1 = new Bundle();
    try
    {
      paramString2 = new JSONObject(paramVarArgs[0]);
      paramString1.putString("url", paramString2.getString("url"));
      paramString1.putString("imageId", paramString2.getString("imageId"));
      paramString1.putInt("width", paramString2.getInt("width"));
      paramString1.putInt("height", paramString2.getInt("height"));
      paramJsBridgeListener.putExtras(paramString1);
      if (this.mRuntime.a() != null)
      {
        this.mRuntime.a().setResult(-1, paramJsBridgeListener);
        this.mRuntime.a().finish();
      }
      return true;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.c, 2, "select mood picture,decode param error");
        }
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", "https://www.baidu.com");
    localIntent.putExtras(localBundle);
    this.mRuntime.a().setResult(50, localIntent);
  }
  
  protected void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.mood.QzoneSelectMoodPictureJsPlugin
 * JD-Core Version:    0.7.0.1
 */