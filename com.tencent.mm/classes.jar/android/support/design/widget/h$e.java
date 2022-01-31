package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

abstract class h$e
  extends AnimatorListenerAdapter
  implements ValueAnimator.AnimatorUpdateListener
{
  private boolean jM;
  private float jN;
  private float jO;
  
  private h$e(h paramh) {}
  
  protected abstract float bA();
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jL.jy.n(this.jO);
    this.jM = false;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.jM)
    {
      this.jN = this.jL.jy.kv;
      this.jO = bA();
      this.jM = true;
    }
    this.jL.jy.n(this.jN + (this.jO - this.jN) * paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.h.e
 * JD-Core Version:    0.7.0.1
 */