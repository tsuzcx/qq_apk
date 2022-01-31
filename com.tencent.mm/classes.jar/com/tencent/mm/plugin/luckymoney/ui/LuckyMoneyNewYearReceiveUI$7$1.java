package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.i;

final class LuckyMoneyNewYearReceiveUI$7$1
  implements Animation.AnimationListener
{
  LuckyMoneyNewYearReceiveUI$7$1(LuckyMoneyNewYearReceiveUI.7 param7) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (g.AA().getInt("PlayCoinSound", 0) > 0) {
      k.G(this.lWw.lWq, a.i.lucky_cashrecivedrevised);
    }
    if (this.lWw.lWv.lMW != null) {
      this.lWw.lWv.lMW.b(this.lWw.lWq, null, null);
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    LuckyMoneyNewYearReceiveUI.j(this.lWw.lWq).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.7.1
 * JD-Core Version:    0.7.0.1
 */