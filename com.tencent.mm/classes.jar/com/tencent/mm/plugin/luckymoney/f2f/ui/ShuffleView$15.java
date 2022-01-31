package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class ShuffleView$15
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$15(ShuffleView paramShuffleView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = 0;
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f1 == 0.0F)
    {
      ShuffleView.b(this.lPv).clear();
      ShuffleView.c(this.lPv).clear();
      while (i < ShuffleView.d(this.lPv))
      {
        ShuffleView.b(this.lPv).add(Float.valueOf(((View)ShuffleView.e(this.lPv).get(i)).getTranslationX()));
        ShuffleView.c(this.lPv).add(Float.valueOf(((View)ShuffleView.e(this.lPv).get(i)).getTranslationY()));
        i += 1;
      }
    }
    i = 0;
    if (i < ShuffleView.d(this.lPv))
    {
      View localView = (View)ShuffleView.e(this.lPv).get(i);
      float f2;
      float f3;
      if (ShuffleView.l(this.lPv).lPz == 1)
      {
        f2 = ShuffleView.l(this.lPv).scaleX;
        f3 = i + 1;
        localView.setScaleX(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.lPv).scaleX + (1.0F - f2 * f3));
        f2 = this.lPv.tj(i);
        localView.setTranslationY(((Float)ShuffleView.c(this.lPv).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
      }
      for (;;)
      {
        i += 1;
        break;
        if (ShuffleView.l(this.lPv).lPz == 2)
        {
          f2 = ShuffleView.l(this.lPv).scaleY;
          f3 = i + 1;
          localView.setScaleY(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.lPv).scaleY + (1.0F - f2 * f3));
          f2 = this.lPv.ti(i);
          localView.setTranslationX(((Float)ShuffleView.b(this.lPv).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.15
 * JD-Core Version:    0.7.0.1
 */