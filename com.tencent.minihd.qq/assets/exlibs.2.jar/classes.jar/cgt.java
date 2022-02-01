import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchActivity;

public class cgt
  implements View.OnTouchListener
{
  public cgt(SearchActivity paramSearchActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      SearchActivity.b(this.a);
      SearchActivity.a(this.a).clearFocus();
      SearchActivity.a(this.a).setCursorVisible(false);
      paramView = SearchActivity.a(this.a).getText().toString();
      this.a.a(paramView);
      SearchActivity.a(this.a).setSelection(paramView.length());
      SearchActivity.a(this.a, false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgt
 * JD-Core Version:    0.7.0.1
 */