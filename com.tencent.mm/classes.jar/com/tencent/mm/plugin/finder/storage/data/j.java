package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aim;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "", "array", "", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "([Lcom/tencent/mm/plugin/finder/storage/data/CachePage;)V", "[Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "get", "typeFlag", "", "reset", "", "set", "page", "size", "plugin-finder_release"})
public final class j
{
  final g[] KXy;
  
  public j(g[] paramArrayOfg)
  {
    AppMethodBeat.i(199078);
    this.KXy = paramArrayOfg;
    AppMethodBeat.o(199078);
  }
  
  public final void a(int paramInt, g paramg)
  {
    AppMethodBeat.i(199076);
    k.h(paramg, "page");
    g[] arrayOfg = this.KXy;
    int k = arrayOfg.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (paramInt == arrayOfg[j].type) {
        this.KXy[i] = paramg;
      }
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(199076);
  }
  
  public final g ahA(int paramInt)
  {
    AppMethodBeat.i(199075);
    Object localObject2 = this.KXy;
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
        localObject2 = new g(10000, "default_v2", new aim(), (byte)0);
      }
      AppMethodBeat.o(199075);
      return localObject2;
      j = 0;
      break label41;
      label89:
      i += 1;
      break;
      localObject1 = null;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(199077);
    g[] arrayOfg = this.KXy;
    int j = arrayOfg.length;
    int i = 0;
    while (i < j)
    {
      g localg = arrayOfg[i];
      localg.jJR = false;
      localg.a(new aim());
      i += 1;
    }
    AppMethodBeat.o(199077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.j
 * JD-Core Version:    0.7.0.1
 */