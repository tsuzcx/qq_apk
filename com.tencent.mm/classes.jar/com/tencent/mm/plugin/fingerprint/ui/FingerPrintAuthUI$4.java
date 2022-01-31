package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class FingerPrintAuthUI$4
  implements Runnable
{
  FingerPrintAuthUI$4(FingerPrintAuthUI paramFingerPrintAuthUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(41636);
    h.a(this.mGW, this.val$text, "", this.mGW.getString(2131305099), false, new FingerPrintAuthUI.4.1(this));
    AppMethodBeat.o(41636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.4
 * JD-Core Version:    0.7.0.1
 */