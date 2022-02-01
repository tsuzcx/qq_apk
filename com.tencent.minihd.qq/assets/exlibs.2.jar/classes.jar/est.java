import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class est
  implements View.OnClickListener
{
  public est(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.t();
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "sdk_locate", "click_send", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     est
 * JD-Core Version:    0.7.0.1
 */