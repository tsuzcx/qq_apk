import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.UserguideFaceMaskActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class fnd
  extends Handler
{
  private WeakReference a;
  
  public fnd(UserguideFaceMaskActivity paramUserguideFaceMaskActivity)
  {
    this.a = new WeakReference(paramUserguideFaceMaskActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {
      return;
    }
    UserguideFaceMaskActivity localUserguideFaceMaskActivity = (UserguideFaceMaskActivity)this.a.get();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleMessage:").append(paramMessage.what).append("  activity:");
      if (localUserguideFaceMaskActivity == null) {
        break label155;
      }
    }
    label155:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("UserguideFaceMaskActivity", 2, bool);
      if (localUserguideFaceMaskActivity == null) {
        break;
      }
      switch (paramMessage.what)
      {
      case 1: 
      default: 
        return;
      case 2: 
        UserguideFaceMaskActivity.a(localUserguideFaceMaskActivity).removeView(UserguideFaceMaskActivity.a(localUserguideFaceMaskActivity));
        localUserguideFaceMaskActivity.a(localUserguideFaceMaskActivity.findViewById(2131300650));
        UserguideFaceMaskActivity.a(localUserguideFaceMaskActivity, localUserguideFaceMaskActivity.findViewById(2131300653));
        UserguideFaceMaskActivity.b(localUserguideFaceMaskActivity, true);
        return;
      }
    }
    UserguideFaceMaskActivity.a(localUserguideFaceMaskActivity);
    return;
    UserguideFaceMaskActivity.d(localUserguideFaceMaskActivity);
    return;
    UserguideFaceMaskActivity.b(localUserguideFaceMaskActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fnd
 * JD-Core Version:    0.7.0.1
 */