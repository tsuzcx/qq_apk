import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.sdk.WebView;

public class cjk
  implements DialogInterface.OnClickListener
{
  public cjk(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.mRuntime.a();
    if (paramDialogInterface == null) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        paramDialogInterface.loadUrl("javascript:" + this.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (paramInt != 1);
    paramDialogInterface.loadUrl("javascript:" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cjk
 * JD-Core Version:    0.7.0.1
 */