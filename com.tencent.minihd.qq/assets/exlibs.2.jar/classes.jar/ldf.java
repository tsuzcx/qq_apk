import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class ldf
  implements View.OnClickListener
{
  public ldf(QZoneAppWebViewActivity paramQZoneAppWebViewActivity) {}
  
  public void onClick(View paramView)
  {
    LogUtility.b("IphoneTitleBarActivity", "on RightButton click!");
    if (!TextUtils.isEmpty(QZoneAppWebViewActivity.a(this.a))) {
      this.a.a.loadUrl("javascript:JsBridge.callback(\"" + QZoneAppWebViewActivity.b(this.a) + "\");void(0);");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ldf
 * JD-Core Version:    0.7.0.1
 */