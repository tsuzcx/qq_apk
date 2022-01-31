package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.util.DisplayMetrics;
import android.view.View;

final class LuckyMoneyF2FReceiveUI$2
  implements ValueAnimator.AnimatorUpdateListener
{
  LuckyMoneyF2FReceiveUI$2(LuckyMoneyF2FReceiveUI paramLuckyMoneyF2FReceiveUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    LuckyMoneyF2FReceiveUI.c(this.lOW).setTranslationY(-f * LuckyMoneyF2FReceiveUI.b(this.lOW).heightPixels);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.2
 * JD-Core Version:    0.7.0.1
 */