import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class fii
  implements View.OnClickListener
{
  public fii(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)this.a.getSystemService("clipboard")).setText(this.a.e);
    }
    for (;;)
    {
      ReportController.b(this.a.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_copyinfo", 0, 0, this.a.c, "", "", "");
      return;
      ((android.content.ClipboardManager)this.a.getSystemService("clipboard")).setText(this.a.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fii
 * JD-Core Version:    0.7.0.1
 */