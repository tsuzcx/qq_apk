import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.flaotaio.BaseFloatChatPie;
import com.tencent.widget.XListView.MotionEventInterceptor;

public class gkq
  implements XListView.MotionEventInterceptor
{
  public gkq(BaseFloatChatPie paramBaseFloatChatPie) {}
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a.q();
      this.a.a = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gkq
 * JD-Core Version:    0.7.0.1
 */