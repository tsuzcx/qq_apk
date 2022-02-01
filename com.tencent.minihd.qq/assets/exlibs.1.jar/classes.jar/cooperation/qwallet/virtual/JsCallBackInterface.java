package cooperation.qwallet.virtual;

import android.util.Log;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;

public class JsCallBackInterface
  extends WebViewPlugin
{
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Log.d("QChongLotteryBrowser", "setBtnInfo started");
    TopBtnConfig localTopBtnConfig = new TopBtnConfig();
    localTopBtnConfig.jdField_a_of_type_Int = Integer.parseInt(paramString1);
    localTopBtnConfig.jdField_b_of_type_Int = Integer.parseInt(paramString2);
    localTopBtnConfig.jdField_a_of_type_JavaLangString = paramString3;
    localTopBtnConfig.jdField_b_of_type_JavaLangString = paramString4;
    if ((this.mRuntime.a() instanceof QChongLotteryBrowser)) {
      ((QChongLotteryBrowser)this.mRuntime.a()).a(localTopBtnConfig);
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"mqBridge".equals(paramString2)) {}
    while ((!"setBtnInfo".equals(paramString3)) || (paramVarArgs.length != 4)) {
      return false;
    }
    a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3]);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.virtual.JsCallBackInterface
 * JD-Core Version:    0.7.0.1
 */