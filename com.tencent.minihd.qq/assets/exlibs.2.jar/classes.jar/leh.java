import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class leh
  implements View.OnClickListener
{
  public leh(QZoneAppListActivity paramQZoneAppListActivity) {}
  
  public void onClick(View paramView)
  {
    LogUtility.b("QZoneAppListActivity", "button onClick!!!");
    if (TextUtils.isEmpty(QZoneAppListActivity.a(this.a)))
    {
      this.a.a();
      QZoneAppListActivity.a(this.a);
      QZoneAppListActivity.a(this.a).sendEmptyMessage(3);
      return;
    }
    this.a.a.loadUrl("javascript:JsBridge.callback(\"" + QZoneAppListActivity.b(this.a) + "\");void(0);");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     leh
 * JD-Core Version:    0.7.0.1
 */