package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallDialUI$1
  implements MenuItem.OnMenuItemClickListener
{
  IPCallDialUI$1(IPCallDialUI paramIPCallDialUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22124);
    this.nSW.finish();
    AppMethodBeat.o(22124);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDialUI.1
 * JD-Core Version:    0.7.0.1
 */