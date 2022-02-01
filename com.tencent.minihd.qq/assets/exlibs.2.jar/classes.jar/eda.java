import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDManualGuideActivity;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

public class eda
  implements View.OnClickListener
{
  public eda(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131297762: 
    case 2131297763: 
    case 2131297766: 
    case 2131297767: 
    default: 
      return;
    case 2131297761: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.a(), 20);
      this.a.a();
      return;
    case 2131297765: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.a(), 21);
      this.a.a();
      return;
    case 2131297764: 
      paramView = new Intent(this.a, GesturePWDManualGuideActivity.class);
      this.a.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a, GesturePWDCreateActivity.class);
    this.a.startActivityForResult(paramView, 11);
    this.a.overridePendingTransition(2130968595, 2130968592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eda
 * JD-Core Version:    0.7.0.1
 */