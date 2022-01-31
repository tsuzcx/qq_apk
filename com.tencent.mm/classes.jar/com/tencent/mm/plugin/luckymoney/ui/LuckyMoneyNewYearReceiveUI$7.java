package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyNewYearReceiveUI$7
  implements LuckyMoneyAutoScrollView.a
{
  LuckyMoneyNewYearReceiveUI$7(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI, ad paramad) {}
  
  public final void bga()
  {
    LuckyMoneyNewYearReceiveUI.j(this.lWq).setVisibility(4);
    o.a(this.lWq.mController.uMN, LuckyMoneyNewYearReceiveUI.j(this.lWq), this.lWv.lQZ.lLm);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(new LuckyMoneyNewYearReceiveUI.7.1(this));
    LuckyMoneyNewYearReceiveUI.j(this.lWq).startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.7
 * JD-Core Version:    0.7.0.1
 */