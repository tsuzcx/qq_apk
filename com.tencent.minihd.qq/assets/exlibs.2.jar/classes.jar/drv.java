import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView.OnInterceptTouchListener;
import com.tencent.mobileqq.util.SizeMeasure;

public class drv
  implements FPSPinnedHeaderExpandableListView.OnInterceptTouchListener
{
  public drv(Contacts paramContacts) {}
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (SizeMeasure.i(this.a) - paramView.getHeight() > paramView.getHeight() / 4)) {
      this.a.hideSoftPanel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     drv
 * JD-Core Version:    0.7.0.1
 */