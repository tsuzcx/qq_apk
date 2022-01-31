package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallFeedbackDialogUI$1
  implements DialogInterface.OnDismissListener
{
  IPCallFeedbackDialogUI$1(IPCallFeedbackDialogUI paramIPCallFeedbackDialogUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(22173);
    this.nTI.finish();
    AppMethodBeat.o(22173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallFeedbackDialogUI.1
 * JD-Core Version:    0.7.0.1
 */