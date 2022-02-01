package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneWebViewPlugin
  extends WebViewPlugin
{
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 12)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString)) {
        if (!paramString.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/sendGift/index.html"))
        {
          bool1 = bool2;
          if (!paramString.startsWith("https://qzs.qzone.qq.com/qzone/hybrid/module/gift/mall.html")) {}
        }
        else
        {
          paramString = new Intent();
          this.mRuntime.a().setResult(0, paramString);
          this.mRuntime.a().finish();
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if (!paramString2.equals("Qzone")) {}
    while (!paramString3.equals("SendGiftFinished")) {
      return false;
    }
    if (paramVarArgs != null) {}
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      if (paramString1.getInt("success") == 1)
      {
        paramJsBridgeListener = paramString1.getJSONArray("uins");
        if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
        {
          if ((paramString1.has("toast")) && (paramString1.getBoolean("toast"))) {
            QQToast.a(this.mRuntime.a(), 2, 2131369443, 0).a();
          }
          paramString1 = new long[paramJsBridgeListener.length()];
          while (i < paramJsBridgeListener.length())
          {
            paramString1[i] = paramJsBridgeListener.getLong(i);
            i += 1;
          }
          paramJsBridgeListener = new Intent();
          paramJsBridgeListener.putExtra("key_msg_type", 2);
          paramJsBridgeListener.putExtra("key_friend_list", paramString1);
          this.mRuntime.a().setResult(-1, paramJsBridgeListener);
          this.mRuntime.a().finish();
        }
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */