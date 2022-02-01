import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatusEditText;

public class jrz
  implements View.OnTouchListener
{
  public jrz(EditActivity paramEditActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (new Rect(EditActivity.a(this.a).getLeft(), EditActivity.a(this.a).getTop(), EditActivity.a(this.a).getRight(), EditActivity.a(this.a).getBottom()).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        EditActivity.a(this.a, false);
      }
    }
    else {
      return false;
    }
    EditActivity.a(this.a, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jrz
 * JD-Core Version:    0.7.0.1
 */