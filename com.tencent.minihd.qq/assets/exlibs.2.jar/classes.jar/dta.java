import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.provider.Settings.System;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;

public class dta
  extends BroadcastReceiver
{
  public dta(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.TIME_SET".equals(paramContext)) || ("android.intent.action.TIMEZONE_CHANGED".equals(paramContext)) || ("android.intent.action.DATE_CHANGED".equals(paramContext)))
    {
      paramContext = Settings.System.getString(this.a.getActivity().getContentResolver(), "date_format");
      if (Conversation.a(this.a) != null)
      {
        TimeManager.a().a();
        if (paramContext != null)
        {
          TimeManager.a().a(paramContext);
          TimeManager.a().a();
        }
        if (Conversation.a(this.a)) {
          Conversation.a(this.a, 1014, 0L, false);
        }
      }
      SubAccountControll.b(this.a.app, paramContext);
      if (this.a.app != null)
      {
        paramContext = this.a.app.a(TroopAssistantActivity.class);
        if (paramContext != null) {
          paramContext.sendEmptyMessage(2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dta
 * JD-Core Version:    0.7.0.1
 */