import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class cbb
  implements Animation.AnimationListener
{
  public cbb(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = PoiMapActivity.m(this.a).getLayoutParams();
    paramAnimation.height = (this.a.r + this.a.s);
    PoiMapActivity.n(this.a).setLayoutParams(paramAnimation);
    paramAnimation = (RelativeLayout.LayoutParams)this.a.jdField_b_of_type_AndroidViewView.getLayoutParams();
    paramAnimation.bottomMargin = (-this.a.s);
    this.a.jdField_b_of_type_AndroidViewView.setLayoutParams(paramAnimation);
    PoiMapActivity.a(this.a, (this.a.r + this.a.s - PoiMapActivity.h(this.a) - this.a.v) / 2, false);
    if (this.a.i != null) {
      this.a.i.setVisibility(0);
    }
    PoiMapActivity.d(this.a).clearAnimation();
    this.a.jdField_b_of_type_Boolean = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cbb
 * JD-Core Version:    0.7.0.1
 */