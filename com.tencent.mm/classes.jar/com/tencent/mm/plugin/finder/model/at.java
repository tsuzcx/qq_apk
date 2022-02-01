package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bjc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
  implements cc
{
  public final bjc Bhm;
  
  public at(bjc parambjc)
  {
    AppMethodBeat.i(332058);
    this.Bhm = parambjc;
    AppMethodBeat.o(332058);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332080);
    s.u(paramk, "obj");
    if ((paramk instanceof at)) {
      paramk = (at)paramk;
    }
    while (paramk != null) {
      if (s.p(paramk.Bhm.id, this.Bhm.id))
      {
        AppMethodBeat.o(332080);
        return 0;
        paramk = null;
      }
      else if (this.Bhm.endTime > paramk.Bhm.endTime)
      {
        AppMethodBeat.o(332080);
        return 1;
      }
    }
    AppMethodBeat.o(332080);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332064);
    long l = hashCode();
    AppMethodBeat.o(332064);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332070);
    int i = at.class.hashCode();
    AppMethodBeat.o(332070);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.at
 * JD-Core Version:    0.7.0.1
 */