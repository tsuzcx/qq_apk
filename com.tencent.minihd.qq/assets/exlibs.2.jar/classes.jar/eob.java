import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class eob
  implements View.OnClickListener
{
  public eob(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.getActivity(), SoundAndVibrateActivity.class);
    this.a.startActivity(paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "0X800403C", "0X800403C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eob
 * JD-Core Version:    0.7.0.1
 */