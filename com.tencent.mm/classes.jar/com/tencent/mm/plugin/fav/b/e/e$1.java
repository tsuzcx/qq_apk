package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.Set;

final class e$1
  implements Runnable
{
  e$1(e parame, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(5388);
    if (this.ckS.getType() != 401)
    {
      AppMethodBeat.o(5388);
      return;
    }
    if (!(this.ckS instanceof af))
    {
      AppMethodBeat.o(5388);
      return;
    }
    e.a(this.mvn);
    com.tencent.mm.plugin.fav.a.g localg = ((af)this.ckS).mud;
    long l = localg.field_localId;
    e.ajx().remove(Long.valueOf(l));
    if (((this.val$errType == 0) && (this.val$errCode == 0)) || (this.val$errCode == -400)) {
      e.aBJ().add(Long.valueOf(l));
    }
    if ((this.val$errType != 0) && (this.val$errCode != -400)) {
      e.b(this.mvn);
    }
    Integer localInteger2 = Integer.valueOf(bo.a((Integer)e.access$400().get(Long.valueOf(l)), 0));
    Integer localInteger1 = localInteger2;
    if (this.val$errType != 1)
    {
      localInteger1 = localInteger2;
      if (this.val$errType != 0)
      {
        localInteger1 = Integer.valueOf(localInteger2.intValue() - 1);
        e.access$400().put(Long.valueOf(localg.field_localId), localInteger1);
      }
    }
    if (localInteger1.intValue() <= 0)
    {
      int i = com.tencent.mm.plugin.fav.a.h.en(this.val$errType, this.val$errCode);
      com.tencent.mm.plugin.report.service.h.qsU.e(10659, new Object[] { Integer.valueOf(0), Integer.valueOf(localg.field_type), Integer.valueOf(i), Long.valueOf(b.b(localg)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.jU(localg.field_localId)) });
      e.access$400().remove(Long.valueOf(l));
      ab.e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", new Object[] { Long.valueOf(l) });
      if (localg.field_itemStatus == 12) {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(14, localg.field_localId);
      }
      if (localg.field_itemStatus == 9) {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().O(11, localg.field_localId);
      }
    }
    if (e.c(this.mvn) > 0)
    {
      if (!e.d(this.mvn))
      {
        e.startSync();
        AppMethodBeat.o(5388);
      }
    }
    else
    {
      ab.i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
      e.e(this.mvn);
    }
    AppMethodBeat.o(5388);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(5389);
    String str = super.toString() + "|onSceneEnd";
    AppMethodBeat.o(5389);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.e.1
 * JD-Core Version:    0.7.0.1
 */