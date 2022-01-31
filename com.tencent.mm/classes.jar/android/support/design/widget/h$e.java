package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

abstract class h$e
  extends AnimatorListenerAdapter
  implements ValueAnimator.AnimatorUpdateListener
{
  private boolean iT;
  private float iU;
  private float iV;
  
  private h$e(h paramh) {}
  
  protected abstract float aR();
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.iS.iF.m(this.iV);
    this.iT = false;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.iT)
    {
      this.iU = this.iS.iF.jx;
      this.iV = aR();
      this.iT = true;
    }
    this.iS.iF.m(this.iU + (this.iV - this.iU) * paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.h.e
 * JD-Core Version:    0.7.0.1
 */