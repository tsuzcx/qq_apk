import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistSetGuideActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class fft
  implements View.OnClickListener
{
  public fft(TroopAssistSetGuideActivity paramTroopAssistSetGuideActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302379: 
      TroopAssistSetGuideActivity.a(this.a);
      ReportController.b(this.a.app, "CliOper", "", "", "Grp_helper", "Clk_not_set", 0, 0, "", "", "", "");
      return;
    }
    TroopAssistSetGuideActivity.b(this.a);
    ReportController.b(this.a.app, "CliOper", "", "", "Grp_helper", "Clk_quiet_mode", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fft
 * JD-Core Version:    0.7.0.1
 */