package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.g;

final class FingerPrintAuthUI$2
  implements Runnable
{
  FingerPrintAuthUI$2(FingerPrintAuthUI paramFingerPrintAuthUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(41633);
    if (this.mGX)
    {
      FingerPrintAuthUI.a(this.mGW, g.c(this.mGW, false, null));
      AppMethodBeat.o(41633);
      return;
    }
    if ((FingerPrintAuthUI.d(this.mGW) != null) && (FingerPrintAuthUI.d(this.mGW).isShowing()))
    {
      FingerPrintAuthUI.d(this.mGW).dismiss();
      FingerPrintAuthUI.a(this.mGW, null);
    }
    AppMethodBeat.o(41633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.2
 * JD-Core Version:    0.7.0.1
 */