package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ani;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "", "array", "", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "([Lcom/tencent/mm/plugin/finder/storage/data/CachePage;)V", "[Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "get", "typeFlag", "", "reset", "", "set", "page", "size", "plugin-finder_release"})
public final class m
{
  final a[] sLh;
  
  public m(a[] paramArrayOfa)
  {
    AppMethodBeat.i(204431);
    this.sLh = paramArrayOfa;
    AppMethodBeat.o(204431);
  }
  
  public final a FS(int paramInt)
  {
    AppMethodBeat.i(204428);
    Object localObject2 = this.sLh;
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
        localObject2 = new a(10000, "default_v3", new ani(), (byte)0);
      }
      AppMethodBeat.o(204428);
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
    AppMethodBeat.i(204429);
    p.h(parama, "page");
    a[] arrayOfa = this.sLh;
    int k = arrayOfa.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (paramInt == arrayOfa[j].type) {
        this.sLh[i] = parama;
      }
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(204429);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(204430);
    a[] arrayOfa = this.sLh;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.kIG = false;
      locala.a(new ani());
      i += 1;
    }
    AppMethodBeat.o(204430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.m
 * JD-Core Version:    0.7.0.1
 */