import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;

public class geu
  implements View.OnTouchListener
{
  public geu(SearchResultDialog paramSearchResultDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    SearchResultDialog.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     geu
 * JD-Core Version:    0.7.0.1
 */