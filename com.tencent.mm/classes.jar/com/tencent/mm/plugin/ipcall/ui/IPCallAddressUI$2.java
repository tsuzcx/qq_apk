package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b;
import com.tencent.mm.pluginsdk.n;

final class IPCallAddressUI$2
  implements MenuItem.OnMenuItemClickListener
{
  IPCallAddressUI$2(IPCallAddressUI paramIPCallAddressUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22051);
    if (IPCallAddressUI.b(this.nRT) == 1) {
      b.gmO.p(new Intent(), this.nRT);
    }
    for (;;)
    {
      AppMethodBeat.o(22051);
      return true;
      this.nRT.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI.2
 * JD-Core Version:    0.7.0.1
 */