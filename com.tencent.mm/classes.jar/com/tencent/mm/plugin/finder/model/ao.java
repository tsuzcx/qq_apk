package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderLineDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "layoutId", "", "(J)V", "getLayoutId", "()J", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  implements cc
{
  private final long ECY;
  
  public ao(long paramLong)
  {
    this.ECY = paramLong;
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332063);
    s.u(paramk, "obj");
    if (((paramk instanceof ao)) && (((ao)paramk).ECY == this.ECY))
    {
      AppMethodBeat.o(332063);
      return 0;
    }
    AppMethodBeat.o(332063);
    return -1;
  }
  
  public final long bZA()
  {
    return this.ECY;
  }
  
  public final int bZB()
  {
    return 2015;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(332069);
    String str = "ItemId=" + this.ECY + ",ItemType=2015";
    AppMethodBeat.o(332069);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ao
 * JD-Core Version:    0.7.0.1
 */