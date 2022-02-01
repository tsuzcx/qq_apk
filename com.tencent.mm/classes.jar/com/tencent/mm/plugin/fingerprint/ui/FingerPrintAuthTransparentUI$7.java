package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FingerPrintAuthTransparentUI$7
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthTransparentUI$7(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(64488);
    this.rcY.finish();
    AppMethodBeat.o(64488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.7
 * JD-Core Version:    0.7.0.1
 */