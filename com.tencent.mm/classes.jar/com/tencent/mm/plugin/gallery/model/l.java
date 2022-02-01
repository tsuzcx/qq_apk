package com.tencent.mm.plugin.gallery.model;

import android.support.v4.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import java.util.Set;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/model/LinearPreload;", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "()V", "preloadOnlyOnIdle", "", "retrievePreloadItems", "", "", "state", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "lastState", "first", "last", "limit", "Companion", "plugin-gallery_release"})
public final class l
  implements j
{
  public static final a tHc;
  
  static
  {
    AppMethodBeat.i(111789);
    tHc = new a((byte)0);
    AppMethodBeat.o(111789);
  }
  
  public final Set<Integer> a(p.c paramc1, p.c paramc2, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(111788);
    p.h(paramc1, "state");
    p.h(paramc2, "lastState");
    b localb = new b();
    if ((paramInt1 != -1) && (paramInt2 != -1) && (paramInt1 < paramInt2) && (p.c.tHv == paramc1))
    {
      ad.d("MicroMsg.LinearPreload", "start LinearPreload!!!");
      switch (m.cpQ[paramc2.ordinal()])
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
  
  public final boolean cVo()
  {
    return true;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gallery/model/LinearPreload$Companion;", "", "()V", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.l
 * JD-Core Version:    0.7.0.1
 */