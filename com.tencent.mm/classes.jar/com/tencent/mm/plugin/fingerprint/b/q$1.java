package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class q$1
  implements Runnable
{
  q$1(q paramq) {}
  
  public final void run()
  {
    String str = "";
    if (e.aSK())
    {
      y.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
      str = FingerPrintAuth.genRsaKey(e.dj(ae.getContext()), e.getUserId(), com.tencent.mm.compatible.e.q.zg());
    }
    for (;;)
    {
      if (this.klI.klH != null) {
        this.klI.klH.tT(str);
      }
      return;
      y.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.q.1
 * JD-Core Version:    0.7.0.1
 */