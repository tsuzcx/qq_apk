import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.qphone.base.util.QLog;

public class bza
  extends BroadcastReceiver
{
  public bza(SmallScreenService paramSmallScreenService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.NEW_OUTGOING_CALL"))
    {
      paramContext = paramIntent.getStringExtra("android.intent.extra.PHONE_NUMBER");
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "onReceive NEW_OUTGOING_CALL phoneNumber = " + paramContext);
      }
    }
    while ((!paramContext.equals("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED")) || (this.a.a == null)) {
      return;
    }
    this.a.a().removeCallbacks(this.a.a);
    this.a.a.a = 0L;
    this.a.a().postDelayed(this.a.a, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     bza
 * JD-Core Version:    0.7.0.1
 */