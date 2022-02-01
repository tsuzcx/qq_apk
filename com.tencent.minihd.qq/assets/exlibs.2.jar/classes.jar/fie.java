import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class fie
  implements View.OnClickListener
{
  public fie(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_set", 0, 0, this.a.c, "", "", "");
    this.a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fie
 * JD-Core Version:    0.7.0.1
 */