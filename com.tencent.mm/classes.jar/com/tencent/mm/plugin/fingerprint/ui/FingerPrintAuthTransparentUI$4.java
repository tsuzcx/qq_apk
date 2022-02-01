package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class FingerPrintAuthTransparentUI$4
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthTransparentUI$4(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(64485);
    paramDialogInterface.dismiss();
    ad.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
    this.rcY.finish();
    AppMethodBeat.o(64485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.4
 * JD-Core Version:    0.7.0.1
 */