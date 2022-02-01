import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class fhx
  implements View.OnClickListener
{
  public fhx(TroopManageActivity paramTroopManageActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = "";
    try
    {
      if (1L == this.a.a.dwAdditionalFlag) {
        localObject = "0";
      }
      for (;;)
      {
        ReportController.b(this.a.app, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_data", 0, 0, this.a.a.troopuin, (String)localObject, "", "");
        paramView = (String)paramView.getTag();
        paramView = paramView + "&gc=" + this.a.a.troopuin;
        paramView = paramView + "&src=2";
        localObject = new Intent(this.a, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        this.a.startActivity((Intent)localObject);
        return;
        if (1L == this.a.a.dwCmdUinUinFlag) {
          localObject = "1";
        }
      }
      return;
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopmanage", 2, "go to statics h5 url error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhx
 * JD-Core Version:    0.7.0.1
 */