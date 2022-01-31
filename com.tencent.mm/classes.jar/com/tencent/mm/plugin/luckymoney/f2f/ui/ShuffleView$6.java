package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class ShuffleView$6
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$6(ShuffleView paramShuffleView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (ShuffleView.z(this.lPv) != null) {
      ShuffleView.z(this.lPv).a(paramValueAnimator, ShuffleView.w(this.lPv));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.6
 * JD-Core Version:    0.7.0.1
 */