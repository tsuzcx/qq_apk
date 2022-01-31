package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FingerPrintAuthTransparentUI$11
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthTransparentUI$11(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41606);
    FingerPrintAuthTransparentUI.b(this.mGQ, this.mGz.isChecked());
    AppMethodBeat.o(41606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.11
 * JD-Core Version:    0.7.0.1
 */