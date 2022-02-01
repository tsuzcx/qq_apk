import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.biz.widgets.XChooserActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;

public class erx
  extends ProxyWebViewClientExtension
{
  public erx(QQBrowserActivity paramQQBrowserActivity) {}
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    if ("openBrowserList".equals(paramString))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramBundle.getString("url")));
      paramBundle = new Bundle();
      paramBundle.putString("EXTRA_PACKAGE_NAME", "com.tencent.mtt");
      paramBundle.putString("EXTRA_TITLE", "QQ浏览器");
      paramBundle.putString("EXTRA_DESC", "安全推荐");
      paramBundle.putInt("EXTRA_ICON_ID", 2130839264);
      paramBundle.putString("EXTRA_URL", "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
      if (this.a.a == null)
      {
        this.a.a = new ery(this);
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_QB_REPORT");
        this.a.registerReceiver(this.a.a, localIntentFilter, "com.tencent.msg.permission.pushnotify2", null);
      }
      XChooserActivity.a(this.a, paramString, -1, "android.intent.action.VIEW", this.a.getString(2131364183), new Bundle[] { paramBundle });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     erx
 * JD-Core Version:    0.7.0.1
 */