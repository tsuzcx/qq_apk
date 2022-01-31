package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ShuffleView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$3(ShuffleView paramShuffleView, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(42227);
    int i = this.omO;
    if (i < ShuffleView.d(this.omN) - 1)
    {
      View localView = (View)ShuffleView.e(this.omN).get(i);
      float f1;
      float f2;
      if (ShuffleView.l(this.omN).omR == 1)
      {
        f1 = ShuffleView.l(this.omN).scaleX;
        f2 = i + 1;
        localView.setScaleX(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.omN).scaleX + (1.0F - f1 * f2));
        if (ShuffleView.l(this.omN).omS == 2) {
          localView.setTranslationY(this.omN.yl(i + 1) - ((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(this.omN));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (ShuffleView.l(this.omN).omS == 1)
        {
          f1 = this.omN.yl(i + 1);
          localView.setTranslationY(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(this.omN) + f1);
          continue;
          if (ShuffleView.l(this.omN).omR == 2)
          {
            f1 = ShuffleView.l(this.omN).scaleY;
            f2 = i + 1;
            localView.setScaleY(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.omN).scaleY + (1.0F - f1 * f2));
            if (ShuffleView.l(this.omN).omS == 3)
            {
              f1 = this.omN.yk(i + 1);
              localView.setTranslationX(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(this.omN) + f1);
            }
            else if (ShuffleView.l(this.omN).omS == 4)
            {
              localView.setTranslationX(this.omN.yk(i + 1) - ((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(this.omN));
            }
          }
        }
      }
    }
    AppMethodBeat.o(42227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.3
 * JD-Core Version:    0.7.0.1
 */