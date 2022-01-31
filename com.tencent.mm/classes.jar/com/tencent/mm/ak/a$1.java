package com.tencent.mm.ak;

import com.tencent.mm.model.am.e;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements com.tencent.mm.sdk.platformtools.am.a
{
  a$1(a parama) {}
  
  public final boolean tC()
  {
    if ((a.a(this.eiB) == 0) && (a.b(this.eiB) == 0)) {
      return false;
    }
    y.i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", new Object[] { a.c(this.eiB), Integer.valueOf(a.a(this.eiB)), Integer.valueOf(a.b(this.eiB)) });
    if (com.tencent.mm.model.am.a.dVz == null)
    {
      y.e("MicroMsg.CdnTransportEngine", "getNetStat null");
      return false;
    }
    com.tencent.mm.model.am.a.dVz.bg(a.b(this.eiB), a.a(this.eiB));
    a.d(this.eiB);
    a.e(this.eiB);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ak.a.1
 * JD-Core Version:    0.7.0.1
 */