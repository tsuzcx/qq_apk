package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;

final class LuckyMoneyNewYearReceiveUI$7$1
  implements Animation.AnimationListener
{
  LuckyMoneyNewYearReceiveUI$7$1(LuckyMoneyNewYearReceiveUI.7 param7) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(42791);
    if (g.Nq().getInt("PlayCoinSound", 0) > 0) {
      k.a(this.ouH.ouD, k.a.oxx);
    }
    if (this.ouH.ouG.okp != null) {
      this.ouH.ouG.okp.b(this.ouH.ouD, null, null);
    }
    AppMethodBeat.o(42791);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(42790);
    LuckyMoneyNewYearReceiveUI.i(this.ouH.ouD).setVisibility(0);
    AppMethodBeat.o(42790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.7.1
 * JD-Core Version:    0.7.0.1
 */