package com.tencent.mm.plugin.fav.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.gn.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;

public final class a
  extends c<gn>
{
  private o qcI;
  private ag<Long, com.tencent.mm.plugin.fav.a.g> qkz;
  
  public a()
  {
    AppMethodBeat.i(107443);
    this.qkz = new ag(10);
    this.__eventId = gn.class.getName().hashCode();
    AppMethodBeat.o(107443);
  }
  
  private boolean a(gn paramgn)
  {
    AppMethodBeat.i(107444);
    com.tencent.mm.plugin.fav.a.g localg2;
    com.tencent.mm.plugin.fav.a.g localg1;
    if (paramgn.djH.deL != 0L) {
      if (paramgn.djH.djO)
      {
        localg2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgn.djH.deL);
        localg1 = localg2;
        if (localg2 != null)
        {
          this.qkz.put(Long.valueOf(paramgn.djH.deL), localg2);
          localg1 = localg2;
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[] { Integer.valueOf(paramgn.djH.opType), Long.valueOf(paramgn.djH.deL) });
      if ((localg1 == null) && (paramgn.djH.opType != 3) && (paramgn.djH.opType != 4))
      {
        AppMethodBeat.o(107444);
        return false;
        localg1 = (com.tencent.mm.plugin.fav.a.g)this.qkz.get(Long.valueOf(paramgn.djH.deL));
        if (localg1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.d("MicroMsg.FavImageServiceListener", "get item from cache itemInfo is null? %B", new Object[] { Boolean.valueOf(bool) });
          if (localg1 != null) {
            break label558;
          }
          localg2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramgn.djH.deL);
          localg1 = localg2;
          if (localg2 == null) {
            break;
          }
          this.qkz.put(Long.valueOf(paramgn.djH.deL), localg2);
          localg1 = localg2;
          break;
        }
      }
      switch (paramgn.djH.opType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(107444);
        return false;
        paramgn.djI.djP = o.a(paramgn.djH.djJ, localg1);
        continue;
        ad.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[] { Boolean.valueOf(paramgn.djH.djM) });
        if (paramgn.djH.djM)
        {
          paramgn.djI.djP = o.l(paramgn.djH.djJ);
        }
        else
        {
          paramgn.djI.djP = o.b(paramgn.djH.djJ, localg1, paramgn.djH.maxWidth);
          continue;
          if (this.qcI == null)
          {
            ad.w("MicroMsg.FavImageServiceListener", "imageServer is null");
          }
          else
          {
            this.qcI.b(paramgn.djH.djK, paramgn.djH.djJ, localg1, paramgn.djH.djL, paramgn.djH.width, paramgn.djH.height);
            continue;
            ad.d("MicroMsg.FavImageServiceListener", "create image server");
            if (this.qcI != null) {
              this.qcI.destory();
            }
            this.qcI = new o(paramgn.djH.context, 16);
            continue;
            ad.d("MicroMsg.FavImageServiceListener", "destroy image server");
            if (this.qcI != null)
            {
              this.qcI.destory();
              this.qcI = null;
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