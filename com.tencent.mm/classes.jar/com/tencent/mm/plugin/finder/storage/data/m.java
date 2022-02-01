package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amw;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "", "array", "", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "([Lcom/tencent/mm/plugin/finder/storage/data/CachePage;)V", "[Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "get", "typeFlag", "", "reset", "", "set", "page", "size", "plugin-finder_release"})
public final class m
{
  final a[] sAj;
  
  public m(a[] paramArrayOfa)
  {
    AppMethodBeat.i(203840);
    this.sAj = paramArrayOfa;
    AppMethodBeat.o(203840);
  }
  
  public final a Fv(int paramInt)
  {
    AppMethodBeat.i(203837);
    Object localObject2 = this.sAj;
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
        localObject2 = new a(10000, "default_v3", new amw(), (byte)0);
      }
      AppMethodBeat.o(203837);
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
    AppMethodBeat.i(203838);
    p.h(parama, "page");
    a[] arrayOfa = this.sAj;
    int k = arrayOfa.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (paramInt == arrayOfa[j].type) {
        this.sAj[i] = parama;
      }
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(203838);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(203839);
    a[] arrayOfa = this.sAj;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      locala.kFr = false;
      locala.a(new amw());
      i += 1;
    }
    AppMethodBeat.o(203839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.m
 * JD-Core Version:    0.7.0.1
 */