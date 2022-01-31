package com.tencent.mm.plugin.fav.ui.c;

import com.tencent.mm.h.a.gc;
import com.tencent.mm.h.a.gc.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends c<gc>
{
  private l kbg;
  private ab<Long, com.tencent.mm.plugin.fav.a.g> kin = new ab(10);
  
  public a()
  {
    this.udX = gc.class.getName().hashCode();
  }
  
  private boolean a(gc paramgc)
  {
    com.tencent.mm.plugin.fav.a.g localg2;
    com.tencent.mm.plugin.fav.a.g localg1;
    if (paramgc.bNr.bIr != 0L) {
      if (paramgc.bNr.bNy)
      {
        localg2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgc.bNr.bIr);
        localg1 = localg2;
        if (localg2 != null)
        {
          this.kin.put(Long.valueOf(paramgc.bNr.bIr), localg2);
          localg1 = localg2;
        }
      }
    }
    for (;;)
    {
      y.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", new Object[] { Integer.valueOf(paramgc.bNr.opType), Long.valueOf(paramgc.bNr.bIr) });
      if ((localg1 == null) && (paramgc.bNr.opType != 3) && (paramgc.bNr.opType != 4)) {}
      do
      {
        return false;
        localg1 = (com.tencent.mm.plugin.fav.a.g)this.kin.get(Long.valueOf(paramgc.bNr.bIr));
        if (localg1 == null) {}
        for (boolean bool = true;; bool = false)
        {
          y.d("MicroMsg.FavImageServiceListener", "get item from cache itemInfo is null? %B", new Object[] { Boolean.valueOf(bool) });
          if (localg1 != null) {
            break label534;
          }
          localg2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramgc.bNr.bIr);
          localg1 = localg2;
          if (localg2 == null) {
            break;
          }
          this.kin.put(Long.valueOf(paramgc.bNr.bIr), localg2);
          localg1 = localg2;
          break;
        }
        switch (paramgc.bNr.opType)
        {
        default: 
          return false;
        case 0: 
          paramgc.bNs.bNz = l.a(paramgc.bNr.bNt, localg1);
          return false;
        case 2: 
          y.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", new Object[] { Boolean.valueOf(paramgc.bNr.bNw) });
          if (paramgc.bNr.bNw)
          {
            paramgc.bNs.bNz = l.j(paramgc.bNr.bNt);
            return false;
          }
          paramgc.bNs.bNz = l.b(paramgc.bNr.bNt, localg1, paramgc.bNr.maxWidth);
          return false;
        case 1: 
          if (this.kbg == null)
          {
            y.w("MicroMsg.FavImageServiceListener", "imageServer is null");
            return false;
          }
          this.kbg.b(paramgc.bNr.bNu, paramgc.bNr.bNt, localg1, paramgc.bNr.bNv, paramgc.bNr.width, paramgc.bNr.height);
          return false;
        case 3: 
          y.d("MicroMsg.FavImageServiceListener", "create image server");
          if (this.kbg != null) {
            this.kbg.destory();
          }
          this.kbg = new l(paramgc.bNr.context, 16);
          return false;
        }
        y.d("MicroMsg.FavImageServiceListener", "destroy image server");
      } while (this.kbg == null);
      this.kbg.destory();
      this.kbg = null;
      return false;
      label534:
      continue;
      localg1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.a
 * JD-Core Version:    0.7.0.1
 */