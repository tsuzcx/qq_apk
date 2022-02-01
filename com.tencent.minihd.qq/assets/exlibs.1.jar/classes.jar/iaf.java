import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class iaf
  implements Runnable
{
  public iaf(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(DatingDestinationActivity.a(this.a)))
    {
      DatingDestinationActivity.a(this.a).setVisibility(0);
      if (!DatingDestinationActivity.a(this.a).equals(ian.a(DatingDestinationActivity.a(this.a)))) {
        DatingDestinationActivity.a(this.a).a(DatingDestinationActivity.a(this.a));
      }
      if (!this.a.a)
      {
        this.a.a = true;
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004F30", "0X8004F30", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iaf
 * JD-Core Version:    0.7.0.1
 */