package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallContactUI$9
  implements DialogInterface.OnCancelListener
{
  IPCallContactUI$9(IPCallContactUI paramIPCallContactUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(22083);
    this.nSm.finish();
    AppMethodBeat.o(22083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.9
 * JD-Core Version:    0.7.0.1
 */