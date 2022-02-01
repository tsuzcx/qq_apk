import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class cas
  implements ViewTreeObserver.OnPreDrawListener
{
  public cas(PoiMapActivity paramPoiMapActivity) {}
  
  public boolean onPreDraw()
  {
    this.a.r = PoiMapActivity.e(this.a).getMeasuredHeight();
    PoiMapActivity.a(this.a, PoiMapActivity.a(this.a).getMeasuredHeight());
    if ((this.a.r > 0) && (PoiMapActivity.a(this.a) > 0))
    {
      PoiMapActivity.a(this.a, (this.a.r - PoiMapActivity.b(this.a)) / 2 + this.a.w, false);
      PoiMapActivity.f(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
      PoiMapActivity.b(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cas
 * JD-Core Version:    0.7.0.1
 */