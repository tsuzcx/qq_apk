import android.view.View;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.widget.QQMapView;

public class cay
  implements ValueAnimation.AnimationUpdateListener
{
  public cay(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramValueAnimation = PoiMapActivity.g(this.a).getLayoutParams();
    paramValueAnimation.height = paramInteger.intValue();
    PoiMapActivity.h(this.a).setLayoutParams(paramValueAnimation);
    paramValueAnimation = (RelativeLayout.LayoutParams)this.a.b.getLayoutParams();
    paramValueAnimation.bottomMargin = (this.a.r - paramInteger.intValue());
    this.a.b.setLayoutParams(paramValueAnimation);
    int i = (paramInteger.intValue() - PoiMapActivity.c(this.a) - this.a.v) / 2;
    if (i >= (this.a.r - PoiMapActivity.d(this.a)) / 2 + this.a.w) {
      PoiMapActivity.a(this.a, i, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cay
 * JD-Core Version:    0.7.0.1
 */