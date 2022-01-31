package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.plugin.emojicapture.api.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class LuckyMoneyDetailUI$13$2
  implements n.d
{
  LuckyMoneyDetailUI$13$2(LuckyMoneyDetailUI.13 param13) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(42661);
    ab.i("MicroMsg.LuckyMoneyDetailUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42661);
      return;
      c.h(this.otB.otz, null, 5);
      LuckyMoneyDetailUI.a(this.otB.otz, new aa());
      LuckyMoneyDetailUI.w(this.otB.otz).cRI = 4L;
      LuckyMoneyDetailUI.w(this.otB.otz).ake();
      LuckyMoneyDetailUI.D(this.otB.otz);
      AppMethodBeat.o(42661);
      return;
      LuckyMoneyDetailUI.C(this.otB.otz);
      AppMethodBeat.o(42661);
      return;
      LuckyMoneyDetailUI.a(this.otB.otz, null);
      LuckyMoneyDetailUI.a(this.otB.otz, new aa());
      LuckyMoneyDetailUI.w(this.otB.otz).cRI = 8L;
      LuckyMoneyDetailUI.w(this.otB.otz).ake();
      LuckyMoneyDetailUI.b(this.otB.otz, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.13.2
 * JD-Core Version:    0.7.0.1
 */