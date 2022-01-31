package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.n;
import com.tencent.mm.plugin.emojicapture.api.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class LuckyMoneyNewYearSendUI$9
  implements n.d
{
  LuckyMoneyNewYearSendUI$9(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(42817);
    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42817);
      return;
      LuckyMoneyNewYearSendUI.l(this.ovl);
      c.h(this.ovl, null, 3);
      LuckyMoneyNewYearSendUI.m(this.ovl);
      LuckyMoneyNewYearSendUI.a(this.ovl, new n());
      LuckyMoneyNewYearSendUI.c(this.ovl).cRI = 9L;
      LuckyMoneyNewYearSendUI.c(this.ovl).ake();
      AppMethodBeat.o(42817);
      return;
      LuckyMoneyNewYearSendUI.n(this.ovl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.9
 * JD-Core Version:    0.7.0.1
 */