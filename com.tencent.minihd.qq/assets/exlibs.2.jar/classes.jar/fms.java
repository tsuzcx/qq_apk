import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.UserguideActivity;

public class fms
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public fms(UserguideActivity paramUserguideActivity) {}
  
  public void onGlobalLayout()
  {
    Log.i("app2", "onGlobalLayout");
    UserguideActivity.a(this.a);
    UserguideActivity.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(UserguideActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fms
 * JD-Core Version:    0.7.0.1
 */