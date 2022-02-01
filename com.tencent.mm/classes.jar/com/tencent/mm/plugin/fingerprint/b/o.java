package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class o
{
  a wFI;
  
  public o(a parama)
  {
    this.wFI = parama;
  }
  
  public final void bDI()
  {
    AppMethodBeat.i(64388);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64387);
        String str = "";
        if (d.dJX())
        {
          Log.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
          str = FingerPrintAuth.genRsaKey(d.fL(MMApplicationContext.getContext()), d.getUserId(), q.aoG());
        }
        for (;;)
        {
          if (o.this.wFI != null) {
            o.this.wFI.ZA(str);
          }
          AppMethodBeat.o(64387);
          return;
          Log.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
        }
      }
    }, getClass().getName());
    AppMethodBeat.o(64388);
  }
  
  public static abstract interface a
  {
    public abstract void ZA(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.o
 * JD-Core Version:    0.7.0.1
 */