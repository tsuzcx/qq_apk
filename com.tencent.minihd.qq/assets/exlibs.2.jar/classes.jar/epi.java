import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.RecommendedGatherListActivity;
import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class epi
  implements View.OnClickListener
{
  public epi(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.a)
    {
      this.a.a();
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramView == this.a.d)
      {
        paramView = QZoneHelper.UserInfo.a();
        paramView.a = this.a.app.a();
        paramView.b = this.a.app.c();
        paramView.c = this.a.app.getSid();
        QZoneHelper.b(this.a, paramView, -1);
        return;
      }
      if (paramView == PermisionPrivacyActivity.a(this.a))
      {
        StrangerManageActivity.a(this.a);
        ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Manage_stranger_clk", 0, 0, "", "", "", "");
        return;
      }
    } while (paramView != PermisionPrivacyActivity.a(this.a));
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004C47", "0X8004C47", 3, 0, "", "", "", "");
    paramView = new Intent(this.a, RecommendedGatherListActivity.class);
    paramView.putExtra("actionFromQQSetting", true);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     epi
 * JD-Core Version:    0.7.0.1
 */