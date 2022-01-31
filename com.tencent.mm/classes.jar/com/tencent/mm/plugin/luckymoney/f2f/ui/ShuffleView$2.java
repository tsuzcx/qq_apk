package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class ShuffleView$2
  implements Animator.AnimatorListener
{
  ShuffleView$2(ShuffleView paramShuffleView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    ShuffleView.a(this.lPv, false);
    ShuffleView.a(this.lPv, null);
    ShuffleView.d(this.lPv, -1);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    ShuffleView.a(this.lPv, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.2
 * JD-Core Version:    0.7.0.1
 */