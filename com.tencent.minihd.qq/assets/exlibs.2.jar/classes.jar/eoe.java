import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class eoe
  extends Handler
{
  public eoe(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        default: 
          return;
        }
      }
      finally {}
      boolean bool = ((Boolean)paramMessage.obj).booleanValue();
      NotifyPushSettingActivity.f(this.a).setChecked(bool);
      continue;
      paramMessage = (String)paramMessage.obj;
      NotifyPushSettingActivity.a(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eoe
 * JD-Core Version:    0.7.0.1
 */