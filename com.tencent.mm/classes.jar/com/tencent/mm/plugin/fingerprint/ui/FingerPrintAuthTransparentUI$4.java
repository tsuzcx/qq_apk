package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FingerPrintAuthTransparentUI$4
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthTransparentUI$4(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41600);
    ab.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
    paramDialogInterface.dismiss();
    this.mGQ.finish();
    AppMethodBeat.o(41600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.4
 * JD-Core Version:    0.7.0.1
 */