package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class o
{
  o.a thj;
  
  public o(o.a parama)
  {
    this.thj = parama;
  }
  
  public final void bhM()
  {
    AppMethodBeat.i(64388);
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64387);
        String str = "";
        if (d.cPx())
        {
          ad.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
          str = FingerPrintAuth.genRsaKey(d.fc(aj.getContext()), d.getUserId(), q.aay());
        }
        for (;;)
        {
          if (o.this.thj != null) {
            o.this.thj.Pr(str);
          }
          AppMethodBeat.o(64387);
          return;
          ad.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
        }
      }
    }, getClass().getName());
    AppMethodBeat.o(64388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.o
 * JD-Core Version:    0.7.0.1
 */