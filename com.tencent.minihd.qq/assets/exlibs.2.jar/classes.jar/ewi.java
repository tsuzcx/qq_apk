import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RecommendedGatherListActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class ewi
  implements View.OnClickListener
{
  public ewi(RecommendedGatherListActivity paramRecommendedGatherListActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004C4B", "0X8004C4B", 0, 0, "", "", "", "");
    RecommendedGatherListActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ewi
 * JD-Core Version:    0.7.0.1
 */