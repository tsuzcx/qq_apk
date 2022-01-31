package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.x;

final class LuckyMoneyNewYearReceiveUI$7
  implements LuckyMoneyAutoScrollView.a
{
  LuckyMoneyNewYearReceiveUI$7(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI, an paraman) {}
  
  public final void bNO()
  {
    AppMethodBeat.i(42792);
    LuckyMoneyNewYearReceiveUI.i(this.ouD).setVisibility(4);
    x.a(this.ouD.getContext(), LuckyMoneyNewYearReceiveUI.i(this.ouD), this.ouG.ooO.oiG);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(new LuckyMoneyNewYearReceiveUI.7.1(this));
    LuckyMoneyNewYearReceiveUI.i(this.ouD).startAnimation(localAlphaAnimation);
    AppMethodBeat.o(42792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.7
 * JD-Core Version:    0.7.0.1
 */