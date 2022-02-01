import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class gdw
  implements View.OnClickListener
{
  public gdw(TroopAssistTipsBar paramTroopAssistTipsBar) {}
  
  public void onClick(View paramView)
  {
    TroopAssistTipsBar.a(this.a).a(TroopAssistTipsBar.a(this.a).a, Integer.valueOf(4));
    TroopAssistTipsBar.a(this.a).a();
    TroopAssistantManager.a().a(TroopAssistTipsBar.a(this.a), TroopAssistTipsBar.a(this.a).a);
    QQToast.a(TroopAssistTipsBar.a(this.a).a(), 2, 2131368796, 0).b(TroopAssistTipsBar.a(this.a).getTitleBarHeight());
    ReportController.b(TroopAssistTipsBar.a(this.a), "P_CliOper", "Grp_msg", "", "AIOchat", "Clk_setmsg", 0, 0, TroopAssistTipsBar.a(this.a).a, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gdw
 * JD-Core Version:    0.7.0.1
 */