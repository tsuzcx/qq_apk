import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qqdataline.DatalinePluginProxyActivity;

public class gut
  implements View.OnClickListener
{
  public gut(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent();
    paramView.putExtra("isFromStatusbar", true);
    DatalinePluginProxyActivity.a(BannerManager.a(this.a), BannerManager.a(this.a).app.a(), paramView, "com.qqdataline.activity.LiteWifiphotoActivity", -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gut
 * JD-Core Version:    0.7.0.1
 */