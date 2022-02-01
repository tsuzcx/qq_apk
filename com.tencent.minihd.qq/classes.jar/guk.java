import android.app.NotificationManager;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiHelper;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;

public class guk
  implements View.OnClickListener
{
  public guk(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    ((NotificationManager)BannerManager.a(this.a).getSystemService("notification")).cancel(QQWiFiHelper.a);
    paramView = new Intent(BannerManager.a(this.a), QQWiFiPluginInstallActivity.class);
    paramView.setAction("com.tencent.mobileqq.action.QQWiFi");
    paramView.putExtra("from-bluebar", true);
    BannerManager.a(this.a).startActivity(paramView);
    this.a.a(14, 0);
    this.a.a(null);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent.banner", 2, "banner click send qqwifi broadcast");
    }
    paramView = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
    paramView.putExtra("intervalTime", QQWiFiHelper.b + 2L);
    BannerManager.a(this.a).sendBroadcast(paramView);
    ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "QQWIFI", "clk_buleNotify", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     guk
 * JD-Core Version:    0.7.0.1
 */