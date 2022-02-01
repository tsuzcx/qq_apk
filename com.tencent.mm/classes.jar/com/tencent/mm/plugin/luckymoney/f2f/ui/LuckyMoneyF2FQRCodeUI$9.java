package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q.g;

final class LuckyMoneyF2FQRCodeUI$9
  implements q.g
{
  LuckyMoneyF2FQRCodeUI$9(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(65074);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(65074);
      return;
      if (LuckyMoneyF2FQRCodeUI.h(this.Exb) > 0)
      {
        LuckyMoneyF2FQRCodeUI.i(this.Exb);
        AppMethodBeat.o(65074);
        return;
      }
      h.cO(this.Exb, this.Exb.getString(a.i.lucky_money_f2f_clear_zero_packet_tips));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.9
 * JD-Core Version:    0.7.0.1
 */