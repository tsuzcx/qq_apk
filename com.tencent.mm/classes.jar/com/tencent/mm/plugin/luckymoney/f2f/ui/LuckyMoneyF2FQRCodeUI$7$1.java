package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;

final class LuckyMoneyF2FQRCodeUI$7$1
  implements ValueAnimator.AnimatorUpdateListener
{
  LuckyMoneyF2FQRCodeUI$7$1(LuckyMoneyF2FQRCodeUI.7 param7) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    LuckyMoneyF2FQRCodeUI.N(this.lOM.lOE).setPadding(LuckyMoneyF2FQRCodeUI.N(this.lOM.lOE).getPaddingLeft(), (int)f, LuckyMoneyF2FQRCodeUI.N(this.lOM.lOE).getPaddingRight(), LuckyMoneyF2FQRCodeUI.N(this.lOM.lOE).getPaddingBottom());
    f /= this.lOM.lOK;
    if (f <= 1.0F)
    {
      LuckyMoneyF2FQRCodeUI.P(this.lOM.lOE).setAlpha(1.0F - f + LuckyMoneyF2FQRCodeUI.O(this.lOM.lOE));
      LuckyMoneyF2FQRCodeUI.Q(this.lOM.lOE).setAlpha(f * LuckyMoneyF2FQRCodeUI.O(this.lOM.lOE));
      return;
    }
    LuckyMoneyF2FQRCodeUI.P(this.lOM.lOE).setAlpha(LuckyMoneyF2FQRCodeUI.O(this.lOM.lOE));
    LuckyMoneyF2FQRCodeUI.Q(this.lOM.lOE).setAlpha(LuckyMoneyF2FQRCodeUI.O(this.lOM.lOE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.7.1
 * JD-Core Version:    0.7.0.1
 */