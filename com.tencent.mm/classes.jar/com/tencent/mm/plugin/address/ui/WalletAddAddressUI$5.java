package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;

final class WalletAddAddressUI$5
  implements DialogInterface.OnClickListener
{
  WalletAddAddressUI$5(WalletAddAddressUI paramWalletAddAddressUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20978);
    paramDialogInterface.dismiss();
    b.lx(this.qks.getContext());
    AppMethodBeat.o(20978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI.5
 * JD-Core Version:    0.7.0.1
 */