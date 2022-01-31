package com.tencent.mm.plugin.fingerprint.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;

public final class FingerPrintAuthUI$a
  implements d
{
  private WeakReference<FingerPrintAuthUI> mGZ;
  
  public FingerPrintAuthUI$a(FingerPrintAuthUI paramFingerPrintAuthUI1, FingerPrintAuthUI paramFingerPrintAuthUI2)
  {
    AppMethodBeat.i(41638);
    this.mGZ = null;
    this.mGZ = new WeakReference(paramFingerPrintAuthUI2);
    AppMethodBeat.o(41638);
  }
  
  private FingerPrintAuthUI bzG()
  {
    AppMethodBeat.i(41639);
    if (this.mGZ != null)
    {
      FingerPrintAuthUI localFingerPrintAuthUI = (FingerPrintAuthUI)this.mGZ.get();
      AppMethodBeat.o(41639);
      return localFingerPrintAuthUI;
    }
    AppMethodBeat.o(41639);
    return null;
  }
  
  public final void bC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41640);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41640);
      return;
      ab.i("MicroMsg.FingerPrintAuthUI", "identify success");
      if (bzG() != null)
      {
        FingerPrintAuthUI.a(bzG(), paramInt2);
        AppMethodBeat.o(41640);
        return;
        ab.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
        if (bzG() != null)
        {
          FingerPrintAuthUI.a(bzG());
          FingerPrintAuthUI.a(this.mGW, true);
          AppMethodBeat.o(41640);
          return;
          ab.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
          if (bzG() != null)
          {
            FingerPrintAuthUI.a(this.mGW, false);
            AppMethodBeat.o(41640);
            return;
            String str = ah.getContext().getString(2131304074);
            a.d(1000, -1000223, paramInt1, "fingerprint error");
            if (bzG() != null)
            {
              FingerPrintAuthUI.a(bzG(), str, -1);
              AppMethodBeat.o(41640);
              return;
              ab.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
              str = ah.getContext().getString(2131304072);
              if (paramInt1 == 10308)
              {
                str = ah.getContext().getString(2131304073);
                a.d(6, -1000223, -1, "too many trial");
              }
              while (bzG() != null)
              {
                FingerPrintAuthUI.a(bzG(), str, -1);
                AppMethodBeat.o(41640);
                return;
                a.d(1000, -1000223, paramInt1, "fingerprint error");
              }
              ab.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
              str = ah.getContext().getString(2131304072);
              a.d(1000, -1000223, paramInt1, "fingerprint error");
              a.Fw(2);
              if (bzG() != null) {
                FingerPrintAuthUI.a(bzG(), str, -1);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.a
 * JD-Core Version:    0.7.0.1
 */