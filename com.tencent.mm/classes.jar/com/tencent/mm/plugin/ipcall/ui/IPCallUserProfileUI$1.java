package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallUserProfileUI$1
  implements MenuItem.OnMenuItemClickListener
{
  IPCallUserProfileUI$1(IPCallUserProfileUI paramIPCallUserProfileUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22371);
    this.nWR.finish();
    AppMethodBeat.o(22371);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.1
 * JD-Core Version:    0.7.0.1
 */