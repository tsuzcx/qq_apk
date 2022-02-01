package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;

final class FingerPrintAuthUI$8
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthUI$8(FingerPrintAuthUI paramFingerPrintAuthUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(275236);
    a.b(this.HgZ, new Bundle(), -1);
    AppMethodBeat.o(275236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.8
 * JD-Core Version:    0.7.0.1
 */