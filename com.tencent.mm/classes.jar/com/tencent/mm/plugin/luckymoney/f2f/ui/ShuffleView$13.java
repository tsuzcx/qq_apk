package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class ShuffleView$13
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$13(ShuffleView paramShuffleView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(42238);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f == 0.0F)
    {
      ShuffleView.b(this.omN).clear();
      ShuffleView.c(this.omN).clear();
      i = 0;
      while (i < ShuffleView.d(this.omN))
      {
        ShuffleView.b(this.omN).add(Float.valueOf(((View)ShuffleView.e(this.omN).get(i)).getTranslationX()));
        ShuffleView.c(this.omN).add(Float.valueOf(((View)ShuffleView.e(this.omN).get(i)).getTranslationY()));
        i += 1;
      }
      AppMethodBeat.o(42238);
      return;
    }
    ((View)ShuffleView.e(this.omN).get(0)).setTranslationX(((Float)ShuffleView.b(this.omN).get(0)).floatValue() * (1.0F - f) + this.omN.yk(0) * f);
    ((View)ShuffleView.e(this.omN).get(0)).setTranslationY(((Float)ShuffleView.c(this.omN).get(0)).floatValue() * (1.0F - f) + this.omN.yl(0) * f);
    int i = 1;
    while (i < ShuffleView.d(this.omN))
    {
      ((View)ShuffleView.e(this.omN).get(i)).setTranslationX(((Float)ShuffleView.b(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yk(i) * f);
      ((View)ShuffleView.e(this.omN).get(i)).setTranslationY(((Float)ShuffleView.c(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yl(i) * f);
      i += 1;
    }
    AppMethodBeat.o(42238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.13
 * JD-Core Version:    0.7.0.1
 */