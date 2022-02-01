package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletSelectAddrUI$7
  implements MenuItem.OnMenuItemClickListener
{
  WalletSelectAddrUI$7(WalletSelectAddrUI paramWalletSelectAddrUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(21027);
    this.kvq.setResult(0);
    this.kvq.finish();
    AppMethodBeat.o(21027);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.7
 * JD-Core Version:    0.7.0.1
 */