package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletAddAddressUI$13
  implements DialogInterface.OnClickListener
{
  WalletAddAddressUI$13(WalletAddAddressUI paramWalletAddAddressUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20985);
    this.qks.finish();
    AppMethodBeat.o(20985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI.13
 * JD-Core Version:    0.7.0.1
 */