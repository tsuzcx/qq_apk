import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.widget.WidgetContainer;
import com.tencent.mobileqq.statistics.ReportController;

public class hbx
  implements View.OnClickListener
{
  public hbx(WidgetContainer paramWidgetContainer) {}
  
  public void onClick(View paramView)
  {
    WidgetContainer.a(this.a);
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X80060D4", "0X80060D4", 0, 0, "5", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hbx
 * JD-Core Version:    0.7.0.1
 */