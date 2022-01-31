package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class j$a
  implements d
{
  public j$a(j paramj) {}
  
  public final void bC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41490);
    if (this.mGi.mFK)
    {
      ab.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
      AppMethodBeat.o(41490);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41490);
      return;
      ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
      Object localObject = this.mGi;
      ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
      ((j)localObject).mFK = true;
      com.tencent.mm.plugin.fingerprint.a.byD();
      com.tencent.mm.plugin.fingerprint.a.byE();
      ma localma = ((j)localObject).mGf;
      ((l)g.E(l.class)).a(localma, paramInt2);
      if (((j)localObject).mFK) {
        ((j)localObject).mGf = null;
      }
      ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
      j.bzx();
      AppMethodBeat.o(41490);
      return;
      ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
      this.mGi.mFK = false;
      j.bzx();
      this.mGi.hM(true);
      this.mGi.S(1, "");
      AppMethodBeat.o(41490);
      return;
      this.mGi.hM(false);
      ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
      AppMethodBeat.o(41490);
      return;
      ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
      AppMethodBeat.o(41490);
      return;
      ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.mGi.mFK = true;
      localObject = ah.getContext().getString(2131304072);
      if (paramInt1 == 10308) {
        localObject = ah.getContext().getString(2131304073);
      }
      for (;;)
      {
        j.bzx();
        this.mGi.S(2, (String)localObject);
        AppMethodBeat.o(41490);
        return;
        if (paramInt1 == 2007) {
          x.uli.mGD = true;
        } else if (paramInt1 == 2005) {
          localObject = ah.getContext().getString(2131304074);
        }
      }
      ab.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
      if (this.mGi.mGf != null) {
        com.tencent.mm.plugin.soter.d.a.Fw(this.mGi.mGf.cCa.cCd);
      }
      this.mGi.mFK = true;
      localObject = ah.getContext().getString(2131304072);
      j.bzx();
      this.mGi.S(paramInt1, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.j.a
 * JD-Core Version:    0.7.0.1
 */