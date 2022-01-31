package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.ab;

final class FingerPrintAuthTransparentUI$13
  implements a
{
  FingerPrintAuthTransparentUI$13(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(142017);
    this.mGQ.fV(false);
    if (paramInt == 0)
    {
      ab.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
      FingerPrintAuthTransparentUI.d(this.mGQ);
      FingerPrintAuthTransparentUI.a(this.mGQ, false);
      AppMethodBeat.o(142017);
      return;
    }
    FingerPrintAuthTransparentUI.a(this.mGQ, this.mGQ.getString(2131297668));
    AppMethodBeat.o(142017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.13
 * JD-Core Version:    0.7.0.1
 */