package com.tencent.mm.plugin.gallery.model;

import androidx.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/model/LinearPreload;", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "()V", "preloadOnlyOnIdle", "", "retrievePreloadItems", "", "", "state", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "lastState", "first", "last", "limit", "Companion", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements m
{
  public static final o.a HHS;
  
  static
  {
    AppMethodBeat.i(111789);
    HHS = new o.a((byte)0);
    AppMethodBeat.o(111789);
  }
  
  public final Set<Integer> a(r.c paramc1, r.c paramc2, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(111788);
    s.u(paramc1, "state");
    s.u(paramc2, "lastState");
    b localb = new b();
    if ((paramInt1 != -1) && (paramInt2 != -1) && (paramInt1 < paramInt2) && (r.c.HIl == paramc1))
    {
      Log.d("MicroMsg.LinearPreload", "start LinearPreload!!!");
      switch (b.$EnumSwitchMapping$0[paramc2.ordinal()])
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
  
  public final boolean fAO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.o
 * JD-Core Version:    0.7.0.1
 */