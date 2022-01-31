package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegByMobileSetNickUI$2
  implements MenuItem.OnMenuItemClickListener
{
  RegByMobileSetNickUI$2(RegByMobileSetNickUI paramRegByMobileSetNickUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(125430);
    this.gIB.hideVKB();
    this.gIB.finish();
    AppMethodBeat.o(125430);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI.2
 * JD-Core Version:    0.7.0.1
 */