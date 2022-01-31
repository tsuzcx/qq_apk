package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mm.ui.base.HorizontalListViewV2;

final class LuckyMoneyF2FQRCodeUI$6
  implements ValueAnimator.AnimatorUpdateListener
{
  LuckyMoneyF2FQRCodeUI$6(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    LuckyMoneyF2FQRCodeUI.E(this.lOE).setTranslationY(-0.5F * f * LuckyMoneyF2FQRCodeUI.K(this.lOE).heightPixels);
    LuckyMoneyF2FQRCodeUI.D(this.lOE).setAlpha(1.0F - f);
    if (f == 1.0F)
    {
      LuckyMoneyF2FQRCodeUI.E(this.lOE).setVisibility(8);
      LuckyMoneyF2FQRCodeUI.E(this.lOE).setTranslationY(0.0F);
      LuckyMoneyF2FQRCodeUI.L(this.lOE);
      LuckyMoneyF2FQRCodeUI.M(this.lOE).notifyDataSetChanged();
      LuckyMoneyF2FQRCodeUI.w(this.lOE).Gk(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.6
 * JD-Core Version:    0.7.0.1
 */