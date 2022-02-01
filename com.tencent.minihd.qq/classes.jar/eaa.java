import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.statistics.ReportController;

public class eaa
  implements View.OnClickListener
{
  public eaa(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    ForwardRecentActivity.a(this.a).a(String.valueOf(AppConstants.Y), 6000, "", "我的电脑");
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004051", "0X8004051", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     eaa
 * JD-Core Version:    0.7.0.1
 */