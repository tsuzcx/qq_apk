package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyNewYearSendUI$11$1
  implements Animation.AnimationListener
{
  LuckyMoneyNewYearSendUI$11$1(LuckyMoneyNewYearSendUI.11 param11) {}
  
  public final void onAnimationEnd(Animation paramAnimation) {}
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(42819);
    LuckyMoneyNewYearSendUI.s(this.ovm.ovl).setVisibility(0);
    AppMethodBeat.o(42819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.11.1
 * JD-Core Version:    0.7.0.1
 */