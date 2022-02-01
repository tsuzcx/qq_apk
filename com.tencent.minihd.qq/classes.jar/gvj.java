import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.statistics.ReportController;

public class gvj
  implements View.OnClickListener
{
  public gvj(RecentCallHelper paramRecentCallHelper) {}
  
  public void onClick(View paramView)
  {
    RecentCallHelper.a(this.a, true);
    if (RecentCallHelper.a(this.a) != null) {
      RecentCallHelper.a(this.a).setVisibility(0);
    }
    RecentCallHelper.a(this.a).setVisibility(8);
    RecentCallHelper.a(this.a, false);
    ReportController.b(null, "CliOper", "", "", "0X8004C0E", "0X8004C0E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvj
 * JD-Core Version:    0.7.0.1
 */