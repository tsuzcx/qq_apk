package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class LuckyMoneyF2FQRCodeUI$8
  implements q.f
{
  LuckyMoneyF2FQRCodeUI$8(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(65073);
    if (Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.g(this.Exb)))
    {
      paramo.mn(1, a.i.lucky_money_f2f_clear);
      AppMethodBeat.o(65073);
      return;
    }
    paramo.a(1, this.Exb.getString(a.i.lucky_money_f2f_clear), LuckyMoneyF2FQRCodeUI.g(this.Exb), 0);
    AppMethodBeat.o(65073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.8
 * JD-Core Version:    0.7.0.1
 */