package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class ShuffleView$8
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$8(ShuffleView paramShuffleView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = 0;
    AppMethodBeat.i(42233);
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
      AppMethodBeat.o(42233);
      return;
    }
    i = 0;
    while (i < ShuffleView.d(this.omN))
    {
      ((View)ShuffleView.e(this.omN).get(i)).setTranslationX(((Float)ShuffleView.b(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yk(i) * f);
      ((View)ShuffleView.e(this.omN).get(i)).setTranslationY(((Float)ShuffleView.c(this.omN).get(i)).floatValue() * (1.0F - f) + this.omN.yl(i) * f);
      i += 1;
    }
    AppMethodBeat.o(42233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.8
 * JD-Core Version:    0.7.0.1
 */