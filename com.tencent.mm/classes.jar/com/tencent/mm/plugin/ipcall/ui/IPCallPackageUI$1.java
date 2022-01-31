package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallPackageUI$1
  implements MenuItem.OnMenuItemClickListener
{
  IPCallPackageUI$1(IPCallPackageUI paramIPCallPackageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22220);
    this.nUs.finish();
    AppMethodBeat.o(22220);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.1
 * JD-Core Version:    0.7.0.1
 */