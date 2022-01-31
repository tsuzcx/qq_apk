package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class d$1
  implements Runnable
{
  d$1(d paramd, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    d.a(this.kaP);
    int i = ((al)this.bEe).jZY;
    d.Qq().remove(Integer.valueOf(i));
    if ((this.bEg != 3) || (this.bEg != 0)) {
      d.b(this.kaP);
    }
    com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eF(i);
    if ((localg == null) || (localg.field_itemStatus == 10)) {
      return;
    }
    if ((this.bEf == 0) && (this.bEg == 0)) {
      if (localg.field_itemStatus == 17)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.ex(localg.field_localId)) });
        y.i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
        localg.field_itemStatus = 10;
        d.A(localg);
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().eB(localg.field_localId);
      }
    }
    for (;;)
    {
      if (d.c(this.kaP) <= 0) {
        break label500;
      }
      if (d.d(this.kaP)) {
        break;
      }
      d.startSync();
      return;
      Integer localInteger2 = Integer.valueOf(bk.a((Integer)d.aQV().get(Integer.valueOf(i)), 0));
      Integer localInteger1 = localInteger2;
      if (this.bEf != 1)
      {
        localInteger1 = localInteger2;
        if (this.bEf != 0) {
          localInteger1 = Integer.valueOf(localInteger2.intValue() - 1);
        }
      }
      if (localInteger1.intValue() <= 0)
      {
        int j = com.tencent.mm.plugin.fav.a.h.cP(this.bEf, this.bEg);
        com.tencent.mm.plugin.report.service.h.nFQ.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(j), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.ex(localg.field_localId)) });
        d.aQV().remove(Integer.valueOf(i));
        y.e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", new Object[] { Integer.valueOf(i) });
        localg.field_itemStatus = 18;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
      }
    }
    label500:
    y.i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
    d.e(this.kaP);
  }
  
  public final String toString()
  {
    return super.toString() + "|onSceneEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.d.1
 * JD-Core Version:    0.7.0.1
 */