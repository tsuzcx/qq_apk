import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RecommendedGatherListActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class ewh
  implements View.OnClickListener
{
  public ewh(RecommendedGatherListActivity paramRecommendedGatherListActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004C4C", "0X8004C4C", 0, 0, "", "", "", "");
    RecommendedGatherListActivity.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ewh
 * JD-Core Version:    0.7.0.1
 */