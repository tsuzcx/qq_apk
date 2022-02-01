package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class FingerPrintAuthTransparentUI$5
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthTransparentUI$5(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(64486);
    ad.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
    paramDialogInterface.dismiss();
    this.rcY.finish();
    AppMethodBeat.o(64486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.5
 * JD-Core Version:    0.7.0.1
 */