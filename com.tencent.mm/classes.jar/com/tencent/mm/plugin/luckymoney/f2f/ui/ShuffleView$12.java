package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class ShuffleView$12
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$12(ShuffleView paramShuffleView, int paramInt1, int paramInt2) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = 0;
    AppMethodBeat.i(42237);
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
      AppMethodBeat.o(42237);
      return;
    }
    if (this.omP > 0)
    {
      i = 0;
      while (i < ShuffleView.i(this.omN) - 1)
      {
        ((View)ShuffleView.e(this.omN).get(i)).setTranslationX(((Float)ShuffleView.b(this.omN).get(i)).floatValue() * (1.0F - f) + (this.omN.yk(i) - (i + 1) * ShuffleView.j(this.omN)) * f);
        ((View)ShuffleView.e(this.omN).get(i)).setTranslationY(((Float)ShuffleView.c(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yl(i) * f);
        i += 1;
      }
      ((View)ShuffleView.e(this.omN).get(ShuffleView.i(this.omN) - 1)).setTranslationX(((Float)ShuffleView.b(this.omN).get(ShuffleView.i(this.omN) - 1)).floatValue() * (1.0F - f) + (this.omN.yk(ShuffleView.i(this.omN) - 1) - ShuffleView.j(this.omN) * this.omP / 2.0F) * f);
    }
    while (this.omQ > 0)
    {
      ShuffleView.k(this.omN).setTranslationX(((Float)ShuffleView.b(this.omN).get(ShuffleView.i(this.omN))).floatValue() * (1.0F - f) + (this.omN.yk(ShuffleView.i(this.omN)) + ShuffleView.j(this.omN) * this.omQ / 2.0F) * f);
      ShuffleView.k(this.omN).setTranslationY(((Float)ShuffleView.c(this.omN).get(ShuffleView.i(this.omN))).floatValue() * (1.0F - f) + this.omN.yl(ShuffleView.i(this.omN)) * f);
      i = ShuffleView.i(this.omN) + 1;
      for (;;)
      {
        if (i < ShuffleView.d(this.omN))
        {
          ((View)ShuffleView.e(this.omN).get(i)).setTranslationX(((Float)ShuffleView.b(this.omN).get(i)).floatValue() * (1.0F - f) + (this.omN.yk(i) + (ShuffleView.d(this.omN) - i) * ShuffleView.j(this.omN)) * f);
          ((View)ShuffleView.e(this.omN).get(i)).setTranslationY(((Float)ShuffleView.c(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yl(i) * f);
          i += 1;
          continue;
          i = 0;
          while (i < ShuffleView.i(this.omN))
          {
            ((View)ShuffleView.e(this.omN).get(i)).setTranslationX(((Float)ShuffleView.b(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yk(i) * f);
            ((View)ShuffleView.e(this.omN).get(i)).setTranslationY(((Float)ShuffleView.c(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yl(i) * f);
            i += 1;
          }
          break;
        }
      }
      AppMethodBeat.o(42237);
      return;
    }
    i = ShuffleView.i(this.omN);
    while (i < ShuffleView.d(this.omN))
    {
      ((View)ShuffleView.e(this.omN).get(i)).setTranslationX(((Float)ShuffleView.b(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yk(i) * f);
      ((View)ShuffleView.e(this.omN).get(i)).setTranslationY(((Float)ShuffleView.c(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yl(i) * f);
      i += 1;
    }
    AppMethodBeat.o(42237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.12
 * JD-Core Version:    0.7.0.1
 */