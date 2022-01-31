package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.view.View;

final class ShuffleView$4
  implements Animator.AnimatorListener
{
  ShuffleView$4(ShuffleView paramShuffleView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    ShuffleView.a(this.lPv, false);
    ShuffleView.u(this.lPv).setVisibility(0);
    if (ShuffleView.v(this.lPv) != null) {
      ShuffleView.v(this.lPv).start();
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    ShuffleView.a(this.lPv, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.4
 * JD-Core Version:    0.7.0.1
 */