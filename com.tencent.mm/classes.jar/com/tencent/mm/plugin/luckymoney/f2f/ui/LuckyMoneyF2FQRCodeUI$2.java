package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyF2FQRCodeUI$2
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyF2FQRCodeUI$2(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(65062);
    this.vmL.finish();
    AppMethodBeat.o(65062);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.2
 * JD-Core Version:    0.7.0.1
 */