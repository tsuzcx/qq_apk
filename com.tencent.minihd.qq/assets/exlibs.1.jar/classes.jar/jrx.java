import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mobileqq.richstatus.EditActivity;

public class jrx
  implements View.OnKeyListener
{
  public jrx(EditActivity paramEditActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (paramKeyEvent.getAction() == 0))
    {
      this.a.b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jrx
 * JD-Core Version:    0.7.0.1
 */