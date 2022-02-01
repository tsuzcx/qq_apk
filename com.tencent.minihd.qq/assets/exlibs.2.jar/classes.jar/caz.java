import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class caz
  implements Animation.AnimationListener
{
  public caz(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = PoiMapActivity.i(this.a).getLayoutParams();
    paramAnimation.height = this.a.r;
    PoiMapActivity.j(this.a).setLayoutParams(paramAnimation);
    paramAnimation = (RelativeLayout.LayoutParams)this.a.jdField_b_of_type_AndroidViewView.getLayoutParams();
    paramAnimation.bottomMargin = 0;
    this.a.jdField_b_of_type_AndroidViewView.setLayoutParams(paramAnimation);
    PoiMapActivity.a(this.a, (this.a.r - PoiMapActivity.e(this.a)) / 2 + this.a.w, false);
    if (this.a.i != null) {
      this.a.i.setVisibility(8);
    }
    PoiMapActivity.c(this.a).clearAnimation();
    this.a.jdField_b_of_type_Boolean = true;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     caz
 * JD-Core Version:    0.7.0.1
 */