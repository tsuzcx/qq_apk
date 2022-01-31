package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FingerPrintAuthTransparentUI$9
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthTransparentUI$9(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41604);
    FingerPrintAuthTransparentUI.b(this.mGQ, false);
    AppMethodBeat.o(41604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.9
 * JD-Core Version:    0.7.0.1
 */