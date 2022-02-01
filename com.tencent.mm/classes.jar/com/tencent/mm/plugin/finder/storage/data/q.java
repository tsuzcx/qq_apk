package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arb;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "", "array", "", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "([Lcom/tencent/mm/plugin/finder/storage/data/CachePage;)V", "[Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "get", "typeFlag", "", "reset", "", "set", "page", "size", "plugin-finder_release"})
public final class q
{
  final a[] vGC;
  
  public q(a[] paramArrayOfa)
  {
    AppMethodBeat.i(252037);
    this.vGC = paramArrayOfa;
    AppMethodBeat.o(252037);
  }
  
  public final a Lg(int paramInt)
  {
    AppMethodBeat.i(252034);
    Object localObject2 = this.vGC;
    int k = localObject2.length;
    int i = 0;
    Object localObject1;
    int j;
    if (i < k)
    {
      localObject1 = localObject2[i];
      if (localObject1.type == paramInt)
      {
        j = 1;
        label41:
        if (j == 0) {
          break label89;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new a(10000, "default_v3", new arb(), (byte)0);
      }
      AppMethodBeat.o(252034);
      return localObject2;
      j = 0;
      break label41;
      label89:
      i += 1;
      break;
      localObject1 = null;
    }
  }
  
  public final void a(int paramInt, a parama)
  {
    AppMethodBeat.i(252035);
    p.h(parama, "page");
    a[] arrayOfa = this.vGC;
    int k = arrayOfa.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (paramInt == arrayOfa[j].type) {
        this.vGC[i] = parama;
      }
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(252035);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(252036);
    a[] arrayOfa = this.vGC;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.lNl = false;
      locala.a(new arb());
      i += 1;
    }
    AppMethodBeat.o(252036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.q
 * JD-Core Version:    0.7.0.1
 */