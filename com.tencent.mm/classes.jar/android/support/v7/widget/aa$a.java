package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

final class aa$a
  extends AnimatorListenerAdapter
{
  private boolean pP = false;
  
  private aa$a(aa paramaa) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.pP = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.pP)
    {
      this.pP = false;
      return;
    }
    if (((Float)aa.a(this.acR).getAnimatedValue()).floatValue() == 0.0F)
    {
      aa.a(this.acR, 0);
      aa.b(this.acR);
      return;
    }
    aa.a(this.acR, 2);
    aa.c(this.acR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.aa.a
 * JD-Core Version:    0.7.0.1
 */