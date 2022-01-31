package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

final class z$a
  extends AnimatorListenerAdapter
{
  private boolean qM = false;
  
  private z$a(z paramz) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.qM = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.qM)
    {
      this.qM = false;
      return;
    }
    if (((Float)z.a(this.adB).getAnimatedValue()).floatValue() == 0.0F)
    {
      z.a(this.adB, 0);
      z.b(this.adB);
      return;
    }
    z.a(this.adB, 2);
    z.c(this.adB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.z.a
 * JD-Core Version:    0.7.0.1
 */