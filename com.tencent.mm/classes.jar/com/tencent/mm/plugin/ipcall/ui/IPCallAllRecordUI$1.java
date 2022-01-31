package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallAllRecordUI$1
  implements MenuItem.OnMenuItemClickListener
{
  IPCallAllRecordUI$1(IPCallAllRecordUI paramIPCallAllRecordUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22064);
    this.nRW.finish();
    AppMethodBeat.o(22064);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAllRecordUI.1
 * JD-Core Version:    0.7.0.1
 */