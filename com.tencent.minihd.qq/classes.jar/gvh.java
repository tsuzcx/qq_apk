import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fpsreport.FPSSwipListView.OnInterceptTouchListener;
import com.tencent.mobileqq.util.SizeMeasure;

public class gvh
  implements FPSSwipListView.OnInterceptTouchListener
{
  public gvh(RecentCallHelper paramRecentCallHelper, BaseActivity paramBaseActivity) {}
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (SizeMeasure.i(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity) - paramView.getHeight() > paramView.getHeight() / 4)) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.hideSoftPanel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvh
 * JD-Core Version:    0.7.0.1
 */