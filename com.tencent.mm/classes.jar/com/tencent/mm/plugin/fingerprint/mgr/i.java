package com.tencent.mm.plugin.fingerprint.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class i
{
  i.a Hgh;
  
  public i(i.a parama)
  {
    this.Hgh = parama;
  }
  
  public final void cpv()
  {
    AppMethodBeat.i(64388);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64387);
        String str = "";
        if (c.ftz())
        {
          Log.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
          str = FingerPrintAuth.genRsaKey(c.hA(MMApplicationContext.getContext()), c.getUserId(), q.aPg());
        }
        for (;;)
        {
          if (i.this.Hgh != null) {
            i.this.Hgh.aal(str);
          }
          AppMethodBeat.o(64387);
          return;
          Log.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
        }
      }
    }, getClass().getName());
    AppMethodBeat.o(64388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.i
 * JD-Core Version:    0.7.0.1
 */