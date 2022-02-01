import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.fpsreport.FPSSwipListView.OnInterceptTouchListener;
import com.tencent.mobileqq.util.SizeMeasure;

public class dtn
  implements FPSSwipListView.OnInterceptTouchListener
{
  public dtn(Conversation paramConversation) {}
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (SizeMeasure.i(paramView.getContext()) - paramView.getHeight() > paramView.getHeight() / 4)) {
      this.a.hideSoftPanel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtn
 * JD-Core Version:    0.7.0.1
 */