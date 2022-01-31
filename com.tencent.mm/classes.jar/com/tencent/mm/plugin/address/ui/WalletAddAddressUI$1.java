package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WalletAddAddressUI$1
  implements AddrEditView.a
{
  WalletAddAddressUI$1(WalletAddAddressUI paramWalletAddAddressUI) {}
  
  public final void onClick()
  {
    boolean bool = a.a(this.fvu, "android.permission.READ_CONTACTS", 48, null, null);
    y.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
    if (!bool) {
      return;
    }
    WalletAddAddressUI.a(this.fvu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI.1
 * JD-Core Version:    0.7.0.1
 */