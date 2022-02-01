import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SecurityDetectActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class gup
  implements View.OnClickListener
{
  public gup(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(BannerManager.a(this.a), SecurityDetectActivity.class);
    BannerManager.a(this.a).startActivity(paramView);
    ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_PushBanner", "ClickOnBanner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gup
 * JD-Core Version:    0.7.0.1
 */