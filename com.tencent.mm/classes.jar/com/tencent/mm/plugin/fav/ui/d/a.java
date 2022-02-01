package com.tencent.mm.plugin.fav.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.go.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends c<go>
{
  private o qLn;
  private com.tencent.mm.sdk.platformtools.af<Long, com.tencent.mm.plugin.fav.a.g> qTb;
  
  public a()
  {
    AppMethodBeat.i(107443);
    this.qTb = new com.tencent.mm.sdk.platformtools.af(10);
    this.__eventId = go.class.getName().hashCode();
    AppMethodBeat.o(107443);
  }
  
  private boolean a(go paramgo)
  {
    AppMethodBeat.i(107444);
    com.tencent.mm.plugin.fav.a.g localg2;
    com.tencent.mm.plugin.fav.a.g localg1;
    if (paramgo.dhc.dcg != 0L) {
      if (paramgo.dhc.dhj)
      {
        localg2 = ((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getFavItemInfoStorage().tH(paramgo.dhc.dcg);
        localg1 = localg2;
        if (localg2 != null)
        {
          this.qTb.put(Long.valueOf(paramgo.dhc.dcg), localg2);
          localg1 = localg2;
        }
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[] { Integer.valueOf(paramgo.dhc.opType), Long.valueOf(paramgo.dhc.dcg) });
      if ((localg1 == null) && (paramgo.dhc.opType != 3) && (paramgo.dhc.opType != 4))
      {
        AppMethodBeat.o(107444);
        return false;
        localg1 = (com.tencent.mm.plugin.fav.a.g)this.qTb.get(Long.valueOf(paramgo.dhc.dcg));
        if (localg1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          ac.d("MicroMsg.FavImageServiceListener", "get item from cache itemInfo is null? %B", new Object[] { Boolean.valueOf(bool) });
          if (localg1 != null) {
            break label558;
          }
          localg2 = ((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getFavItemInfoStorage().tH(paramgo.dhc.dcg);
          localg1 = localg2;
          if (localg2 == null) {
            break;
          }
          this.qTb.put(Long.valueOf(paramgo.dhc.dcg), localg2);
          localg1 = localg2;
          break;
        }
      }
      switch (paramgo.dhc.opType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(107444);
        return false;
        paramgo.dhd.dhk = o.a(paramgo.dhc.dhe, localg1);
        continue;
        ac.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[] { Boolean.valueOf(paramgo.dhc.dhh) });
        if (paramgo.dhc.dhh)
        {
          paramgo.dhd.dhk = o.l(paramgo.dhc.dhe);
        }
        else
        {
          paramgo.dhd.dhk = o.b(paramgo.dhc.dhe, localg1, paramgo.dhc.maxWidth);
          continue;
          if (this.qLn == null)
          {
            ac.w("MicroMsg.FavImageServiceListener", "imageServer is null");
          }
          else
          {
            this.qLn.b(paramgo.dhc.dhf, paramgo.dhc.dhe, localg1, paramgo.dhc.dhg, paramgo.dhc.width, paramgo.dhc.height);
            continue;
            ac.d("MicroMsg.FavImageServiceListener", "create image server");
            if (this.qLn != null) {
              this.qLn.destory();
            }
            this.qLn = new o(paramgo.dhc.context, 16);
            continue;
            ac.d("MicroMsg.FavImageServiceListener", "destroy image server");
            if (this.qLn != null)
            {
              this.qLn.destory();
              this.qLn = null;
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
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.a
 * JD-Core Version:    0.7.0.1
 */