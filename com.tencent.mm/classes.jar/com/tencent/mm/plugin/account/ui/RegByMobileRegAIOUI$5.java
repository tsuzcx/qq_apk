package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegByMobileRegAIOUI$5
  implements MenuItem.OnMenuItemClickListener
{
  RegByMobileRegAIOUI$5(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(128515);
    this.qfw.hideVKB();
    RegByMobileRegAIOUI.o(this.qfw);
    this.qfw.finish();
    AppMethodBeat.o(128515);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.5
 * JD-Core Version:    0.7.0.1
 */