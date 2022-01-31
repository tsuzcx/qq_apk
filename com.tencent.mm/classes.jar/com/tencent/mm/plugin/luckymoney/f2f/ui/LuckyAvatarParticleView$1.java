package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class LuckyAvatarParticleView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  LuckyAvatarParticleView$1(LuckyAvatarParticleView paramLuckyAvatarParticleView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(42160);
    if (((Float)paramValueAnimator.getAnimatedValue()).floatValue() == 1.0F)
    {
      LuckyAvatarParticleView.a(this.olf).clear();
      LuckyAvatarParticleView.b(this.olf).clear();
      LuckyAvatarParticleView.c(this.olf).clear();
    }
    for (;;)
    {
      this.olf.invalidate();
      AppMethodBeat.o(42160);
      return;
      if (((Float)paramValueAnimator.getAnimatedValue()).floatValue() == 0.0F)
      {
        LuckyAvatarParticleView.d(this.olf);
      }
      else
      {
        int i = 0;
        while (i < LuckyAvatarParticleView.a(this.olf).size())
        {
          LuckyAvatarParticleView.a(this.olf, i);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyAvatarParticleView.1
 * JD-Core Version:    0.7.0.1
 */