package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class q$1
  implements Runnable
{
  q$1(q paramq) {}
  
  public final void run()
  {
    AppMethodBeat.i(41559);
    String str = "";
    if (e.bzf())
    {
      ab.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
      str = FingerPrintAuth.genRsaKey(e.dU(ah.getContext()), e.getUserId(), com.tencent.mm.compatible.e.q.LK());
    }
    for (;;)
    {
      if (this.mGw.mGv != null) {
        this.mGw.mGv.BS(str);
      }
      AppMethodBeat.o(41559);
      return;
      ab.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.q.1
 * JD-Core Version:    0.7.0.1
 */