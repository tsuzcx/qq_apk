package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyMyRecordUI$1
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyMyRecordUI$1(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(42755);
    this.oua.finish();
    AppMethodBeat.o(42755);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.1
 * JD-Core Version:    0.7.0.1
 */