package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class q$a$c
  implements Runnable
{
  q$a$c(long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(224137);
    Object localObject = ag.aGv().DM(this.DVm);
    if (localObject != null)
    {
      g localg;
      long l1;
      String str;
      long l2;
      int i;
      if (((w)localObject).ftb())
      {
        localObject = ((w)localObject).ftk();
        if ((localObject != null) && (((dmq)localObject).style == 1001) && (((dmq)localObject).HTU != null))
        {
          localg = g.yxI;
          l1 = System.currentTimeMillis();
          str = ((dmq)localObject).HTU.cardId;
          l2 = ((dmq)localObject).HDI;
          i = ((dmq)localObject).style;
          localObject = ((dmq)localObject).HTS;
          if (localObject == null) {
            break label178;
          }
        }
      }
      label178:
      for (localObject = ((aiq)localObject).Gau;; localObject = null)
      {
        localg.f(21064, new Object[] { Long.valueOf(l1), str, Long.valueOf(l2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(i), localObject });
        AppMethodBeat.o(224137);
        return;
      }
    }
    AppMethodBeat.o(224137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.q.a.c
 * JD-Core Version:    0.7.0.1
 */