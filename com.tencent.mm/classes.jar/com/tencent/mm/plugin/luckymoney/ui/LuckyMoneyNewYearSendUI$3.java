package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyNewYearSendUI$3
  implements LuckyMoneyAutoScrollView.a
{
  LuckyMoneyNewYearSendUI$3(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void bga()
  {
    if (LuckyMoneyNewYearSendUI.s(this.lWH))
    {
      LuckyMoneyNewYearSendUI.t(this.lWH).setVisibility(4);
      o.a(this.lWH.mController.uMN, LuckyMoneyNewYearSendUI.t(this.lWH), LuckyMoneyNewYearSendUI.u(this.lWH));
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setAnimationListener(new LuckyMoneyNewYearSendUI.3.1(this));
      LuckyMoneyNewYearSendUI.t(this.lWH).startAnimation(localAlphaAnimation);
      LuckyMoneyNewYearSendUI.v(this.lWH);
      return;
    }
    o.a(this.lWH.mController.uMN, LuckyMoneyNewYearSendUI.t(this.lWH), LuckyMoneyNewYearSendUI.u(this.lWH));
    LuckyMoneyNewYearSendUI.t(this.lWH).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.3
 * JD-Core Version:    0.7.0.1
 */