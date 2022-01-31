package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FingerPrintAuthTransparentUI$2
  implements DialogInterface.OnCancelListener
{
  FingerPrintAuthTransparentUI$2(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(142015);
    paramDialogInterface.dismiss();
    FingerPrintAuthTransparentUI.bzF();
    this.mGQ.finish();
    AppMethodBeat.o(142015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.2
 * JD-Core Version:    0.7.0.1
 */