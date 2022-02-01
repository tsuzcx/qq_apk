import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SetTroopAdminsActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class ezw
  implements View.OnClickListener
{
  public ezw(SetTroopAdminsActivity paramSetTroopAdminsActivity) {}
  
  public void onClick(View paramView)
  {
    if ((SetTroopAdminsActivity.a(this.a) > 0) && (SetTroopAdminsActivity.a(this.a) <= SetTroopAdminsActivity.a(this.a).size()))
    {
      QQToast.a(this.a, 1, String.format(this.a.getString(2131365846), new Object[] { Integer.valueOf(SetTroopAdminsActivity.a(this.a)) }), 0).b(this.a.getTitleBarHeight());
      return;
    }
    paramView = TroopMemberListActivity.a(this.a, SetTroopAdminsActivity.a(this.a), 2);
    this.a.startActivityForResult(paramView, 0);
    ReportController.b(this.a.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, SetTroopAdminsActivity.a(this.a), "3", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ezw
 * JD-Core Version:    0.7.0.1
 */