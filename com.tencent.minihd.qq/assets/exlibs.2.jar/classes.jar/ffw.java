import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ffw
  implements ActionSheet.OnButtonClickListener
{
  public ffw(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    boolean bool = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      TroopAssistantActivity.a(this.a).dismiss();
      return;
      paramView = this.a;
      if (!TroopAssistantActivity.a(this.a)) {
        bool = true;
      }
      TroopAssistantActivity.a(paramView, bool);
      TroopAssistantManager.a().b(this.a.app, TroopAssistantActivity.a(this.a));
      continue;
      paramView = new Intent(this.a, TroopAssisSettingActivity.class);
      paramView.setFlags(67108864);
      this.a.startActivity(paramView);
      ReportController.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
      continue;
      TroopAssistantManager.a().a(this.a.app, false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ffw
 * JD-Core Version:    0.7.0.1
 */