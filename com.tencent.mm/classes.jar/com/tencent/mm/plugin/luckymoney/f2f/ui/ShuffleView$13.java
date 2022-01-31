package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class ShuffleView$13
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$13(ShuffleView paramShuffleView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f == 0.0F)
    {
      ShuffleView.b(this.lPv).clear();
      ShuffleView.c(this.lPv).clear();
      i = 0;
      while (i < ShuffleView.d(this.lPv))
      {
        ShuffleView.b(this.lPv).add(Float.valueOf(((View)ShuffleView.e(this.lPv).get(i)).getTranslationX()));
        ShuffleView.c(this.lPv).add(Float.valueOf(((View)ShuffleView.e(this.lPv).get(i)).getTranslationY()));
        i += 1;
      }
    }
    ((View)ShuffleView.e(this.lPv).get(0)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(0)).floatValue() * (1.0F - f) + this.lPv.ti(0) * f);
    ((View)ShuffleView.e(this.lPv).get(0)).setTranslationY(((Float)ShuffleView.c(this.lPv).get(0)).floatValue() * (1.0F - f) + this.lPv.tj(0) * f);
    int i = 1;
    while (i < ShuffleView.d(this.lPv))
    {
      ((View)ShuffleView.e(this.lPv).get(i)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.ti(i) * f);
      ((View)ShuffleView.e(this.lPv).get(i)).setTranslationY(((Float)ShuffleView.c(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.tj(i) * f);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.13
 * JD-Core Version:    0.7.0.1
 */