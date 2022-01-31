package com.tencent.mm.plugin.address.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.km;

final class WalletSelectAddrUI$9
  implements Runnable
{
  WalletSelectAddrUI$9(WalletSelectAddrUI paramWalletSelectAddrUI, km paramkm) {}
  
  public final void run()
  {
    AppMethodBeat.i(16987);
    WalletSelectAddrUI.k(this.gNo).post(new WalletSelectAddrUI.9.1(this));
    AppMethodBeat.o(16987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.9
 * JD-Core Version:    0.7.0.1
 */