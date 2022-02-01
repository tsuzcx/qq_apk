import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class dqr
  implements View.OnClickListener
{
  public dqr(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.isFinishing()) && (this.a.a != null) && (this.a.app != null)) {
      ReportPlugin.a(this.a, 301, this.a.a.c, "", this.a.app.getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dqr
 * JD-Core Version:    0.7.0.1
 */