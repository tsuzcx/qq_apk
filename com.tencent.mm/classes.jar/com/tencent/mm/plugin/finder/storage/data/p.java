package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.asx;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "", "array", "", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "([Lcom/tencent/mm/plugin/finder/storage/data/CachePage;)V", "[Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "get", "typeFlag", "", "reset", "", "set", "page", "size", "plugin-finder_release"})
public final class p
{
  final a[] AnA;
  
  public p(a[] paramArrayOfa)
  {
    AppMethodBeat.i(281623);
    this.AnA = paramArrayOfa;
    AppMethodBeat.o(281623);
  }
  
  public final a Qq(int paramInt)
  {
    AppMethodBeat.i(281620);
    Object localObject2 = this.AnA;
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
        localObject2 = new a(10000, "default_v3", new asx(), (byte)0);
      }
      AppMethodBeat.o(281620);
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
    AppMethodBeat.i(281621);
    kotlin.g.b.p.k(parama, "page");
    a[] arrayOfa = this.AnA;
    int k = arrayOfa.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (paramInt == arrayOfa[j].type) {
        this.AnA[i] = parama;
      }
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(281621);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(281622);
    a[] arrayOfa = this.AnA;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.oJz = false;
      locala.a(new asx());
      i += 1;
    }
    AppMethodBeat.o(281622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.p
 * JD-Core Version:    0.7.0.1
 */