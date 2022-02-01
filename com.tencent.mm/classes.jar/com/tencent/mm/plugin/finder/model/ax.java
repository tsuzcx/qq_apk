package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.view.recyclerview.i.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryWinnerListHeader;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "isEmpty", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;Z)V", "()Z", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
  extends i.b
  implements k
{
  public final bjc Bhm;
  public final boolean hJm;
  
  public ax(bjc parambjc, boolean paramBoolean)
  {
    AppMethodBeat.i(331875);
    this.Bhm = parambjc;
    this.hJm = paramBoolean;
    AppMethodBeat.o(331875);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(331890);
    s.u(paramk, "obj");
    AppMethodBeat.o(331890);
    return 0;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(331880);
    long l = hashCode();
    AppMethodBeat.o(331880);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(331883);
    int i = ax.class.hashCode();
    AppMethodBeat.o(331883);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ax
 * JD-Core Version:    0.7.0.1
 */