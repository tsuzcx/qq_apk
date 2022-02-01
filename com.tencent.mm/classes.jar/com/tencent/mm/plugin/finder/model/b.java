package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.protocal.protobuf.ays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "localItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;)V", "getLocalItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "toString", "", "plugin-finder_release"})
public final class b
  implements bo
{
  private final aa uNH;
  
  public b(aa paramaa)
  {
    AppMethodBeat.i(248692);
    this.uNH = paramaa;
    AppMethodBeat.o(248692);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248690);
    p.h(parami, "obj");
    if (((parami instanceof b)) && (((b)parami).uNH.a(this.uNH)))
    {
      AppMethodBeat.o(248690);
      return 0;
    }
    AppMethodBeat.o(248690);
    return -1;
  }
  
  public final int cxn()
  {
    return this.uNH.vEN.LIS;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248689);
    long l = this.uNH.getId();
    AppMethodBeat.o(248689);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248691);
    String str = "ItemId=" + this.uNH.getId() + ",ItemType=" + cxn() + ' ';
    AppMethodBeat.o(248691);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.b
 * JD-Core Version:    0.7.0.1
 */