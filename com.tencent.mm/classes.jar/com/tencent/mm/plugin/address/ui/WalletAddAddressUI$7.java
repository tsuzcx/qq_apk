package com.tencent.mm.plugin.address.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;

final class WalletAddAddressUI$7
  implements DialogInterface.OnClickListener
{
  WalletAddAddressUI$7(WalletAddAddressUI paramWalletAddAddressUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20980);
    paramDialogInterface.dismiss();
    b.lx(this.qks.getContext());
    AppMethodBeat.o(20980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI.7
 * JD-Core Version:    0.7.0.1
 */