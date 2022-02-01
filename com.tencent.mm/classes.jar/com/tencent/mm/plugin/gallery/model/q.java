package com.tencent.mm.plugin.gallery.model;

import android.support.v4.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.j.c;
import d.j.c.b;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/model/RandomPreload;", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "()V", "preloadOnlyOnIdle", "", "retrievePreloadItems", "", "", "state", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "lastState", "first", "last", "limit", "Companion", "plugin-gallery_release"})
public final class q
  implements j
{
  public static final a rBV;
  
  static
  {
    AppMethodBeat.i(111801);
    rBV = new a((byte)0);
    AppMethodBeat.o(111801);
  }
  
  public final Set<Integer> a(p.c paramc1, p.c paramc2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111800);
    k.h(paramc1, "state");
    k.h(paramc2, "lastState");
    paramc2 = new b();
    if ((paramInt1 != -1) && (paramInt2 != -1) && (paramInt1 < paramInt2)) {
      ad.d("MicroMsg.RandomPreload", "start RandomPreload!!!");
    }
    switch (r.ciE[paramc1.ordinal()])
    {
    default: 
      paramc1 = (Set)paramc2;
      AppMethodBeat.o(111800);
      return paramc1;
    case 1: 
      if (paramInt1 < 160) {
        break;
      }
    }
    for (paramInt2 = paramInt1 - 160;; paramInt2 = 0)
    {
      int i = paramInt1 - paramInt2;
      ad.d("MicroMsg.RandomPreload", "from %s until %s range %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(i) });
      if (i <= 0) {
        break;
      }
      if (i > 50)
      {
        paramc1 = new ArrayList(50);
        paramInt3 = 0;
        while (paramInt3 < 50)
        {
          paramc1.add(Integer.valueOf(c.JhE.nextInt(paramInt2, paramInt1)));
          paramInt3 += 1;
        }
        paramc2.addAll((Collection)paramc1);
        break;
      }
      paramc1 = new ArrayList(i);
      paramInt3 = 0;
      while (paramInt3 < i)
      {
        paramc1.add(Integer.valueOf(c.JhE.nextInt(paramInt2, paramInt1)));
        paramInt3 += 1;
      }
      paramc2.addAll((Collection)paramc1);
      break;
      paramInt1 = paramInt2 + 160;
      if (paramInt1 > paramInt3) {}
      for (;;)
      {
        i = paramInt3 - paramInt2;
        ad.d("MicroMsg.RandomPreload", "from %s until %s range %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i) });
        if (i <= 0) {
          break;
        }
        if (i > 50)
        {
          paramc1 = new ArrayList(50);
          paramInt1 = 0;
          while (paramInt1 < 50)
          {
            paramc1.add(Integer.valueOf(c.JhE.nextInt(paramInt2, paramInt3)));
            paramInt1 += 1;
          }
          paramc2.addAll((Collection)paramc1);
          break;
        }
        paramc1 = new ArrayList(i);
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          paramc1.add(Integer.valueOf(c.JhE.nextInt(paramInt2, paramInt3)));
          paramInt1 += 1;
        }
        paramc2.addAll((Collection)paramc1);
        break;
        paramInt3 = paramInt1;
      }
    }
  }
  
  public final boolean czK()
  {
    return false;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/model/RandomPreload$Companion;", "", "()V", "COUNT", "", "SCREEN", "SUM", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.q
 * JD-Core Version:    0.7.0.1
 */