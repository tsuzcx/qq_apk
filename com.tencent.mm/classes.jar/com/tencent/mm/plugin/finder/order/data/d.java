package com.tencent.mm.plugin.finder.order.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/data/OrderTabFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tabId", "", "tabTitle", "", "count", "(ILjava/lang/String;I)V", "getCount", "()I", "setCount", "(I)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "getTabId", "getTabTitle", "()Ljava/lang/String;", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements cc
{
  public final String Bvb;
  public boolean Bvd;
  public int count;
  public final int idY;
  
  public d(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(332319);
    this.idY = paramInt1;
    this.Bvb = paramString;
    this.count = paramInt2;
    AppMethodBeat.o(332319);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332343);
    s.u(paramk, "obj");
    if (((paramk instanceof d)) && (((d)paramk).idY == this.idY))
    {
      AppMethodBeat.o(332343);
      return 0;
    }
    AppMethodBeat.o(332343);
    return -1;
  }
  
  public final long bZA()
  {
    return this.idY;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332337);
    int i = d.class.hashCode();
    AppMethodBeat.o(332337);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.data.d
 * JD-Core Version:    0.7.0.1
 */