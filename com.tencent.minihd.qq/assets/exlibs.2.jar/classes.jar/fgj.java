import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;

public class fgj
  implements View.OnClickListener
{
  public fgj(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      return;
    case 0: 
      paramView = this.a;
      if (!TroopAssistantActivity.a(this.a)) {
        bool = true;
      }
      TroopAssistantActivity.a(paramView, bool);
      TroopAssistantManager.a().b(this.a.app, TroopAssistantActivity.a(this.a));
      return;
    case 1: 
      paramView = new Intent(this.a, TroopAssisSettingActivity.class);
      paramView.setFlags(67108864);
      this.a.startActivity(paramView);
      ReportController.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
      return;
    }
    TroopAssistantManager.a().a(this.a.app, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fgj
 * JD-Core Version:    0.7.0.1
 */