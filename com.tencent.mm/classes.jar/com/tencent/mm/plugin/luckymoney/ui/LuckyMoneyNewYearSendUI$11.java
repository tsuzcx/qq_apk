package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.x;

final class LuckyMoneyNewYearSendUI$11
  implements LuckyMoneyAutoScrollView.a
{
  LuckyMoneyNewYearSendUI$11(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void bNO()
  {
    AppMethodBeat.i(42820);
    if (LuckyMoneyNewYearSendUI.r(this.ovl))
    {
      LuckyMoneyNewYearSendUI.s(this.ovl).setVisibility(4);
      x.a(this.ovl.getContext(), LuckyMoneyNewYearSendUI.s(this.ovl), LuckyMoneyNewYearSendUI.t(this.ovl));
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setAnimationListener(new LuckyMoneyNewYearSendUI.11.1(this));
      LuckyMoneyNewYearSendUI.s(this.ovl).startAnimation(localAlphaAnimation);
      LuckyMoneyNewYearSendUI.u(this.ovl);
    }
    for (;;)
    {
      LuckyMoneyNewYearSendUI.a(this.ovl, true);
      LuckyMoneyNewYearSendUI.h(this.ovl).setFocusable(true);
      LuckyMoneyNewYearSendUI.h(this.ovl).setContentDescription(LuckyMoneyNewYearSendUI.v(this.ovl) / 100.0D);
      AppMethodBeat.o(42820);
      return;
      x.a(this.ovl.getContext(), LuckyMoneyNewYearSendUI.s(this.ovl), LuckyMoneyNewYearSendUI.t(this.ovl));
      LuckyMoneyNewYearSendUI.s(this.ovl).invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.11
 * JD-Core Version:    0.7.0.1
 */