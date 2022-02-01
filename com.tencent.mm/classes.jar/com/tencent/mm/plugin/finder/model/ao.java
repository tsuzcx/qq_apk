package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.g.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "startTime", "", "count", "", "(JI)V", "getCount", "()I", "getStartTime", "()J", "compare", "obj", "getItemId", "getItemType", "plugin-finder_release"})
public final class ao
  extends g.b
  implements i
{
  public final int count;
  public final long startTime;
  
  public ao(long paramLong, int paramInt)
  {
    this.startTime = paramLong;
    this.count = paramInt;
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248786);
    p.h(parami, "obj");
    AppMethodBeat.o(248786);
    return 0;
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248785);
    int i = ao.class.hashCode();
    AppMethodBeat.o(248785);
    return i;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248784);
    long l = hashCode();
    AppMethodBeat.o(248784);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ao
 * JD-Core Version:    0.7.0.1
 */