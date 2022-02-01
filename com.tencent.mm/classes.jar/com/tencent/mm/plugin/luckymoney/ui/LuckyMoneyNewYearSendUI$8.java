package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class LuckyMoneyNewYearSendUI$8
  implements n.c
{
  LuckyMoneyNewYearSendUI$8(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(65696);
    if (bt.iY(LuckyMoneyNewYearSendUI.k(this.tnV), 1)) {
      paraml.jj(1, 2131760908);
    }
    paraml.jj(2, 2131760952);
    AppMethodBeat.o(65696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.8
 * JD-Core Version:    0.7.0.1
 */