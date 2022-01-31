package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallCountryCodeSelectUI$4
  implements MenuItem.OnMenuItemClickListener
{
  IPCallCountryCodeSelectUI$4(IPCallCountryCodeSelectUI paramIPCallCountryCodeSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22115);
    this.nSK.hideVKB();
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("country_name", IPCallCountryCodeSelectUI.d(this.nSK));
    paramMenuItem.putExtra("couttry_code", IPCallCountryCodeSelectUI.e(this.nSK));
    this.nSK.setResult(100, paramMenuItem);
    this.nSK.finish();
    AppMethodBeat.o(22115);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.4
 * JD-Core Version:    0.7.0.1
 */