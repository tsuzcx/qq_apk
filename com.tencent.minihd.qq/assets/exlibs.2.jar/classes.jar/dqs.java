import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class dqs
  implements View.OnClickListener
{
  public dqs(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.e()))
    {
      paramView = "https://qqweb.qq.com/m/business/qunlevel/index.html?gc=" + this.a.a.c + "&from=0&_wv=1027";
      localObject = new Intent(this.a, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject).putExtra("url", paramView);
      this.a.startActivity((Intent)localObject);
      localObject = this.a.app;
      str = this.a.a.c;
      if (this.a.a.b)
      {
        paramView = "0";
        ReportController.b((QQAppInterface)localObject, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_credit", 0, 0, str, paramView, "", "");
      }
    }
    while ((this.a.a == null) || (this.a.av != 1)) {
      for (;;)
      {
        Object localObject;
        String str;
        return;
        paramView = "1";
      }
    }
    ChatSettingForTroop.a(this.a, this.a.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dqs
 * JD-Core Version:    0.7.0.1
 */