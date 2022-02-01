import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class eel
  implements View.OnClickListener
{
  public eel(HotChatListActivity paramHotChatListActivity) {}
  
  public void onClick(View paramView)
  {
    if ((HotChatListActivity.a(this.a) != null) && (HotChatListActivity.a(this.a).isShowing())) {
      HotChatListActivity.a(this.a).dismiss();
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004413", "0X8004413", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eel
 * JD-Core Version:    0.7.0.1
 */