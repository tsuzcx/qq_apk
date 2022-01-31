package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class WalletAddAddressUI$6
  implements DialogInterface.OnClickListener
{
  WalletAddAddressUI$6(WalletAddAddressUI paramWalletAddAddressUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.fvu.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI.6
 * JD-Core Version:    0.7.0.1
 */