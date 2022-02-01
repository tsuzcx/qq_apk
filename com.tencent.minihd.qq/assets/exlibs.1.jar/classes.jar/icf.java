import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.dating.DatingUserCenterActivity;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class icf
  implements TabBarView.OnTabChangeListener
{
  public icf(DatingUserCenterActivity paramDatingUserCenterActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    Message localMessage = new Message();
    localMessage.what = 4100;
    localMessage.arg1 = paramInt2;
    if (this.a.isResume())
    {
      DatingUserCenterActivity.a(this.a).sendMessageDelayed(localMessage, 180L);
      return;
    }
    DatingUserCenterActivity.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     icf
 * JD-Core Version:    0.7.0.1
 */