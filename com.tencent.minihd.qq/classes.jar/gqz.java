import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindNumberBusinessActivity;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class gqz
  implements View.OnClickListener
{
  public gqz(MyBusinessActivity paramMyBusinessActivity) {}
  
  public void onClick(View paramView)
  {
    BindNumberBusinessActivity.a(this.a, "", true);
    ReportController.b(this.a.app, "CliOper", "", "", "0X800421C", "0X800421C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gqz
 * JD-Core Version:    0.7.0.1
 */