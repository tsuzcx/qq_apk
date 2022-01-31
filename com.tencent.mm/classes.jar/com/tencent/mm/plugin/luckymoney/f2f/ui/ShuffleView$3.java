package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import java.util.List;

final class ShuffleView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$3(ShuffleView paramShuffleView, int paramInt) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = this.lPw;
    if (i < ShuffleView.d(this.lPv) - 1)
    {
      View localView = (View)ShuffleView.e(this.lPv).get(i);
      float f1;
      float f2;
      if (ShuffleView.l(this.lPv).lPz == 1)
      {
        f1 = ShuffleView.l(this.lPv).scaleX;
        f2 = i + 1;
        localView.setScaleX(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.lPv).scaleX + (1.0F - f1 * f2));
        if (ShuffleView.l(this.lPv).lPA == 2) {
          localView.setTranslationY(this.lPv.tj(i + 1) - ((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(this.lPv));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (ShuffleView.l(this.lPv).lPA == 1)
        {
          f1 = this.lPv.tj(i + 1);
          localView.setTranslationY(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(this.lPv) + f1);
          continue;
          if (ShuffleView.l(this.lPv).lPz == 2)
          {
            f1 = ShuffleView.l(this.lPv).scaleY;
            f2 = i + 1;
            localView.setScaleY(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.lPv).scaleY + (1.0F - f1 * f2));
            if (ShuffleView.l(this.lPv).lPA == 3)
            {
              f1 = this.lPv.ti(i + 1);
              localView.setTranslationX(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(this.lPv) + f1);
            }
            else if (ShuffleView.l(this.lPv).lPA == 4)
            {
              localView.setTranslationX(this.lPv.ti(i + 1) - ((Float)paramValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(this.lPv));
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.3
 * JD-Core Version:    0.7.0.1
 */