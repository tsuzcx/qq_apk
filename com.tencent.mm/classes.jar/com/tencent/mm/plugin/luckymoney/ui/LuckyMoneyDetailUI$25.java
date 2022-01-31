package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyDetailUI$25
  implements Runnable
{
  LuckyMoneyDetailUI$25(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(42675);
    LuckyMoneyDetailUI.c(this.otz, LuckyMoneyDetailUI.Q(this.otz).getHeight());
    ab.d("MicroMsg.LuckyMoneyDetailUI", "get footer height: %s", new Object[] { Integer.valueOf(LuckyMoneyDetailUI.R(this.otz)) });
    AppMethodBeat.o(42675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.25
 * JD-Core Version:    0.7.0.1
 */