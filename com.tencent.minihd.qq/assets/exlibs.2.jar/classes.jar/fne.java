import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.UserguideThirdActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class fne
  extends Handler
{
  private WeakReference a;
  
  public fne(UserguideThirdActivity paramUserguideThirdActivity)
  {
    this.a = new WeakReference(paramUserguideThirdActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {
      return;
    }
    UserguideThirdActivity localUserguideThirdActivity = (UserguideThirdActivity)this.a.get();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleMessage:").append(paramMessage.what).append("  activity:");
      if (localUserguideThirdActivity == null) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("UserguideThirdActivity", 2, bool);
      if (localUserguideThirdActivity == null) {
        break;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        localUserguideThirdActivity.b(UserguideThirdActivity.a(localUserguideThirdActivity));
        UserguideThirdActivity.a(localUserguideThirdActivity).sendEmptyMessageDelayed(2, 500L);
        return;
      }
    }
    localUserguideThirdActivity.b(UserguideThirdActivity.b(localUserguideThirdActivity));
    UserguideThirdActivity.a(localUserguideThirdActivity).sendEmptyMessageDelayed(3, 500L);
    return;
    localUserguideThirdActivity.b(UserguideThirdActivity.c(localUserguideThirdActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fne
 * JD-Core Version:    0.7.0.1
 */