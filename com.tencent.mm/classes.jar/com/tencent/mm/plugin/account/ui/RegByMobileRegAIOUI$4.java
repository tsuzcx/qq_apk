package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegByMobileRegAIOUI$4
  implements MenuItem.OnMenuItemClickListener
{
  RegByMobileRegAIOUI$4(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(169147);
    this.nic.hideVKB();
    RegByMobileRegAIOUI.p(this.nic);
    this.nic.finish();
    AppMethodBeat.o(169147);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.4
 * JD-Core Version:    0.7.0.1
 */