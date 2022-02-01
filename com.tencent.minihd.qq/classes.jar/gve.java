import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.statistics.ReportController;

public class gve
  implements View.OnClickListener
{
  public gve(RecentCallHelper paramRecentCallHelper) {}
  
  public void onClick(View paramView)
  {
    RecentCallHelper.a(this.a).setVisibility(8);
    RecentCallHelper.a(this.a).a(RecentCallHelper.a(this.a));
    ReportController.b(null, "CliOper", "", "", "0X800510E", "0X800510E", 0, 0, "", "", "", "");
    ThreadManager.b(new gvf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gve
 * JD-Core Version:    0.7.0.1
 */