package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.view.recyclerview.i.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "startTime", "", "count", "", "(JI)V", "getCount", "()I", "getStartTime", "()J", "compare", "obj", "getItemId", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  extends i.b
  implements k
{
  public final int count;
  public final long startTime;
  
  public au(long paramLong, int paramInt)
  {
    this.startTime = paramLong;
    this.count = paramInt;
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332106);
    s.u(paramk, "obj");
    AppMethodBeat.o(332106);
    return 0;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332089);
    long l = hashCode();
    AppMethodBeat.o(332089);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332097);
    int i = au.class.hashCode();
    AppMethodBeat.o(332097);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.au
 * JD-Core Version:    0.7.0.1
 */