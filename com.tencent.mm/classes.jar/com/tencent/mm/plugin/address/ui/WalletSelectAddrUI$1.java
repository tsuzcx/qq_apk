package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletSelectAddrUI$1
  implements DialogInterface.OnClickListener
{
  WalletSelectAddrUI$1(WalletSelectAddrUI paramWalletSelectAddrUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(16976);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(16976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.1
 * JD-Core Version:    0.7.0.1
 */