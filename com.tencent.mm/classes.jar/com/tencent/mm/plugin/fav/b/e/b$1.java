package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ai;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class b$1
  implements Runnable
{
  b$1(b paramb, m paramm, int paramInt) {}
  
  public final void run()
  {
    if (this.bEe.getType() != 404) {}
    while (!(this.bEe instanceof ai)) {
      return;
    }
    b.a(this.kaK);
    long l = ((ai)this.bEe).jZN.field_localId;
    com.tencent.mm.plugin.fav.a.g localg = ((ai)this.bEe).jZN;
    b.Qq().remove(Long.valueOf(l));
    if (this.bEf != 0)
    {
      y.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.h.nFQ.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(-2), Long.valueOf(com.tencent.mm.plugin.fav.a.b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.ex(localg.field_localId)) });
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(3, l);
    }
    b.b(this.kaK);
  }
  
  public final String toString()
  {
    return super.toString() + "|onSceneEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.b.1
 * JD-Core Version:    0.7.0.1
 */