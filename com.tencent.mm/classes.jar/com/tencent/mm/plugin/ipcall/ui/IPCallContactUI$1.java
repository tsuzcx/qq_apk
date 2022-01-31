package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  IPCallContactUI$1(IPCallContactUI paramIPCallContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22071);
    this.nSm.finish();
    AppMethodBeat.o(22071);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.1
 * JD-Core Version:    0.7.0.1
 */