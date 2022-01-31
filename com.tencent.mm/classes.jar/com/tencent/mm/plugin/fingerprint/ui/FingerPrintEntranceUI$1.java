package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FingerPrintEntranceUI$1
  implements DialogInterface.OnClickListener
{
  FingerPrintEntranceUI$1(FingerPrintEntranceUI paramFingerPrintEntranceUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41655);
    ab.i("MicroMsg.FingerPrintEntranceUI", "user click the button to set system fingerprint");
    FingerPrintEntranceUI.a(this.mHa);
    this.mHa.finish();
    AppMethodBeat.o(41655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI.1
 * JD-Core Version:    0.7.0.1
 */