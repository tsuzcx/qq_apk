import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class fco
  implements View.OnClickListener
{
  public fco(StrangerManageActivity paramStrangerManageActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b(true);
    ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Manage_stranger_edit", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fco
 * JD-Core Version:    0.7.0.1
 */