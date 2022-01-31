package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyF2FReceiveUI$4
  implements Animator.AnimatorListener
{
  LuckyMoneyF2FReceiveUI$4(LuckyMoneyF2FReceiveUI paramLuckyMoneyF2FReceiveUI) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(42214);
    ab.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
    if (LuckyMoneyF2FReceiveUI.d(this.omq) != null) {
      LuckyMoneyF2FReceiveUI.a(this.omq, LuckyMoneyBeforeDetailUI.class, LuckyMoneyF2FReceiveUI.d(this.omq));
    }
    this.omq.setResult(-1, null);
    this.omq.finish();
    if (LuckyMoneyF2FReceiveUI.d(this.omq) != null) {
      this.omq.overridePendingTransition(2131034217, 2131034222);
    }
    AppMethodBeat.o(42214);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.4
 * JD-Core Version:    0.7.0.1
 */