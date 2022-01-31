package com.tencent.mm.ak;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class f$3
  implements com.tencent.mm.ah.f
{
  f$3(f paramf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (!(paramm instanceof d)) {
      y.w("MicroMsg.SubCoreCdnTransport", "get cdn dns on scene end but is not [NetSceneGetCdnDns]");
    }
    do
    {
      do
      {
        return;
        y.i("MicroMsg.SubCoreCdnTransport", "%d get cdn dns on scene end errType[%d] errCode[%d] errMsg[%s] lastGetDnsErrorTime[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(f.a(this.ejz)) });
        if ("doScene failed".equals(paramString))
        {
          y.d("MicroMsg.SubCoreCdnTransport", "%d get cdn dns cache do nothing.", new Object[] { Integer.valueOf(hashCode()) });
          return;
        }
        h.nFQ.a(546L, paramInt1 + 10, 1L, true);
        if (paramInt1 != 0) {
          break;
        }
      } while (f.a(this.ejz) <= 0L);
      h.nFQ.a(546L, 52L, 1L, true);
      f.a(this.ejz, 0L);
      return;
    } while (paramInt1 == 4);
    if (f.a(this.ejz) == 0L)
    {
      paramInt1 = ((d)paramm).scene;
      f.a(this.ejz, bk.UY());
      f.b(this.ejz).removeMessages(1);
      f.b(this.ejz).sendMessageDelayed(f.b(this.ejz).obtainMessage(1, paramInt1, 0), 30000L);
      h.nFQ.a(546L, 50L, 1L, true);
      return;
    }
    f.a(this.ejz, 0L);
    h.nFQ.a(546L, 51L, 1L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ak.f.3
 * JD-Core Version:    0.7.0.1
 */