package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.List;

final class LuckyAvatarParticleView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  LuckyAvatarParticleView$1(LuckyAvatarParticleView paramLuckyAvatarParticleView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (((Float)paramValueAnimator.getAnimatedValue()).floatValue() == 1.0F)
    {
      LuckyAvatarParticleView.a(this.lNL).clear();
      LuckyAvatarParticleView.b(this.lNL).clear();
      LuckyAvatarParticleView.c(this.lNL).clear();
    }
    for (;;)
    {
      this.lNL.invalidate();
      return;
      if (((Float)paramValueAnimator.getAnimatedValue()).floatValue() == 0.0F)
      {
        LuckyAvatarParticleView.d(this.lNL);
      }
      else
      {
        int i = 0;
        while (i < LuckyAvatarParticleView.a(this.lNL).size())
        {
          LuckyAvatarParticleView.a(this.lNL, i);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyAvatarParticleView.1
 * JD-Core Version:    0.7.0.1
 */