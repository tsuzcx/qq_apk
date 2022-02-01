package com.tencent.mm.plugin.gallery.model;

import androidx.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.j.c;
import kotlin.j.c.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/model/RandomPreload;", "Lcom/tencent/mm/plugin/gallery/model/IPreload;", "()V", "preloadOnlyOnIdle", "", "retrievePreloadItems", "", "", "state", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "lastState", "first", "last", "limit", "Companion", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  implements m
{
  public static final s.a HIq;
  
  static
  {
    AppMethodBeat.i(111801);
    HIq = new s.a((byte)0);
    AppMethodBeat.o(111801);
  }
  
  public final Set<Integer> a(r.c paramc1, r.c paramc2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111800);
    kotlin.g.b.s.u(paramc1, "state");
    kotlin.g.b.s.u(paramc2, "lastState");
    paramc2 = new b();
    if ((paramInt1 != -1) && (paramInt2 != -1) && (paramInt1 < paramInt2)) {
      Log.d("MicroMsg.RandomPreload", "start RandomPreload!!!");
    }
    switch (b.$EnumSwitchMapping$0[paramc1.ordinal()])
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
      Log.d("MicroMsg.RandomPreload", "from %s until %s range %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(i) });
      if (i <= 0) {
        break;
      }
      if (i > 50)
      {
        paramc1 = new ArrayList(50);
        paramInt3 = 0;
        while (paramInt3 < 50)
        {
          paramc1.add(Integer.valueOf(c.aixl.qq(paramInt2, paramInt1)));
          paramInt3 += 1;
        }
        paramc2.addAll((Collection)paramc1);
        break;
      }
      paramc1 = new ArrayList(i);
      paramInt3 = 0;
      while (paramInt3 < i)
      {
        paramc1.add(Integer.valueOf(c.aixl.qq(paramInt2, paramInt1)));
        paramInt3 += 1;
      }
      paramc2.addAll((Collection)paramc1);
      break;
      paramInt1 = paramInt2 + 160;
      if (paramInt1 > paramInt3) {}
      for (;;)
      {
        i = paramInt3 - paramInt2;
        Log.d("MicroMsg.RandomPreload", "from %s until %s range %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i) });
        if (i <= 0) {
          break;
        }
        if (i > 50)
        {
          paramc1 = new ArrayList(50);
          paramInt1 = 0;
          while (paramInt1 < 50)
          {
            paramc1.add(Integer.valueOf(c.aixl.qq(paramInt2, paramInt3)));
            paramInt1 += 1;
          }
          paramc2.addAll((Collection)paramc1);
          break;
        }
        paramc1 = new ArrayList(i);
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          paramc1.add(Integer.valueOf(c.aixl.qq(paramInt2, paramInt3)));
          paramInt1 += 1;
        }
        paramc2.addAll((Collection)paramc1);
        break;
        paramInt3 = paramInt1;
      }
    }
  }
  
  public final boolean fAO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.s
 * JD-Core Version:    0.7.0.1
 */