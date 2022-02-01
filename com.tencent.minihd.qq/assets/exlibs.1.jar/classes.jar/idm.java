import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.dating.DatingFeedActivity;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class idm
  implements View.OnClickListener
{
  public idm(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  public void onClick(View paramView)
  {
    if (MsgBoxListActivity.a(this.a) == 1010)
    {
      paramView = new Intent(this.a, DatingFeedActivity.class);
      this.a.startActivity(paramView);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005101", "0X8005101", 0, 0, "", "", "", "");
    }
    while (MsgBoxListActivity.a(this.a) != 1001) {
      return;
    }
    paramView = new Intent(this.a, NearbyActivity.class);
    this.a.startActivity(paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8005100", "0X8005100", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idm
 * JD-Core Version:    0.7.0.1
 */