package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.view.recyclerview.h.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryWinnerListHeader;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "isEmpty", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;Z)V", "()Z", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class at
  extends h.b
  implements k
{
  public final boolean fEw;
  public final bal xHW;
  
  public at(bal parambal, boolean paramBoolean)
  {
    AppMethodBeat.i(274310);
    this.xHW = parambal;
    this.fEw = paramBoolean;
    AppMethodBeat.o(274310);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(274309);
    p.k(paramk, "obj");
    AppMethodBeat.o(274309);
    return 0;
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(274308);
    int i = at.class.hashCode();
    AppMethodBeat.o(274308);
    return i;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(274307);
    long l = hashCode();
    AppMethodBeat.o(274307);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.at
 * JD-Core Version:    0.7.0.1
 */