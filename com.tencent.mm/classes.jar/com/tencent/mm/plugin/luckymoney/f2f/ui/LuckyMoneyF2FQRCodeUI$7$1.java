package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyF2FQRCodeUI$7$1
  implements ValueAnimator.AnimatorUpdateListener
{
  LuckyMoneyF2FQRCodeUI$7$1(LuckyMoneyF2FQRCodeUI.7 param7) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(42178);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    LuckyMoneyF2FQRCodeUI.N(this.omg.olY).setPadding(LuckyMoneyF2FQRCodeUI.N(this.omg.olY).getPaddingLeft(), (int)f, LuckyMoneyF2FQRCodeUI.N(this.omg.olY).getPaddingRight(), LuckyMoneyF2FQRCodeUI.N(this.omg.olY).getPaddingBottom());
    f /= this.omg.ome;
    if (f <= 1.0F)
    {
      LuckyMoneyF2FQRCodeUI.P(this.omg.olY).setAlpha(1.0F - f + LuckyMoneyF2FQRCodeUI.O(this.omg.olY));
      LuckyMoneyF2FQRCodeUI.Q(this.omg.olY).setAlpha(f * LuckyMoneyF2FQRCodeUI.O(this.omg.olY));
      AppMethodBeat.o(42178);
      return;
    }
    LuckyMoneyF2FQRCodeUI.P(this.omg.olY).setAlpha(LuckyMoneyF2FQRCodeUI.O(this.omg.olY));
    LuckyMoneyF2FQRCodeUI.Q(this.omg.olY).setAlpha(LuckyMoneyF2FQRCodeUI.O(this.omg.olY));
    AppMethodBeat.o(42178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.7.1
 * JD-Core Version:    0.7.0.1
 */