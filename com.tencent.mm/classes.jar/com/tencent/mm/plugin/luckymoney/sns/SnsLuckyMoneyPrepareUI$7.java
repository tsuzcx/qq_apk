package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsLuckyMoneyPrepareUI$7
  implements Runnable
{
  SnsLuckyMoneyPrepareUI$7(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(42513);
    SnsLuckyMoneyPrepareUI.l(this.oqN).setVisibility(0);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(800L);
    localScaleAnimation.setStartOffset(200L);
    localScaleAnimation.setInterpolator(new BounceInterpolator());
    this.oqN.findViewById(2131825802).startAnimation(localScaleAnimation);
    AppMethodBeat.o(42513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.7
 * JD-Core Version:    0.7.0.1
 */