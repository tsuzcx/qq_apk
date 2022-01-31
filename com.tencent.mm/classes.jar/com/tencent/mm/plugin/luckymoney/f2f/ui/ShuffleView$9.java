package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class ShuffleView$9
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$9(ShuffleView paramShuffleView, int paramInt1, int paramInt2) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = 0;
    AppMethodBeat.i(42234);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f == 0.0F)
    {
      ShuffleView.b(this.omN).clear();
      ShuffleView.c(this.omN).clear();
      while (i < ShuffleView.d(this.omN))
      {
        ShuffleView.b(this.omN).add(Float.valueOf(((View)ShuffleView.e(this.omN).get(i)).getTranslationX()));
        ShuffleView.c(this.omN).add(Float.valueOf(((View)ShuffleView.e(this.omN).get(i)).getTranslationY()));
        i += 1;
      }
      AppMethodBeat.o(42234);
      return;
    }
    if (this.omP > 0)
    {
      i = 0;
      while (i < ShuffleView.f(this.omN) - 1)
      {
        ((View)ShuffleView.e(this.omN).get(i)).setTranslationX(((Float)ShuffleView.b(this.omN).get(i)).floatValue() * (1.0F - f) + (this.omN.yk(i) - (i + 1) * ShuffleView.g(this.omN)) * f);
        ((View)ShuffleView.e(this.omN).get(i)).setTranslationY(((Float)ShuffleView.c(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yl(i) * f);
        i += 1;
      }
      ((View)ShuffleView.e(this.omN).get(ShuffleView.f(this.omN) - 1)).setTranslationX(((Float)ShuffleView.b(this.omN).get(ShuffleView.f(this.omN) - 1)).floatValue() * (1.0F - f) + (this.omN.yk(ShuffleView.f(this.omN) - 1) - ShuffleView.g(this.omN) * this.omP / 2.0F) * f);
      ((View)ShuffleView.e(this.omN).get(ShuffleView.f(this.omN) - 1)).setTranslationY(((Float)ShuffleView.c(this.omN).get(ShuffleView.f(this.omN) - 1)).floatValue() * (1.0F - f) + this.omN.yl(ShuffleView.f(this.omN) - 1) * f);
    }
    while (this.omQ > 0)
    {
      ShuffleView.h(this.omN).setTranslationX(((Float)ShuffleView.b(this.omN).get(ShuffleView.f(this.omN))).floatValue() * (1.0F - f) + (this.omN.yk(ShuffleView.f(this.omN)) + ShuffleView.g(this.omN) * this.omQ / 2.0F) * f);
      i = ShuffleView.f(this.omN) + 1;
      while (i < ShuffleView.d(this.omN))
      {
        ((View)ShuffleView.e(this.omN).get(i)).setTranslationX(((Float)ShuffleView.b(this.omN).get(i)).floatValue() * (1.0F - f) + (this.omN.yk(i) + (ShuffleView.d(this.omN) - i) * ShuffleView.g(this.omN)) * f);
        ((View)ShuffleView.e(this.omN).get(i)).setTranslationY(((Float)ShuffleView.c(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yl(i) * f);
        i += 1;
      }
      i = 0;
      while (i < ShuffleView.f(this.omN))
      {
        ((View)ShuffleView.e(this.omN).get(i)).setTranslationX(((Float)ShuffleView.b(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yk(i) * f);
        ((View)ShuffleView.e(this.omN).get(i)).setTranslationY(((Float)ShuffleView.c(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yl(i) * f);
        i += 1;
      }
    }
    i = ShuffleView.f(this.omN);
    while (i < ShuffleView.d(this.omN))
    {
      ((View)ShuffleView.e(this.omN).get(i)).setTranslationX(((Float)ShuffleView.b(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yk(i) * f);
      ((View)ShuffleView.e(this.omN).get(i)).setTranslationY(((Float)ShuffleView.c(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yl(i) * f);
      i += 1;
    }
    ShuffleView.h(this.omN).setTranslationY(((Float)ShuffleView.c(this.omN).get(ShuffleView.f(this.omN))).floatValue() * (1.0F - f) - ShuffleView.h(this.omN).getHeight() * f / 7.0F);
    AppMethodBeat.o(42234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.9
 * JD-Core Version:    0.7.0.1
 */