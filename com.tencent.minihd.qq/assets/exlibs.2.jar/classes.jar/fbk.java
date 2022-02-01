import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class fbk
  implements CompoundButton.OnCheckedChangeListener
{
  public fbk(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean)
    {
      this.a.b.setVisibility(0);
      this.a.a((View)this.a.b.getParent(), false);
      SoundAndVibrateActivity.d(this.a).setBgType(3);
      if (this.a.app.c() == 0)
      {
        this.a.b.setChecked(false);
        this.a.app.f(1);
        label84:
        paramCompoundButton = this.a.app;
        if (!paramBoolean) {
          break label193;
        }
      }
    }
    for (;;)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_shake", 0, i, "", "", "", "");
      return;
      this.a.b.setChecked(true);
      break;
      this.a.b.setVisibility(8);
      this.a.a((View)this.a.b.getParent(), true);
      SoundAndVibrateActivity.d(this.a).setBgType(2);
      this.a.app.f(0);
      break label84;
      label193:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fbk
 * JD-Core Version:    0.7.0.1
 */