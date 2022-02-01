package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.view.recyclerview.g.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryWinnerListHeader;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "isEmpty", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;Z)V", "()Z", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class ar
  extends g.b
  implements i
{
  public final boolean dLH;
  public final awi tWe;
  
  public ar(awi paramawi, boolean paramBoolean)
  {
    AppMethodBeat.i(248798);
    this.tWe = paramawi;
    this.dLH = paramBoolean;
    AppMethodBeat.o(248798);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248797);
    p.h(parami, "obj");
    AppMethodBeat.o(248797);
    return 0;
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248796);
    int i = ar.class.hashCode();
    AppMethodBeat.o(248796);
    return i;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248795);
    long l = hashCode();
    AppMethodBeat.o(248795);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ar
 * JD-Core Version:    0.7.0.1
 */