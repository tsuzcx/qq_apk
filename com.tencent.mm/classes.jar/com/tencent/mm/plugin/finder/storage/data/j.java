package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajy;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "", "array", "", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "([Lcom/tencent/mm/plugin/finder/storage/data/CachePage;)V", "[Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "get", "typeFlag", "", "reset", "", "set", "page", "size", "plugin-finder_release"})
public final class j
{
  final a[] rFd;
  
  public j(a[] paramArrayOfa)
  {
    AppMethodBeat.i(203046);
    this.rFd = paramArrayOfa;
    AppMethodBeat.o(203046);
  }
  
  public final a Em(int paramInt)
  {
    AppMethodBeat.i(203043);
    Object localObject2 = this.rFd;
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
        localObject2 = new a(10000, "default_v2", new ajy(), (byte)0);
      }
      AppMethodBeat.o(203043);
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
    AppMethodBeat.i(203044);
    k.h(parama, "page");
    a[] arrayOfa = this.rFd;
    int k = arrayOfa.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (paramInt == arrayOfa[j].type) {
        this.rFd[i] = parama;
      }
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(203044);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(203045);
    a[] arrayOfa = this.rFd;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.kkr = false;
      locala.a(new ajy());
      i += 1;
    }
    AppMethodBeat.o(203045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.j
 * JD-Core Version:    0.7.0.1
 */