package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class o
{
  a tsc;
  
  public o(a parama)
  {
    this.tsc = parama;
  }
  
  public final void biv()
  {
    AppMethodBeat.i(64388);
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64387);
        String str = "";
        if (d.cSc())
        {
          ae.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
          str = FingerPrintAuth.genRsaKey(d.fg(ak.getContext()), d.getUserId(), q.aaH());
        }
        for (;;)
        {
          if (o.this.tsc != null) {
            o.this.tsc.PZ(str);
          }
          AppMethodBeat.o(64387);
          return;
          ae.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
        }
      }
    }, getClass().getName());
    AppMethodBeat.o(64388);
  }
  
  public static abstract interface a
  {
    public abstract void PZ(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.o
 * JD-Core Version:    0.7.0.1
 */