package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallCountryCodeSelectUI$1
  implements MenuItem.OnMenuItemClickListener
{
  IPCallCountryCodeSelectUI$1(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22111);
    this.nSK.finish();
    AppMethodBeat.o(22111);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.1
 * JD-Core Version:    0.7.0.1
 */