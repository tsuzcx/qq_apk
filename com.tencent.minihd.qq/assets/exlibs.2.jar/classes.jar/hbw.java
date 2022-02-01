import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.widget.WidgetContainer;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qzone.QZoneHelper;

public class hbw
  implements View.OnClickListener
{
  public hbw(WidgetContainer paramWidgetContainer) {}
  
  public void onClick(View paramView)
  {
    QZoneHelper.a(this.a.a, 0);
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X80060D4", "0X80060D4", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hbw
 * JD-Core Version:    0.7.0.1
 */