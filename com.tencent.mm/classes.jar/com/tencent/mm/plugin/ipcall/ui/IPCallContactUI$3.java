package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallContactUI$3
  implements DialogInterface.OnClickListener
{
  IPCallContactUI$3(IPCallContactUI paramIPCallContactUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22073);
    paramDialogInterface.dismiss();
    this.nSm.finish();
    this.nSm.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(22073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.3
 * JD-Core Version:    0.7.0.1
 */