package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletSelectAddrUI$2
  implements DialogInterface.OnClickListener
{
  WalletSelectAddrUI$2(WalletSelectAddrUI paramWalletSelectAddrUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(16977);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(16977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.2
 * JD-Core Version:    0.7.0.1
 */