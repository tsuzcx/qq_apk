package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FingerPrintEntranceUI$2
  implements DialogInterface.OnClickListener
{
  FingerPrintEntranceUI$2(FingerPrintEntranceUI paramFingerPrintEntranceUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41656);
    this.mHa.finish();
    AppMethodBeat.o(41656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI.2
 * JD-Core Version:    0.7.0.1
 */