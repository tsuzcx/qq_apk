package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallRechargeUI$5
  implements MenuItem.OnMenuItemClickListener
{
  IPCallRechargeUI$5(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(25875);
    this.DXz.finish();
    AppMethodBeat.o(25875);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.5
 * JD-Core Version:    0.7.0.1
 */