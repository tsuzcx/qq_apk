import android.app.NotificationManager;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiHelper;

public class gum
  implements View.OnClickListener
{
  public gum(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    this.a.a(14, 0);
    this.a.a(null);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent.banner", 2, "banner close send qqwifi broadcast");
    }
    paramView = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
    paramView.putExtra("intervalTime", QQWiFiHelper.b + 1L);
    BannerManager.a(this.a).sendBroadcast(paramView);
    ((NotificationManager)BannerManager.a(this.a).getSystemService("notification")).cancel(QQWiFiHelper.a);
    ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "QQWIFI", "clk_buleClose", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gum
 * JD-Core Version:    0.7.0.1
 */