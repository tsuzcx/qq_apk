package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyDetailUI$19
  implements Runnable
{
  LuckyMoneyDetailUI$19(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(42668);
    int i = BackwardSupportUtil.b.b(this.otz.getContext(), 526.0F) + LuckyMoneyDetailUI.L(this.otz);
    ab.d("MicroMsg.LuckyMoneyDetailUI", "header height: %s", new Object[] { Integer.valueOf(i) });
    ViewGroup.LayoutParams localLayoutParams = LuckyMoneyDetailUI.M(this.otz).getLayoutParams();
    localLayoutParams.height = i;
    LuckyMoneyDetailUI.M(this.otz).setLayoutParams(localLayoutParams);
    AppMethodBeat.o(42668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.19
 * JD-Core Version:    0.7.0.1
 */