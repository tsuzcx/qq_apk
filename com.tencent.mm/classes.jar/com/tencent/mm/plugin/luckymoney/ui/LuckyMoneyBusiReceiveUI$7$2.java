package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyBusiReceiveUI$7$2
  implements Animation.AnimationListener
{
  LuckyMoneyBusiReceiveUI$7$2(LuckyMoneyBusiReceiveUI.7 param7) {}
  
  public final void onAnimationEnd(Animation paramAnimation) {}
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(42623);
    LuckyMoneyBusiReceiveUI.k(this.osl.osi).setVisibility(0);
    AppMethodBeat.o(42623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.7.2
 * JD-Core Version:    0.7.0.1
 */