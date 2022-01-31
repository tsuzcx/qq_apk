package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FingerPrintAuthTransparentUI$3
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthTransparentUI$3(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41599);
    paramDialogInterface.dismiss();
    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
    this.mGQ.finish();
    AppMethodBeat.o(41599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.3
 * JD-Core Version:    0.7.0.1
 */