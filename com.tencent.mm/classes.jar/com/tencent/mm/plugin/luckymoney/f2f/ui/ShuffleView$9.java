package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class ShuffleView$9
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$9(ShuffleView paramShuffleView, int paramInt1, int paramInt2) {}
  
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
      while (i < ShuffleView.f(this.lPv) - 1)
      {
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(i)).floatValue() * (1.0F - f) + (this.lPv.ti(i) - (i + 1) * ShuffleView.g(this.lPv)) * f);
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationY(((Float)ShuffleView.c(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.tj(i) * f);
        i += 1;
      }
      ((View)ShuffleView.e(this.lPv).get(ShuffleView.f(this.lPv) - 1)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(ShuffleView.f(this.lPv) - 1)).floatValue() * (1.0F - f) + (this.lPv.ti(ShuffleView.f(this.lPv) - 1) - ShuffleView.g(this.lPv) * this.lPx / 2.0F) * f);
      ((View)ShuffleView.e(this.lPv).get(ShuffleView.f(this.lPv) - 1)).setTranslationY(((Float)ShuffleView.c(this.lPv).get(ShuffleView.f(this.lPv) - 1)).floatValue() * (1.0F - f) + this.lPv.tj(ShuffleView.f(this.lPv) - 1) * f);
    }
    while (this.lPy > 0)
    {
      ShuffleView.h(this.lPv).setTranslationX(((Float)ShuffleView.b(this.lPv).get(ShuffleView.f(this.lPv))).floatValue() * (1.0F - f) + (this.lPv.ti(ShuffleView.f(this.lPv)) + ShuffleView.g(this.lPv) * this.lPy / 2.0F) * f);
      i = ShuffleView.f(this.lPv) + 1;
      while (i < ShuffleView.d(this.lPv))
      {
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(i)).floatValue() * (1.0F - f) + (this.lPv.ti(i) + (ShuffleView.d(this.lPv) - i) * ShuffleView.g(this.lPv)) * f);
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationY(((Float)ShuffleView.c(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.tj(i) * f);
        i += 1;
      }
      i = 0;
      while (i < ShuffleView.f(this.lPv))
      {
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.ti(i) * f);
        ((View)ShuffleView.e(this.lPv).get(i)).setTranslationY(((Float)ShuffleView.c(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.tj(i) * f);
        i += 1;
      }
    }
    i = ShuffleView.f(this.lPv);
    while (i < ShuffleView.d(this.lPv))
    {
      ((View)ShuffleView.e(this.lPv).get(i)).setTranslationX(((Float)ShuffleView.b(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.ti(i) * f);
      ((View)ShuffleView.e(this.lPv).get(i)).setTranslationY(((Float)ShuffleView.c(this.lPv).get(i)).floatValue() * (1.0F - f) + this.lPv.tj(i) * f);
      i += 1;
    }
    ShuffleView.h(this.lPv).setTranslationY(((Float)ShuffleView.c(this.lPv).get(ShuffleView.f(this.lPv))).floatValue() * (1.0F - f) - ShuffleView.h(this.lPv).getHeight() * f / 7.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.9
 * JD-Core Version:    0.7.0.1
 */