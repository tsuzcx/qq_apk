package com.tencent.mm.plugin.fav.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  extends c<gs>
{
  private o rDB;
  private ah<Long, com.tencent.mm.plugin.fav.a.g> rLp;
  
  public a()
  {
    AppMethodBeat.i(107443);
    this.rLp = new ah(10);
    this.__eventId = gs.class.getName().hashCode();
    AppMethodBeat.o(107443);
  }
  
  private boolean a(gs paramgs)
  {
    AppMethodBeat.i(107444);
    com.tencent.mm.plugin.fav.a.g localg2;
    com.tencent.mm.plugin.fav.a.g localg1;
    if (paramgs.dtG.doH != 0L) {
      if (paramgs.dtG.dtN)
      {
        localg2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgs.dtG.doH);
        localg1 = localg2;
        if (localg2 != null)
        {
          this.rLp.put(Long.valueOf(paramgs.dtG.doH), localg2);
          localg1 = localg2;
        }
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[] { Integer.valueOf(paramgs.dtG.opType), Long.valueOf(paramgs.dtG.doH) });
      if ((localg1 == null) && (paramgs.dtG.opType != 3) && (paramgs.dtG.opType != 4))
      {
        AppMethodBeat.o(107444);
        return false;
        localg1 = (com.tencent.mm.plugin.fav.a.g)this.rLp.get(Long.valueOf(paramgs.dtG.doH));
        if (localg1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          ae.d("MicroMsg.FavImageServiceListener", "get item from cache itemInfo is null? %B", new Object[] { Boolean.valueOf(bool) });
          if (localg1 != null) {
            break label558;
          }
          localg2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramgs.dtG.doH);
          localg1 = localg2;
          if (localg2 == null) {
            break;
          }
          this.rLp.put(Long.valueOf(paramgs.dtG.doH), localg2);
          localg1 = localg2;
          break;
        }
      }
      switch (paramgs.dtG.opType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(107444);
        return false;
        paramgs.dtH.dtO = o.a(paramgs.dtG.dtI, localg1);
        continue;
        ae.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[] { Boolean.valueOf(paramgs.dtG.dtL) });
        if (paramgs.dtG.dtL)
        {
          paramgs.dtH.dtO = o.l(paramgs.dtG.dtI);
        }
        else
        {
          paramgs.dtH.dtO = o.b(paramgs.dtG.dtI, localg1, paramgs.dtG.maxWidth);
          continue;
          if (this.rDB == null)
          {
            ae.w("MicroMsg.FavImageServiceListener", "imageServer is null");
          }
          else
          {
            this.rDB.b(paramgs.dtG.dtJ, paramgs.dtG.dtI, localg1, paramgs.dtG.dtK, paramgs.dtG.width, paramgs.dtG.height);
            continue;
            ae.d("MicroMsg.FavImageServiceListener", "create image server");
            if (this.rDB != null) {
              this.rDB.destory();
            }
            this.rDB = new o(paramgs.dtG.context, 16);
            continue;
            ae.d("MicroMsg.FavImageServiceListener", "destroy image server");
            if (this.rDB != null)
            {
              this.rDB.destory();
              this.rDB = null;
            }
          }
        }
      }
      label558:
      continue;
      localg1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.a
 * JD-Core Version:    0.7.0.1
 */