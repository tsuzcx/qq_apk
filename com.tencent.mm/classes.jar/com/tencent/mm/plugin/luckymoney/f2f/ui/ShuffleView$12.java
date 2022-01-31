package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class ShuffleView$12
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$12(ShuffleView paramShuffleView, int paramInt1, int paramInt2) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = 0;
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f == 0.0F)
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
    if (this.lPx > 0)
    {
      i = 0;
      while (i < ShuffleView.i(this.lPv) - 1)
      {
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(i)).floatValue() * (1.0F - f) + (this.lPv.ti(i) - (i + 1) * ShuffleView.j(this.lPv)) * f);
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationY(((Float)ShuffleView.c(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.tj(i) * f);
        i += 1;
      }
      ((View)ShuffleView.e(this.lPv).get(ShuffleView.i(this.lPv) - 1)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(ShuffleView.i(this.lPv) - 1)).floatValue() * (1.0F - f) + (this.lPv.ti(ShuffleView.i(this.lPv) - 1) - ShuffleView.j(this.lPv) * this.lPx / 2.0F) * f);
    }
    while (this.lPy > 0)
    {
      ShuffleView.k(this.lPv).setTranslationX(((Float)ShuffleView.b(this.lPv).get(ShuffleView.i(this.lPv))).floatValue() * (1.0F - f) + (this.lPv.ti(ShuffleView.i(this.lPv)) + ShuffleView.j(this.lPv) * this.lPy / 2.0F) * f);
      ShuffleView.k(this.lPv).setTranslationY(((Float)ShuffleView.c(this.lPv).get(ShuffleView.i(this.lPv))).floatValue() * (1.0F - f) + this.lPv.tj(ShuffleView.i(this.lPv)) * f);
      i = ShuffleView.i(this.lPv) + 1;
      while (i < ShuffleView.d(this.lPv))
      {
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(i)).floatValue() * (1.0F - f) + (this.lPv.ti(i) + (ShuffleView.d(this.lPv) - i) * ShuffleView.j(this.lPv)) * f);
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationY(((Float)ShuffleView.c(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.tj(i) * f);
        i += 1;
      }
      i = 0;
      while (i < ShuffleView.i(this.lPv))
      {
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.ti(i) * f);
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationY(((Float)ShuffleView.c(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.tj(i) * f);
        i += 1;
      }
    }
    i = ShuffleView.i(this.lPv);
    while (i < ShuffleView.d(this.lPv))
    {
      ((View)ShuffleView.e(this.lPv).get(i)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.ti(i) * f);
      ((View)ShuffleView.e(this.lPv).get(i)).setTranslationY(((Float)ShuffleView.c(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.tj(i) * f);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.12
 * JD-Core Version:    0.7.0.1
 */