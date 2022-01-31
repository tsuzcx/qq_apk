package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class LuckyMoneyF2FQRCodeUI$9
  implements n.d
{
  LuckyMoneyF2FQRCodeUI$9(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(42183);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42183);
      return;
      if (LuckyMoneyF2FQRCodeUI.g(this.olY) > 0)
      {
        LuckyMoneyF2FQRCodeUI.h(this.olY);
        AppMethodBeat.o(42183);
        return;
      }
      h.bO(this.olY, this.olY.getString(2131301218));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.9
 * JD-Core Version:    0.7.0.1
 */