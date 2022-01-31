package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.address.d.b;

final class WalletSelectAddrUI$10
  implements DialogInterface.OnClickListener
{
  WalletSelectAddrUI$10(WalletSelectAddrUI paramWalletSelectAddrUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    WalletSelectAddrUI.a(this.fvI, WalletSelectAddrUI.f(this.fvI).id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.10
 * JD-Core Version:    0.7.0.1
 */