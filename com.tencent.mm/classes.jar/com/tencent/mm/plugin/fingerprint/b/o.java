package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class o
{
  a skH;
  
  public o(a parama)
  {
    this.skH = parama;
  }
  
  public final void bei()
  {
    AppMethodBeat.i(64388);
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64387);
        String str = "";
        if (d.cHi())
        {
          ac.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
          str = FingerPrintAuth.genRsaKey(d.eZ(ai.getContext()), d.getUserId(), q.XX());
        }
        for (;;)
        {
          if (o.this.skH != null) {
            o.this.skH.LV(str);
          }
          AppMethodBeat.o(64387);
          return;
          ac.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
        }
      }
    }, getClass().getName());
    AppMethodBeat.o(64388);
  }
  
  public static abstract interface a
  {
    public abstract void LV(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.o
 * JD-Core Version:    0.7.0.1
 */