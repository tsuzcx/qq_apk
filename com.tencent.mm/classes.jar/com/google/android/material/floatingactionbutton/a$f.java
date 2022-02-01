package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

abstract class a$f
  extends AnimatorListenerAdapter
  implements ValueAnimator.AnimatorUpdateListener
{
  private boolean bBc;
  private float bBd;
  private float bBe;
  
  private a$f(a parama) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.bBb.bAE.Y(this.bBe);
    this.bBc = false;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.bBc)
    {
      this.bBd = this.bBb.bAE.bDN;
      this.bBe = xh();
      this.bBc = true;
    }
    this.bBb.bAE.Y(this.bBd + (this.bBe - this.bBd) * paramValueAnimator.getAnimatedFraction());
  }
  
  protected abstract float xh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.a.f
 * JD-Core Version:    0.7.0.1
 */