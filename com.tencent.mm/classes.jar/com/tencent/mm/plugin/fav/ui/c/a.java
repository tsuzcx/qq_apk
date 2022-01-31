package com.tencent.mm.plugin.fav.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.g.a.gf.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends c<gf>
{
  private com.tencent.mm.sdk.platformtools.ae<Long, com.tencent.mm.plugin.fav.a.g> mCR;
  private l mvC;
  
  public a()
  {
    AppMethodBeat.i(74609);
    this.mCR = new com.tencent.mm.sdk.platformtools.ae(10);
    this.__eventId = gf.class.getName().hashCode();
    AppMethodBeat.o(74609);
  }
  
  private boolean a(gf paramgf)
  {
    AppMethodBeat.i(74610);
    com.tencent.mm.plugin.fav.a.g localg2;
    com.tencent.mm.plugin.fav.a.g localg1;
    if (paramgf.cuJ.cpM != 0L) {
      if (paramgf.cuJ.cuQ)
      {
        localg2 = ((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().kb(paramgf.cuJ.cpM);
        localg1 = localg2;
        if (localg2 != null)
        {
          this.mCR.put(Long.valueOf(paramgf.cuJ.cpM), localg2);
          localg1 = localg2;
        }
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[] { Integer.valueOf(paramgf.cuJ.opType), Long.valueOf(paramgf.cuJ.cpM) });
      if ((localg1 == null) && (paramgf.cuJ.opType != 3) && (paramgf.cuJ.opType != 4))
      {
        AppMethodBeat.o(74610);
        return false;
        localg1 = (com.tencent.mm.plugin.fav.a.g)this.mCR.get(Long.valueOf(paramgf.cuJ.cpM));
        if (localg1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          ab.d("MicroMsg.FavImageServiceListener", "get item from cache itemInfo is null? %B", new Object[] { Boolean.valueOf(bool) });
          if (localg1 != null) {
            break label558;
          }
          localg2 = ((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().kb(paramgf.cuJ.cpM);
          localg1 = localg2;
          if (localg2 == null) {
            break;
          }
          this.mCR.put(Long.valueOf(paramgf.cuJ.cpM), localg2);
          localg1 = localg2;
          break;
        }
      }
      switch (paramgf.cuJ.opType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(74610);
        return false;
        paramgf.cuK.cuR = l.a(paramgf.cuJ.cuL, localg1);
        continue;
        ab.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[] { Boolean.valueOf(paramgf.cuJ.cuO) });
        if (paramgf.cuJ.cuO)
        {
          paramgf.cuK.cuR = l.j(paramgf.cuJ.cuL);
        }
        else
        {
          paramgf.cuK.cuR = l.b(paramgf.cuJ.cuL, localg1, paramgf.cuJ.maxWidth);
          continue;
          if (this.mvC == null)
          {
            ab.w("MicroMsg.FavImageServiceListener", "imageServer is null");
          }
          else
          {
            this.mvC.b(paramgf.cuJ.cuM, paramgf.cuJ.cuL, localg1, paramgf.cuJ.cuN, paramgf.cuJ.width, paramgf.cuJ.height);
            continue;
            ab.d("MicroMsg.FavImageServiceListener", "create image server");
            if (this.mvC != null) {
              this.mvC.destory();
            }
            this.mvC = new l(paramgf.cuJ.context, 16);
            continue;
            ab.d("MicroMsg.FavImageServiceListener", "destroy image server");
            if (this.mvC != null)
            {
              this.mvC.destory();
              this.mvC = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.a
 * JD-Core Version:    0.7.0.1
 */