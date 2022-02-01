import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class eof
  extends BroadcastReceiver
{
  public eof(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      NotifyPushSettingActivity.a(this.a, paramContext);
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive"));
      paramContext = paramIntent.getStringExtra("uin");
      bool = paramIntent.getBooleanExtra("configPCActive", false);
    } while (!this.a.app.getAccount().equals(paramContext));
    if (true == bool)
    {
      NotifyPushSettingActivity.f(this.a).setVisibility(0);
      return;
    }
    NotifyPushSettingActivity.f(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eof
 * JD-Core Version:    0.7.0.1
 */