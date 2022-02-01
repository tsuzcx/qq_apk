package com.tencent.mm.plugin.gallery.model;

import android.support.v4.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import java.util.Set;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/model/LinearPreload;", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "()V", "preloadOnlyOnIdle", "", "retrievePreloadItems", "", "", "state", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "lastState", "first", "last", "limit", "Companion", "plugin-gallery_release"})
public final class l
  implements j
{
  public static final a rBy;
  
  static
  {
    AppMethodBeat.i(111789);
    rBy = new a((byte)0);
    AppMethodBeat.o(111789);
  }
  
  public final Set<Integer> a(p.c paramc1, p.c paramc2, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(111788);
    k.h(paramc1, "state");
    k.h(paramc2, "lastState");
    b localb = new b();
    if ((paramInt1 != -1) && (paramInt2 != -1) && (paramInt1 < paramInt2) && (p.c.rBR == paramc1))
    {
      ad.d("MicroMsg.LinearPreload", "start LinearPreload!!!");
      switch (m.ciE[paramc2.ordinal()])
      {
      }
    }
    for (;;)
    {
      paramc1 = (Set)localb;
      AppMethodBeat.o(111788);
      return paramc1;
      paramInt2 = paramInt1 - 1 + 0;
      paramInt3 = i;
      while ((paramInt3 > -32) && (paramInt2 >= 0))
      {
        localb.add(Integer.valueOf(paramInt2));
        paramInt3 -= 1;
        paramInt2 = paramInt1 - 1 + paramInt3;
      }
      paramInt1 = paramInt2 + 1 + 0;
      i = j;
      while ((i < 32) && (paramInt1 < paramInt3))
      {
        localb.add(Integer.valueOf(paramInt1));
        i += 1;
        paramInt1 = paramInt2 + 1 + i;
      }
    }
  }
  
  public final boolean czK()
  {
    return true;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/model/LinearPreload$Companion;", "", "()V", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.l
 * JD-Core Version:    0.7.0.1
 */