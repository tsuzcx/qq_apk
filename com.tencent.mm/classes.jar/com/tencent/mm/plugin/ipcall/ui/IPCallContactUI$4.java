package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallContactUI$4
  implements DialogInterface.OnClickListener
{
  IPCallContactUI$4(IPCallContactUI paramIPCallContactUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22074);
    paramDialogInterface.dismiss();
    this.nSm.finish();
    AppMethodBeat.o(22074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.4
 * JD-Core Version:    0.7.0.1
 */