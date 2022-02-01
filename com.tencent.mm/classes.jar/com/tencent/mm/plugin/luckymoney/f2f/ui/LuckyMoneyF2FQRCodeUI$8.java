package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class LuckyMoneyF2FQRCodeUI$8
  implements n.c
{
  LuckyMoneyF2FQRCodeUI$8(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(65073);
    if (bs.isNullOrNil(LuckyMoneyF2FQRCodeUI.g(this.ukd)))
    {
      paraml.jw(1, 2131760859);
      AppMethodBeat.o(65073);
      return;
    }
    paraml.a(1, this.ukd.getString(2131760859), LuckyMoneyF2FQRCodeUI.g(this.ukd), 0);
    AppMethodBeat.o(65073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.8
 * JD-Core Version:    0.7.0.1
 */