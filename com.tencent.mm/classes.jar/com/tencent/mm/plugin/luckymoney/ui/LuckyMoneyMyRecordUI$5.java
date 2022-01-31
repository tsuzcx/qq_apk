package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;

final class LuckyMoneyMyRecordUI$5
  implements MMLoadMoreListView.a
{
  LuckyMoneyMyRecordUI$5(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final void Kt()
  {
    AppMethodBeat.i(42762);
    if (!this.oua.orz.isProcessing()) {
      LuckyMoneyMyRecordUI.g(this.oua);
    }
    if ((LuckyMoneyMyRecordUI.h(this.oua)) && (!LuckyMoneyMyRecordUI.i(this.oua))) {
      LuckyMoneyMyRecordUI.d(this.oua);
    }
    AppMethodBeat.o(42762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.5
 * JD-Core Version:    0.7.0.1
 */