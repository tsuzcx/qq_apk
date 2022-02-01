import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;

public class jsq
  extends GestureDetector.SimpleOnGestureListener
{
  public jsq(StatusHistoryActivity paramStatusHistoryActivity, int paramInt) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
    if ((paramFloat1 <= -this.jdField_a_of_type_Int) && (paramFloat2 < 0.5F)) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity.finish();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jsq
 * JD-Core Version:    0.7.0.1
 */