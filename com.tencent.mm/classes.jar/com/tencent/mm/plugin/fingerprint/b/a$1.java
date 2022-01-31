package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.bs;
import com.tencent.mm.h.a.bs.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;

final class a$1
  implements Runnable
{
  a$1(a parama, bs parambs) {}
  
  public final void run()
  {
    if (this.kkU.bHT != null)
    {
      if (this.kkU.bHT.retCode != 0) {
        break label77;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseFingerprintImp", "close finger print success!");
      if (!q.Gw())
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseFingerprintImp", "do bound query, update data");
        g.DQ();
        g.DO().dJT.a(new com.tencent.mm.plugin.wallet_core.c.y(null, 19), 0);
      }
    }
    else
    {
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseFingerprintImp", "now context is isPayUPay!");
    return;
    label77:
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseFingerprintImp", "close finger print failed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.1
 * JD-Core Version:    0.7.0.1
 */