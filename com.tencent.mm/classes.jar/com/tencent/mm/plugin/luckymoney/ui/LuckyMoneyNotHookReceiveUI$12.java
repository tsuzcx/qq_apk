package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyNotHookReceiveUI$12
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyNotHookReceiveUI$12(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(252905);
    LuckyMoneyNotHookReceiveUI.e(this.ELl);
    this.ELl.finish();
    AppMethodBeat.o(252905);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.12
 * JD-Core Version:    0.7.0.1
 */