package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class d$1
  implements Runnable
{
  d$1(d paramd, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(5372);
    d.a(this.mvl);
    int i = ((al)this.ckS).muu;
    d.ajx().remove(Integer.valueOf(i));
    if ((this.val$errCode != 3) || (this.val$errCode != 0)) {
      d.b(this.mvl);
    }
    com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kc(i);
    if ((localg == null) || (localg.field_itemStatus == 10))
    {
      AppMethodBeat.o(5372);
      return;
    }
    if ((this.val$errType == 0) && (this.val$errCode == 0)) {
      if (localg.field_itemStatus == 17)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(0), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.jU(localg.field_localId)) });
        ab.i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
        localg.field_itemStatus = 10;
        d.A(localg);
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().jY(localg.field_localId);
      }
    }
    while (d.c(this.mvl) > 0)
    {
      if (d.d(this.mvl)) {
        break label532;
      }
      d.startSync();
      AppMethodBeat.o(5372);
      return;
      Integer localInteger2 = Integer.valueOf(bo.a((Integer)d.access$400().get(Integer.valueOf(i)), 0));
      Integer localInteger1 = localInteger2;
      if (this.val$errType != 1)
      {
        localInteger1 = localInteger2;
        if (this.val$errType != 0) {
          localInteger1 = Integer.valueOf(localInteger2.intValue() - 1);
        }
      }
      if (localInteger1.intValue() <= 0)
      {
        int j = com.tencent.mm.plugin.fav.a.h.en(this.val$errType, this.val$errCode);
        com.tencent.mm.plugin.report.service.h.qsU.e(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(j), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.jU(localg.field_localId)) });
        d.access$400().remove(Integer.valueOf(i));
        ab.e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", new Object[] { Integer.valueOf(i) });
        localg.field_itemStatus = 18;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
      }
    }
    ab.i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
    d.e(this.mvl);
    label532:
    AppMethodBeat.o(5372);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(5373);
    String str = super.toString() + "|onSceneEnd";
    AppMethodBeat.o(5373);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.d.1
 * JD-Core Version:    0.7.0.1
 */