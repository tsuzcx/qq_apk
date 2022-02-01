import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.widget.XListView;

public class elr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public elr(NearbyActivity paramNearbyActivity) {}
  
  public void onGlobalLayout()
  {
    if (NearbyActivity.b(this.a) == null) {
      NearbyActivity.a(this.a, this.a.a());
    }
    while (Build.VERSION.SDK_INT < 16)
    {
      this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
      this.a.a(this.a.a());
    }
    this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elr
 * JD-Core Version:    0.7.0.1
 */