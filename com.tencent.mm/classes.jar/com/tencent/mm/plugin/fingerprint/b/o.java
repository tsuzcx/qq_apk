package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class o
{
  a rcn;
  
  public o(a parama)
  {
    this.rcn = parama;
  }
  
  public final void aXl()
  {
    AppMethodBeat.i(64388);
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64387);
        String str = "";
        if (d.ctW())
        {
          ad.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
          str = FingerPrintAuth.genRsaKey(d.eM(aj.getContext()), d.getUserId(), q.Xa());
        }
        for (;;)
        {
          if (o.this.rcn != null) {
            o.this.rcn.HQ(str);
          }
          AppMethodBeat.o(64387);
          return;
          ad.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
        }
      }
    }, getClass().getName());
    AppMethodBeat.o(64388);
  }
  
  public static abstract interface a
  {
    public abstract void HQ(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.o
 * JD-Core Version:    0.7.0.1
 */