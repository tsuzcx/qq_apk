import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RecommendedGatherListActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class guj
  implements View.OnClickListener
{
  public guj(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(BannerManager.a(this.a), RecommendedGatherListActivity.class);
    BannerManager.a(this.a).startActivity(paramView);
    ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "0X8004C46", "0X8004C46", 0, 0, "", "", "", "");
    ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "0X8004C47", "0X8004C47", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     guj
 * JD-Core Version:    0.7.0.1
 */