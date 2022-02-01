package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;

final class LuckyMoneyPrepareUI$10
  implements o.f
{
  LuckyMoneyPrepareUI$10(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(213480);
    paramm.add(0, 0, 0, this.ziq.getString(2131762597));
    paramm.add(0, 1, 0, this.ziq.getString(2131767754));
    AppMethodBeat.o(213480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.10
 * JD-Core Version:    0.7.0.1
 */