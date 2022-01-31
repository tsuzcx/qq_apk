package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class ShuffleView$7
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$7(ShuffleView paramShuffleView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (ShuffleView.A(this.lPv) != null) {
      ShuffleView.A(this.lPv).a(paramValueAnimator, ShuffleView.u(this.lPv));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.7
 * JD-Core Version:    0.7.0.1
 */