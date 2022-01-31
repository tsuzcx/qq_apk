package com.tencent.mm.e;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class c$4
  implements Animator.AnimatorListener
{
  c$4(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    c.a(this.bAK, false);
    paramAnimator.removeAllListeners();
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    c.a(this.bAK, true);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.bAK.bAy = true;
    c.a(this.bAK, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.c.4
 * JD-Core Version:    0.7.0.1
 */