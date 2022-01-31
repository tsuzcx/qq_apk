package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class LuckyMoneyNewYearSendUI$8
  implements n.c
{
  LuckyMoneyNewYearSendUI$8(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(42816);
    if (bo.hl(LuckyMoneyNewYearSendUI.k(this.ovl), 1)) {
      paraml.hx(1, 2131301266);
    }
    paraml.hx(2, 2131301307);
    AppMethodBeat.o(42816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.8
 * JD-Core Version:    0.7.0.1
 */