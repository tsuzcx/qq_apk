import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.flaotaio.FloatImagePreview;

public class gmk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public gmk(FloatImagePreview paramFloatImagePreview) {}
  
  public void onGlobalLayout()
  {
    FloatImagePreview.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gmk
 * JD-Core Version:    0.7.0.1
 */