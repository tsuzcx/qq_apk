package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.a;

final class FingerPrintAuthUI$1
  implements a
{
  FingerPrintAuthUI$1(FingerPrintAuthUI paramFingerPrintAuthUI) {}
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(41632);
    this.mGW.fV(false);
    if (paramInt == 0)
    {
      FingerPrintAuthUI.b(this.mGW);
      if (FingerPrintAuthUI.c(this.mGW))
      {
        FingerPrintAuthUI.a(this.mGW, false);
        AppMethodBeat.o(41632);
      }
    }
    else
    {
      FingerPrintAuthUI.a(this.mGW, this.mGW.getString(2131297668), paramInt);
    }
    AppMethodBeat.o(41632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.1
 * JD-Core Version:    0.7.0.1
 */