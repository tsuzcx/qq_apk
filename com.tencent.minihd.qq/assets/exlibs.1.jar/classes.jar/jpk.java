import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class jpk
  implements View.OnTouchListener
{
  public jpk(QCallDetailActivity paramQCallDetailActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      QCallDetailActivity.a(this.a).setPressed(true);
    }
    while (1 != paramMotionEvent.getAction()) {
      return false;
    }
    QCallDetailActivity.a(this.a).setPressed(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jpk
 * JD-Core Version:    0.7.0.1
 */