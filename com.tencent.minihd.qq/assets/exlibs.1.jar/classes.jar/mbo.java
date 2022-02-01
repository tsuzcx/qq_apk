import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import cooperation.qzone.QZoneHelper.QZoneCoverConstants;
import cooperation.qzone.coverstore.QZoneCoverStorePlugin;

public class mbo
  implements View.OnClickListener
{
  public mbo(QZoneCoverStorePlugin paramQZoneCoverStorePlugin) {}
  
  public void onClick(View paramView)
  {
    paramView = QZoneHelper.QZoneCoverConstants.a(this.a.mRuntime.a().getSid(), "qzone", String.valueOf(1), this.a.mRuntime.a().getAccount());
    this.a.mRuntime.a().loadUrl(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbo
 * JD-Core Version:    0.7.0.1
 */