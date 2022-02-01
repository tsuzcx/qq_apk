package com.tencent.mm.plugin.fav.ui.listener;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ho;
import com.tencent.mm.autogen.a.ho.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;

public class FavImageServiceListener
  extends IListener<ho>
{
  private FavoriteImageServer AfM;
  private LruCache<Long, g> Aoc;
  
  public FavImageServiceListener()
  {
    super(f.hfK);
    AppMethodBeat.i(107443);
    this.Aoc = new LruCache(10);
    this.__eventId = ho.class.getName().hashCode();
    AppMethodBeat.o(107443);
  }
  
  private boolean a(ho paramho)
  {
    AppMethodBeat.i(107444);
    g localg2;
    g localg1;
    if (paramho.hIw.hDn != 0L) {
      if (paramho.hIw.hID)
      {
        localg2 = ((ah)h.az(ah.class)).getFavItemInfoStorage().mK(paramho.hIw.hDn);
        localg1 = localg2;
        if (localg2 != null)
        {
          this.Aoc.put(Long.valueOf(paramho.hIw.hDn), localg2);
          localg1 = localg2;
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[] { Integer.valueOf(paramho.hIw.opType), Long.valueOf(paramho.hIw.hDn) });
      if ((localg1 == null) && (paramho.hIw.opType != 3) && (paramho.hIw.opType != 4))
      {
        AppMethodBeat.o(107444);
        return false;
        localg1 = (g)this.Aoc.get(Long.valueOf(paramho.hIw.hDn));
        if (localg1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.d("MicroMsg.FavImageServiceListener", "get item from cache itemInfo is null? %B", new Object[] { Boolean.valueOf(bool) });
          if (localg1 != null) {
            break label558;
          }
          localg2 = ((ah)h.az(ah.class)).getFavItemInfoStorage().mK(paramho.hIw.hDn);
          localg1 = localg2;
          if (localg2 == null) {
            break;
          }
          this.Aoc.put(Long.valueOf(paramho.hIw.hDn), localg2);
          localg1 = localg2;
          break;
        }
      }
      switch (paramho.hIw.opType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(107444);
        return false;
        paramho.hIx.hIE = FavoriteImageServer.a(paramho.hIw.hIy, localg1);
        continue;
        Log.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[] { Boolean.valueOf(paramho.hIw.hIB) });
        if (paramho.hIw.hIB)
        {
          paramho.hIx.hIE = FavoriteImageServer.l(paramho.hIw.hIy);
        }
        else
        {
          paramho.hIx.hIE = FavoriteImageServer.b(paramho.hIw.hIy, localg1, paramho.hIw.maxWidth);
          continue;
          if (this.AfM == null)
          {
            Log.w("MicroMsg.FavImageServiceListener", "imageServer is null");
          }
          else
          {
            this.AfM.b(paramho.hIw.hIz, paramho.hIw.hIy, localg1, paramho.hIw.hIA, paramho.hIw.width, paramho.hIw.height);
            continue;
            Log.d("MicroMsg.FavImageServiceListener", "create image server");
            if (this.AfM != null) {
              this.AfM.destory();
            }
            this.AfM = new FavoriteImageServer(paramho.hIw.context, 16);
            continue;
            Log.d("MicroMsg.FavImageServiceListener", "destroy image server");
            if (this.AfM != null)
            {
              this.AfM.destory();
              this.AfM = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.listener.FavImageServiceListener
 * JD-Core Version:    0.7.0.1
 */