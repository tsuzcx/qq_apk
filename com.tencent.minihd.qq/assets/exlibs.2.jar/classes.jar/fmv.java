import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.UserguideFaceMaskActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class fmv
  implements View.OnClickListener
{
  public fmv(UserguideFaceMaskActivity paramUserguideFaceMaskActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserguideFaceMaskActivity", 2, "click pass btn");
    }
    if (UserguideFaceMaskActivity.a(this.a)) {
      ReportController.a((QQAppInterface)this.a.getAppRuntime(), "CliOper", "", "", "0X80051F1", "0X80051F1", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.finish();
      return;
      ReportController.a((QQAppInterface)this.a.getAppRuntime(), "CliOper", "", "", "0X80051F0", "0X80051F0", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fmv
 * JD-Core Version:    0.7.0.1
 */