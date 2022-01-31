package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class ShuffleView$15
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$15(ShuffleView paramShuffleView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = 0;
    AppMethodBeat.i(42243);
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f1 == 0.0F)
    {
      ShuffleView.b(this.omN).clear();
      ShuffleView.c(this.omN).clear();
      while (i < ShuffleView.d(this.omN))
      {
        ShuffleView.b(this.omN).add(Float.valueOf(((View)ShuffleView.e(this.omN).get(i)).getTranslationX()));
        ShuffleView.c(this.omN).add(Float.valueOf(((View)ShuffleView.e(this.omN).get(i)).getTranslationY()));
        i += 1;
      }
      AppMethodBeat.o(42243);
      return;
    }
    i = 0;
    if (i < ShuffleView.d(this.omN))
    {
      View localView = (View)ShuffleView.e(this.omN).get(i);
      float f2;
      float f3;
      if (ShuffleView.l(this.omN).omR == 1)
      {
        f2 = ShuffleView.l(this.omN).scaleX;
        f3 = i + 1;
        localView.setScaleX(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.omN).scaleX + (1.0F - f2 * f3));
        f2 = this.omN.yl(i);
        localView.setTranslationY(((Float)ShuffleView.c(this.omN).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
      }
      for (;;)
      {
        i += 1;
        break;
        if (ShuffleView.l(this.omN).omR == 2)
        {
          f2 = ShuffleView.l(this.omN).scaleY;
          f3 = i + 1;
          localView.setScaleY(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.omN).scaleY + (1.0F - f2 * f3));
          f2 = this.omN.yk(i);
          localView.setTranslationX(((Float)ShuffleView.b(this.omN).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
        }
      }
    }
    AppMethodBeat.o(42243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.15
 * JD-Core Version:    0.7.0.1
 */