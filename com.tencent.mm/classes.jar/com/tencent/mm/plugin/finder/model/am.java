package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderLineDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "layoutId", "", "(J)V", "getLayoutId", "()J", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class am
  implements bu
{
  private final long zAO;
  
  public am(long paramLong)
  {
    this.zAO = paramLong;
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(267238);
    p.k(paramk, "obj");
    if (((paramk instanceof am)) && (((am)paramk).zAO == this.zAO))
    {
      AppMethodBeat.o(267238);
      return 0;
    }
    AppMethodBeat.o(267238);
    return -1;
  }
  
  public final int bAQ()
  {
    return 2015;
  }
  
  public final long mf()
  {
    return this.zAO;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(267239);
    String str = "ItemId=" + this.zAO + ",ItemType=2015";
    AppMethodBeat.o(267239);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.am
 * JD-Core Version:    0.7.0.1
 */