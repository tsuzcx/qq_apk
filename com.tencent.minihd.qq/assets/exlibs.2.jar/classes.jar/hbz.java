import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.widget.WidgetContainer;
import com.tencent.mobileqq.statistics.ReportController;

public class hbz
  implements View.OnClickListener
{
  public hbz(WidgetContainer paramWidgetContainer) {}
  
  public void onClick(View paramView)
  {
    if (WidgetContainer.a(this.a, "2909288299")) {
      RecentUtil.a(this.a.a, this.a.a.app, "2909288299", 1008, "腾讯新闻", Conversation.b);
    }
    for (;;)
    {
      ReportController.b(this.a.a.app, "CliOper", "", "", "0X80060D4", "0X80060D4", 0, 0, "2", "", "", "");
      return;
      paramView = new Intent(this.a.a, AccountDetailActivity.class);
      paramView.putExtra("uin", "2909288299");
      paramView.putExtra("uinname", "腾讯新闻");
      this.a.a.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hbz
 * JD-Core Version:    0.7.0.1
 */