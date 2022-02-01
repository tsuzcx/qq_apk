import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.agent.SwitchAccountActivity;
import com.tencent.qphone.base.util.QLog;

public class lcq
  implements View.OnClickListener
{
  public lcq(SwitchAccountActivity paramSwitchAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a) {
      return;
    }
    this.a.b = ((String)paramView.getTag());
    ReportController.b(null, "CliOper", "", "", "0X80060D9", "0X80060D9", 0, 0, "", "", this.a.b, "");
    if (QLog.isColorLevel()) {
      QLog.d("SwitchAccountActivity", 2, "0X80060D9: account = " + this.a.b);
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lcq
 * JD-Core Version:    0.7.0.1
 */