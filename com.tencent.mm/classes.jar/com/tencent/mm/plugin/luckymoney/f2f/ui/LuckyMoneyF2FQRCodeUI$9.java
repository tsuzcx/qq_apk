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
    AppMethodBeat.i(65074);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(65074);
      return;
      if (LuckyMoneyF2FQRCodeUI.h(this.ukd) > 0)
      {
        LuckyMoneyF2FQRCodeUI.i(this.ukd);
        AppMethodBeat.o(65074);
        return;
      }
      h.cg(this.ukd, this.ukd.getString(2131760860));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.9
 * JD-Core Version:    0.7.0.1
 */