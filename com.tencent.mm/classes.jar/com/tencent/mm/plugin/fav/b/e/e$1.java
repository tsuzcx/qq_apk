package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import java.util.Set;

final class e$1
  implements Runnable
{
  e$1(e parame, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if (this.bEe.getType() != 401) {}
    do
    {
      do
      {
        return;
      } while (!(this.bEe instanceof af));
      e.a(this.kaR);
      com.tencent.mm.plugin.fav.a.g localg = ((af)this.bEe).jZG;
      long l = localg.field_localId;
      e.Qq().remove(Long.valueOf(l));
      if (((this.bEf == 0) && (this.bEg == 0)) || (this.bEg == -400)) {
        e.aon().add(Long.valueOf(l));
      }
      if ((this.bEf != 0) && (this.bEg != -400)) {
        e.b(this.kaR);
      }
      Integer localInteger2 = Integer.valueOf(bk.a((Integer)e.aQV().get(Long.valueOf(l)), 0));
      Integer localInteger1 = localInteger2;
      if (this.bEf != 1)
      {
        localInteger1 = localInteger2;
        if (this.bEf != 0)
        {
          localInteger1 = Integer.valueOf(localInteger2.intValue() - 1);
          e.aQV().put(Long.valueOf(localg.field_localId), localInteger1);
        }
      }
      if (localInteger1.intValue() <= 0)
      {
        int i = com.tencent.mm.plugin.fav.a.h.cP(this.bEf, this.bEg);
        com.tencent.mm.plugin.report.service.h.nFQ.f(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(i), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.ex(localg.field_localId)) });
        e.aQV().remove(Long.valueOf(l));
        y.e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
        if (localg.field_itemStatus == 12) {
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(14, localg.field_localId);
        }
        if (localg.field_itemStatus == 9) {
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().x(11, localg.field_localId);
        }
      }
      if (e.c(this.kaR) <= 0) {
        break;
      }
    } while (e.d(this.kaR));
    e.startSync();
    return;
    y.i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
    e.e(this.kaR);
  }
  
  public final String toString()
  {
    return super.toString() + "|onSceneEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.e.1
 * JD-Core Version:    0.7.0.1
 */