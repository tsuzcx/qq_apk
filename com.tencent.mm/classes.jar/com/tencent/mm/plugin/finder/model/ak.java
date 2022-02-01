package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderLineDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "layoutId", "", "(J)V", "getLayoutId", "()J", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class ak
  implements bo
{
  private final long uOx;
  
  public ak(long paramLong)
  {
    this.uOx = paramLong;
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248770);
    p.h(parami, "obj");
    if (((parami instanceof ak)) && (((ak)parami).uOx == this.uOx))
    {
      AppMethodBeat.o(248770);
      return 0;
    }
    AppMethodBeat.o(248770);
    return -1;
  }
  
  public final int cxn()
  {
    return 2015;
  }
  
  public final long lT()
  {
    return this.uOx;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248771);
    String str = "ItemId=" + this.uOx + ",ItemType=2015";
    AppMethodBeat.o(248771);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ak
 * JD-Core Version:    0.7.0.1
 */