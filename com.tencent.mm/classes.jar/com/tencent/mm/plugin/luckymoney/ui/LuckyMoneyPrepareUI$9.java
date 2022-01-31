package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class LuckyMoneyPrepareUI$9
  implements n.c
{
  LuckyMoneyPrepareUI$9(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(142062);
    paraml.add(0, 0, 0, this.owL.getString(2131301206));
    paraml.add(0, 1, 0, this.owL.getString(2131305119));
    AppMethodBeat.o(142062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.9
 * JD-Core Version:    0.7.0.1
 */