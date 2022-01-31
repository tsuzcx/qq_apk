package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class LuckyMoneyMyRecordUI$2
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyMyRecordUI$2(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(42758);
    paramMenuItem = new d(this.oua.getContext(), 1, false);
    paramMenuItem.sao = new LuckyMoneyMyRecordUI.2.1(this);
    paramMenuItem.sap = new LuckyMoneyMyRecordUI.2.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(42758);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.2
 * JD-Core Version:    0.7.0.1
 */