package com.tencent.mm.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.sdk.platformtools.y;

public final class c$2
  implements Animator.AnimatorListener
{
  public c$2(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.buy.bur = true;
    this.buy.buw = 0.0F;
    this.buy.bux = 0.0F;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.buy.bur = true;
    this.buy.buw = 0.0F;
    this.buy.bux = 0.0F;
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.buy.bur = false;
    this.buy.buw = 0.0F;
    this.buy.bux = 0.0F;
    y.d("MicroMsg.StickBackAnim", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.b.c.2
 * JD-Core Version:    0.7.0.1
 */