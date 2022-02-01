package com.tencent.mm.plugin.finder.order.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/data/SpuCollapseFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "remainCount", "", "onClick", "Lkotlin/Function0;", "", "(ILkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getRemainCount", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements cc
{
  public final int ESz;
  public final a<ah> meC;
  
  public e(int paramInt, a<ah> parama)
  {
    AppMethodBeat.i(332336);
    this.ESz = paramInt;
    this.meC = parama;
    AppMethodBeat.o(332336);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332357);
    s.u(paramk, "obj");
    AppMethodBeat.o(332357);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332340);
    long l = hashCode();
    AppMethodBeat.o(332340);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332350);
    int i = e.class.hashCode();
    AppMethodBeat.o(332350);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.data.e
 * JD-Core Version:    0.7.0.1
 */