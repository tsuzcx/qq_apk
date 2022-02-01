package com.tencent.mm.plugin.address.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class WalletAddAddressUI$1
  implements AddrEditView.a
{
  WalletAddAddressUI$1(WalletAddAddressUI paramWalletAddAddressUI) {}
  
  public final void onClick()
  {
    AppMethodBeat.i(20976);
    boolean bool = b.a(this.qks, "android.permission.READ_CONTACTS", 48, null);
    Log.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(20976);
      return;
    }
    WalletAddAddressUI.a(this.qks);
    AppMethodBeat.o(20976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI.1
 * JD-Core Version:    0.7.0.1
 */