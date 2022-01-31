package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallAddressUI$5
  implements DialogInterface.OnClickListener
{
  IPCallAddressUI$5(IPCallAddressUI paramIPCallAddressUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22054);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(22054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI.5
 * JD-Core Version:    0.7.0.1
 */