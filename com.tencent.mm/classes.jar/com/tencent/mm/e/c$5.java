package com.tencent.mm.e;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

public final class c$5
  implements Animator.AnimatorListener
{
  public c$5(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    c.b(this.bAK).mA = null;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    c.b(this.bAK).mA = null;
    c.c(this.bAK);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.c.5
 * JD-Core Version:    0.7.0.1
 */