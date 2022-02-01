package com.tencent.mm.plugin.address.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletAddAddressUI$8
  implements AddrEditView.a
{
  WalletAddAddressUI$8(WalletAddAddressUI paramWalletAddAddressUI) {}
  
  public final void onClick()
  {
    AppMethodBeat.i(20981);
    boolean bool = b.a(this.kva, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64, null, null);
    Log.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(20981);
      return;
    }
    WalletAddAddressUI.b(this.kva);
    AppMethodBeat.o(20981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI.8
 * JD-Core Version:    0.7.0.1
 */