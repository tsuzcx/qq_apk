package com.tencent.mm.plugin.fav.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hd;
import com.tencent.mm.f.a.hd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;

public final class a
  extends IListener<hd>
{
  private o wJr;
  private LruCache<Long, g> wRz;
  
  public a()
  {
    AppMethodBeat.i(107443);
    this.wRz = new LruCache(10);
    this.__eventId = hd.class.getName().hashCode();
    AppMethodBeat.o(107443);
  }
  
  private boolean a(hd paramhd)
  {
    AppMethodBeat.i(107444);
    g localg2;
    g localg1;
    if (paramhd.fDG.fyE != 0L) {
      if (paramhd.fDG.fDN)
      {
        localg2 = ((ag)h.ag(ag.class)).getFavItemInfoStorage().Km(paramhd.fDG.fyE);
        localg1 = localg2;
        if (localg2 != null)
        {
          this.wRz.put(Long.valueOf(paramhd.fDG.fyE), localg2);
          localg1 = localg2;
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[] { Integer.valueOf(paramhd.fDG.opType), Long.valueOf(paramhd.fDG.fyE) });
      if ((localg1 == null) && (paramhd.fDG.opType != 3) && (paramhd.fDG.opType != 4))
      {
        AppMethodBeat.o(107444);
        return false;
        localg1 = (g)this.wRz.get(Long.valueOf(paramhd.fDG.fyE));
        if (localg1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.d("MicroMsg.FavImageServiceListener", "get item from cache itemInfo is null? %B", new Object[] { Boolean.valueOf(bool) });
          if (localg1 != null) {
            break label558;
          }
          localg2 = ((ag)h.ag(ag.class)).getFavItemInfoStorage().Km(paramhd.fDG.fyE);
          localg1 = localg2;
          if (localg2 == null) {
            break;
          }
          this.wRz.put(Long.valueOf(paramhd.fDG.fyE), localg2);
          localg1 = localg2;
          break;
        }
      }
      switch (paramhd.fDG.opType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(107444);
        return false;
        paramhd.fDH.fDO = o.a(paramhd.fDG.fDI, localg1);
        continue;
        Log.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[] { Boolean.valueOf(paramhd.fDG.fDL) });
        if (paramhd.fDG.fDL)
        {
          paramhd.fDH.fDO = o.l(paramhd.fDG.fDI);
        }
        else
        {
          paramhd.fDH.fDO = o.b(paramhd.fDG.fDI, localg1, paramhd.fDG.maxWidth);
          continue;
          if (this.wJr == null)
          {
            Log.w("MicroMsg.FavImageServiceListener", "imageServer is null");
          }
          else
          {
            this.wJr.b(paramhd.fDG.fDJ, paramhd.fDG.fDI, localg1, paramhd.fDG.fDK, paramhd.fDG.width, paramhd.fDG.height);
            continue;
            Log.d("MicroMsg.FavImageServiceListener", "create image server");
            if (this.wJr != null) {
              this.wJr.destory();
            }
            this.wJr = new o(paramhd.fDG.context, 16);
            continue;
            Log.d("MicroMsg.FavImageServiceListener", "destroy image server");
            if (this.wJr != null)
            {
              this.wJr.destory();
              this.wJr = null;
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