package com.tencent.mm.plugin.fav.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;

public final class a
  extends IListener<gw>
{
  private o tdg;
  private LruCache<Long, com.tencent.mm.plugin.fav.a.g> tlb;
  
  public a()
  {
    AppMethodBeat.i(107443);
    this.tlb = new LruCache(10);
    this.__eventId = gw.class.getName().hashCode();
    AppMethodBeat.o(107443);
  }
  
  private boolean a(gw paramgw)
  {
    AppMethodBeat.i(107444);
    com.tencent.mm.plugin.fav.a.g localg2;
    com.tencent.mm.plugin.fav.a.g localg1;
    if (paramgw.dKR.dFW != 0L) {
      if (paramgw.dKR.dKY)
      {
        localg2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramgw.dKR.dFW);
        localg1 = localg2;
        if (localg2 != null)
        {
          this.tlb.put(Long.valueOf(paramgw.dKR.dFW), localg2);
          localg1 = localg2;
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[] { Integer.valueOf(paramgw.dKR.opType), Long.valueOf(paramgw.dKR.dFW) });
      if ((localg1 == null) && (paramgw.dKR.opType != 3) && (paramgw.dKR.opType != 4))
      {
        AppMethodBeat.o(107444);
        return false;
        localg1 = (com.tencent.mm.plugin.fav.a.g)this.tlb.get(Long.valueOf(paramgw.dKR.dFW));
        if (localg1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.d("MicroMsg.FavImageServiceListener", "get item from cache itemInfo is null? %B", new Object[] { Boolean.valueOf(bool) });
          if (localg1 != null) {
            break label558;
          }
          localg2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramgw.dKR.dFW);
          localg1 = localg2;
          if (localg2 == null) {
            break;
          }
          this.tlb.put(Long.valueOf(paramgw.dKR.dFW), localg2);
          localg1 = localg2;
          break;
        }
      }
      switch (paramgw.dKR.opType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(107444);
        return false;
        paramgw.dKS.dKZ = o.a(paramgw.dKR.dKT, localg1);
        continue;
        Log.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[] { Boolean.valueOf(paramgw.dKR.dKW) });
        if (paramgw.dKR.dKW)
        {
          paramgw.dKS.dKZ = o.l(paramgw.dKR.dKT);
        }
        else
        {
          paramgw.dKS.dKZ = o.b(paramgw.dKR.dKT, localg1, paramgw.dKR.maxWidth);
          continue;
          if (this.tdg == null)
          {
            Log.w("MicroMsg.FavImageServiceListener", "imageServer is null");
          }
          else
          {
            this.tdg.b(paramgw.dKR.dKU, paramgw.dKR.dKT, localg1, paramgw.dKR.dKV, paramgw.dKR.width, paramgw.dKR.height);
            continue;
            Log.d("MicroMsg.FavImageServiceListener", "create image server");
            if (this.tdg != null) {
              this.tdg.destory();
            }
            this.tdg = new o(paramgw.dKR.context, 16);
            continue;
            Log.d("MicroMsg.FavImageServiceListener", "destroy image server");
            if (this.tdg != null)
            {
              this.tdg.destory();
              this.tdg = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.a
 * JD-Core Version:    0.7.0.1
 */