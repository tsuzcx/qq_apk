import com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class lee
  implements Runnable
{
  public lee(OpenJsBridge.OpenJsBridgeListener paramOpenJsBridgeListener, String paramString1, String paramString2, WebView paramWebView) {}
  
  public void run()
  {
    LogUtility.b("Response", "AsyncInterface_end:javascript:window.JsBridge&&JsBridge.callback('interface." + this.jdField_a_of_type_JavaLangString + "',{guid:" + this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge$OpenJsBridgeListener.b + ",'r':0,'data':" + this.b + "});");
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('interface." + this.jdField_a_of_type_JavaLangString + "',{guid:" + this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge$OpenJsBridgeListener.b + ",'r':0,'data':" + this.b + "});");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lee
 * JD-Core Version:    0.7.0.1
 */