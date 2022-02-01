import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class gus
  implements View.OnClickListener
{
  public gus(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    if (BannerManager.a(this.a) != null)
    {
      paramView = BannerManager.a(this.a).getParent();
      if ((paramView != null) && ((paramView instanceof SplashActivity))) {
        ((SplashActivity)paramView).a(2);
      }
      ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "0X80040AA", "0X80040AA", 0, 0, "", "", "", "");
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gus
 * JD-Core Version:    0.7.0.1
 */