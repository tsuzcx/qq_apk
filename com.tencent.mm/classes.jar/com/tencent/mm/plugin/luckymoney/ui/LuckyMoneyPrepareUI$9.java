package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;

final class LuckyMoneyPrepareUI$9
  implements n.d
{
  LuckyMoneyPrepareUI$9(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(65835);
    paraml.add(0, 0, 0, this.vAO.getString(2131760840));
    paraml.add(0, 1, 0, this.vAO.getString(2131765311));
    AppMethodBeat.o(65835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.9
 * JD-Core Version:    0.7.0.1
 */