package com.tencent.mm.plugin.fingerprint.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class FingerPrintAuthTransparentUI$1
  implements d
{
  FingerPrintAuthTransparentUI$1(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void bC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41597);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41597);
      return;
      ab.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
      FingerPrintAuthTransparentUI.a(this.mGQ, paramInt2);
      FingerPrintAuthTransparentUI.a(this.mGQ);
      AppMethodBeat.o(41597);
      return;
      ab.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
      FingerPrintAuthTransparentUI.b(this.mGQ);
      FingerPrintAuthTransparentUI.a(this.mGQ, true);
      AppMethodBeat.o(41597);
      return;
      ab.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
      AppMethodBeat.o(41597);
      return;
      String str = ah.getContext().getString(2131304074);
      a.d(1000, -1000223, paramInt1, "fingerprint error");
      FingerPrintAuthTransparentUI.a(this.mGQ, str);
      AppMethodBeat.o(41597);
      return;
      ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
      str = ah.getContext().getString(2131304072);
      if (paramInt1 == 10308)
      {
        str = ah.getContext().getString(2131304073);
        a.d(6, -1000223, -1, "too many trial");
      }
      for (;;)
      {
        FingerPrintAuthTransparentUI.a(this.mGQ, str);
        AppMethodBeat.o(41597);
        return;
        a.d(1000, -1000223, paramInt1, "fingerprint error");
      }
      ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
      str = ah.getContext().getString(2131304072);
      a.d(1000, -1000223, paramInt1, "fingerprint error");
      a.Fw(2);
      FingerPrintAuthTransparentUI.a(this.mGQ, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.1
 * JD-Core Version:    0.7.0.1
 */