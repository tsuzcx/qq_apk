package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallAddressUI$4
  implements DialogInterface.OnClickListener
{
  IPCallAddressUI$4(IPCallAddressUI paramIPCallAddressUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22053);
    paramDialogInterface.dismiss();
    this.nRT.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(22053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI.4
 * JD-Core Version:    0.7.0.1
 */