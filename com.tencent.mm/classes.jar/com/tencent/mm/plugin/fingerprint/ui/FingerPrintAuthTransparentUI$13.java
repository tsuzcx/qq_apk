package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FingerPrintAuthTransparentUI$13
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthTransparentUI$13(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(64494);
    FingerPrintAuthTransparentUI.a(this.rcY, this.rcx.isChecked());
    AppMethodBeat.o(64494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.13
 * JD-Core Version:    0.7.0.1
 */