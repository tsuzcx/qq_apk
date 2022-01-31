package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiNoWifiUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FreeWifiNoWifiUI$1(FreeWifiNoWifiUI paramFreeWifiNoWifiUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(21057);
    this.mOq.finish();
    AppMethodBeat.o(21057);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNoWifiUI.1
 * JD-Core Version:    0.7.0.1
 */