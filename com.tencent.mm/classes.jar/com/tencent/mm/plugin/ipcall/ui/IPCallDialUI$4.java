package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallDialUI$4
  implements DialogInterface.OnClickListener
{
  IPCallDialUI$4(IPCallDialUI paramIPCallDialUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(25745);
    paramDialogInterface.dismiss();
    this.sGR.finish();
    AppMethodBeat.o(25745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDialUI.4
 * JD-Core Version:    0.7.0.1
 */