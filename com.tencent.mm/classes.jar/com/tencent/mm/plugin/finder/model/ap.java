package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bal;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class ap
  implements bu
{
  public final bal xHW;
  
  public ap(bal parambal)
  {
    AppMethodBeat.i(286128);
    this.xHW = parambal;
    AppMethodBeat.o(286128);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(286127);
    p.k(paramk, "obj");
    if (!(paramk instanceof ap)) {
      paramk = null;
    }
    for (;;)
    {
      paramk = (ap)paramk;
      if (paramk != null)
      {
        if (p.h(paramk.xHW.id, this.xHW.id))
        {
          AppMethodBeat.o(286127);
          return 0;
        }
        if (this.xHW.endTime > paramk.xHW.endTime)
        {
          AppMethodBeat.o(286127);
          return 1;
        }
      }
      AppMethodBeat.o(286127);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(286126);
    int i = ap.class.hashCode();
    AppMethodBeat.o(286126);
    return i;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(286125);
    long l = hashCode();
    AppMethodBeat.o(286125);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ap
 * JD-Core Version:    0.7.0.1
 */