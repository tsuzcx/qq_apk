package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bje;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryRecordData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryRecord", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;)V", "getLotteryRecord", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  implements cc
{
  public final bje EDi;
  
  public av(bje parambje)
  {
    AppMethodBeat.i(332077);
    this.EDi = parambje;
    AppMethodBeat.o(332077);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332105);
    s.u(paramk, "obj");
    if ((paramk instanceof av)) {
      paramk = (av)paramk;
    }
    while (paramk != null) {
      if ((paramk.EDi.liveId == this.EDi.liveId) && (paramk.EDi.hKN == this.EDi.hKN) && (s.p(paramk.EDi.objectNonceId, this.EDi.objectNonceId)))
      {
        AppMethodBeat.o(332105);
        return 0;
        paramk = null;
      }
      else if (this.EDi.ZSQ > paramk.EDi.ZSQ)
      {
        AppMethodBeat.o(332105);
        return 1;
      }
    }
    AppMethodBeat.o(332105);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332084);
    long l = hashCode();
    AppMethodBeat.o(332084);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332092);
    int i = av.class.hashCode();
    AppMethodBeat.o(332092);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.av
 * JD-Core Version:    0.7.0.1
 */