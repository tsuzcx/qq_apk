package com.tencent.mm.plugin.fav.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.gr.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;

public final class a
  extends c<gr>
{
  private ag<Long, com.tencent.mm.plugin.fav.a.g> rDe;
  private o rvp;
  
  public a()
  {
    AppMethodBeat.i(107443);
    this.rDe = new ag(10);
    this.__eventId = gr.class.getName().hashCode();
    AppMethodBeat.o(107443);
  }
  
  private boolean a(gr paramgr)
  {
    AppMethodBeat.i(107444);
    com.tencent.mm.plugin.fav.a.g localg2;
    com.tencent.mm.plugin.fav.a.g localg1;
    if (paramgr.dsA.dnC != 0L) {
      if (paramgr.dsA.dsH)
      {
        localg2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgr.dsA.dnC);
        localg1 = localg2;
        if (localg2 != null)
        {
          this.rDe.put(Long.valueOf(paramgr.dsA.dnC), localg2);
          localg1 = localg2;
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[] { Integer.valueOf(paramgr.dsA.opType), Long.valueOf(paramgr.dsA.dnC) });
      if ((localg1 == null) && (paramgr.dsA.opType != 3) && (paramgr.dsA.opType != 4))
      {
        AppMethodBeat.o(107444);
        return false;
        localg1 = (com.tencent.mm.plugin.fav.a.g)this.rDe.get(Long.valueOf(paramgr.dsA.dnC));
        if (localg1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.d("MicroMsg.FavImageServiceListener", "get item from cache itemInfo is null? %B", new Object[] { Boolean.valueOf(bool) });
          if (localg1 != null) {
            break label558;
          }
          localg2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramgr.dsA.dnC);
          localg1 = localg2;
          if (localg2 == null) {
            break;
          }
          this.rDe.put(Long.valueOf(paramgr.dsA.dnC), localg2);
          localg1 = localg2;
          break;
        }
      }
      switch (paramgr.dsA.opType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(107444);
        return false;
        paramgr.dsB.dsI = o.a(paramgr.dsA.dsC, localg1);
        continue;
        ad.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[] { Boolean.valueOf(paramgr.dsA.dsF) });
        if (paramgr.dsA.dsF)
        {
          paramgr.dsB.dsI = o.l(paramgr.dsA.dsC);
        }
        else
        {
          paramgr.dsB.dsI = o.b(paramgr.dsA.dsC, localg1, paramgr.dsA.maxWidth);
          continue;
          if (this.rvp == null)
          {
            ad.w("MicroMsg.FavImageServiceListener", "imageServer is null");
          }
          else
          {
            this.rvp.b(paramgr.dsA.dsD, paramgr.dsA.dsC, localg1, paramgr.dsA.dsE, paramgr.dsA.width, paramgr.dsA.height);
            continue;
            ad.d("MicroMsg.FavImageServiceListener", "create image server");
            if (this.rvp != null) {
              this.rvp.destory();
            }
            this.rvp = new o(paramgr.dsA.context, 16);
            continue;
            ad.d("MicroMsg.FavImageServiceListener", "destroy image server");
            if (this.rvp != null)
            {
              this.rvp.destory();
              this.rvp = null;
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