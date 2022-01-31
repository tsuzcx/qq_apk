package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiNetCheckUI$2
  implements MenuItem.OnMenuItemClickListener
{
  FreeWifiNetCheckUI$2(FreeWifiNetCheckUI paramFreeWifiNetCheckUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(21035);
    this.mOl.finish();
    AppMethodBeat.o(21035);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.2
 * JD-Core Version:    0.7.0.1
 */