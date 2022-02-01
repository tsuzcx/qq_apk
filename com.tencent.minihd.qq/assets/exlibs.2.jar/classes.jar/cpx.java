import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.LoadedBack2;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.sdk.WebView;

public class cpx
  implements LoadedBack2
{
  public cpx(OfflinePlugin paramOfflinePlugin) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.a();
    if (localObject == null) {}
    CustomWebView localCustomWebView;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(localObject instanceof QQBrowserActivity));
        localObject = (QQBrowserActivity)localObject;
      } while (QQBrowserActivity.sTopActivity == localObject);
      localCustomWebView = this.a.mRuntime.a();
    } while (localCustomWebView == null);
    localCustomWebView.loadUrl(((QQBrowserActivity)localObject).M);
  }
  
  public void a(int paramInt)
  {
    Message localMessage = this.a.a.obtainMessage();
    localMessage.arg1 = 4;
    localMessage.arg2 = paramInt;
    this.a.a.sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = this.a.a.obtainMessage();
    paramString.arg1 = 5;
    paramString.arg2 = paramInt;
    this.a.a.sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cpx
 * JD-Core Version:    0.7.0.1
 */