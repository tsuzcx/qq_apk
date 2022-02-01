package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FingerPrintAuthTransparentUI$3
  implements DialogInterface.OnCancelListener
{
  FingerPrintAuthTransparentUI$3(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(64484);
    paramDialogInterface.dismiss();
    FingerPrintAuthTransparentUI.cuG();
    this.rcY.finish();
    AppMethodBeat.o(64484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.3
 * JD-Core Version:    0.7.0.1
 */