package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyBusiReceiveUI$6
  implements Animation.AnimationListener
{
  LuckyMoneyBusiReceiveUI$6(LuckyMoneyBusiReceiveUI paramLuckyMoneyBusiReceiveUI, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(42621);
    this.osj.setVisibility(8);
    AppMethodBeat.o(42621);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.6
 * JD-Core Version:    0.7.0.1
 */