package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.List;

final class ShuffleView$5
  implements Animator.AnimatorListener
{
  ShuffleView$5(ShuffleView paramShuffleView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    ShuffleView.e(this.lPv).remove(ShuffleView.w(this.lPv));
    if (ShuffleView.x(this.lPv) != null) {
      ShuffleView.x(this.lPv).start();
    }
    ShuffleView.f(this.lPv, ShuffleView.f(this.lPv));
    if (ShuffleView.d(this.lPv) > 0)
    {
      ShuffleView.e(this.lPv, ShuffleView.y(this.lPv));
      ShuffleView.b(this.lPv, (View)ShuffleView.e(this.lPv).get(ShuffleView.f(this.lPv)));
      return;
    }
    ShuffleView.b(this.lPv, null);
    ShuffleView.e(this.lPv, 0);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.5
 * JD-Core Version:    0.7.0.1
 */