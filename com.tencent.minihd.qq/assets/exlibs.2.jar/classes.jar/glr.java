import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.ImageView;

class glr
  extends AnimatorListenerAdapter
{
  glr(glo paramglo) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.f.setVisibility(8);
    this.a.g.setVisibility(8);
    this.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     glr
 * JD-Core Version:    0.7.0.1
 */