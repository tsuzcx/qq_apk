package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.view.recyclerview.h.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "startTime", "", "count", "", "(JI)V", "getCount", "()I", "getStartTime", "()J", "compare", "obj", "getItemId", "getItemType", "plugin-finder_release"})
public final class aq
  extends h.b
  implements k
{
  public final int count;
  public final long startTime;
  
  public aq(long paramLong, int paramInt)
  {
    this.startTime = paramLong;
    this.count = paramInt;
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(221629);
    p.k(paramk, "obj");
    AppMethodBeat.o(221629);
    return 0;
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(221628);
    int i = aq.class.hashCode();
    AppMethodBeat.o(221628);
    return i;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(221626);
    long l = hashCode();
    AppMethodBeat.o(221626);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.aq
 * JD-Core Version:    0.7.0.1
 */