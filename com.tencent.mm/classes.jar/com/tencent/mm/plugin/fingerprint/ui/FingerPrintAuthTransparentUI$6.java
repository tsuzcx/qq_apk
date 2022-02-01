package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class FingerPrintAuthTransparentUI$6
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthTransparentUI$6(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(64487);
    ad.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
    FingerPrintAuthTransparentUI.f(this.rcY);
    FingerPrintAuthTransparentUI.g(this.rcY);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(64487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.6
 * JD-Core Version:    0.7.0.1
 */