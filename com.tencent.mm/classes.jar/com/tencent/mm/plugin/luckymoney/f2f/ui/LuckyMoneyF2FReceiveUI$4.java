package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class LuckyMoneyF2FReceiveUI$4
  implements Animator.AnimatorListener
{
  LuckyMoneyF2FReceiveUI$4(LuckyMoneyF2FReceiveUI paramLuckyMoneyF2FReceiveUI) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
    if (LuckyMoneyF2FReceiveUI.d(this.lOW) != null) {
      LuckyMoneyF2FReceiveUI.a(this.lOW, LuckyMoneyDetailUI.class, LuckyMoneyF2FReceiveUI.d(this.lOW));
    }
    this.lOW.setResult(-1, null);
    this.lOW.finish();
    if (LuckyMoneyF2FReceiveUI.d(this.lOW) != null) {
      this.lOW.overridePendingTransition(a.a.pop_in, a.a.pop_out);
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.4
 * JD-Core Version:    0.7.0.1
 */