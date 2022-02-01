import android.view.View;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.widget.ScrollerRunnable;

public class kyx
  implements Runnable
{
  public kyx(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void run()
  {
    kyz localkyz1 = new kyz(this.jdField_a_of_type_AndroidViewView, 1.0F, 0.0F);
    localkyz1.setFillEnabled(true);
    localkyz1.setDuration(700L);
    kyz localkyz2 = new kyz(this.jdField_a_of_type_AndroidViewView, 0.0F, 1.0F);
    localkyz2.setFillEnabled(true);
    localkyz2.setStartTime(700L);
    localkyz2.setDuration(700L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localkyz1);
    localAnimationSet.addAnimation(localkyz2);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new kyy(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kyx
 * JD-Core Version:    0.7.0.1
 */