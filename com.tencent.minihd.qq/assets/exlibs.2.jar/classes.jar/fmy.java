import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.UserguideFaceMaskActivity;
import com.tencent.qphone.base.util.QLog;

class fmy
  implements Animation.AnimationListener
{
  fmy(fmx paramfmx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserguideFaceMaskActivity", 2, "flash animation end");
    }
    UserguideFaceMaskActivity.a(this.a.a).setVisibility(4);
    UserguideFaceMaskActivity.a(this.a.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserguideFaceMaskActivity", 2, "flash animation onAnimationRepeat");
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fmy
 * JD-Core Version:    0.7.0.1
 */