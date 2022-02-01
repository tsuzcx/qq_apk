package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bam;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryRecordData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryRecord", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;)V", "getLotteryRecord", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class ar
  implements bu
{
  public final bam zAT;
  
  public ar(bam parambam)
  {
    AppMethodBeat.i(268754);
    this.zAT = parambam;
    AppMethodBeat.o(268754);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(268753);
    p.k(paramk, "obj");
    if (!(paramk instanceof ar)) {
      paramk = null;
    }
    for (;;)
    {
      paramk = (ar)paramk;
      if (paramk != null)
      {
        if ((paramk.zAT.liveId == this.zAT.liveId) && (paramk.zAT.xbk == this.zAT.xbk) && (p.h(paramk.zAT.objectNonceId, this.zAT.objectNonceId)))
        {
          AppMethodBeat.o(268753);
          return 0;
        }
        if (this.zAT.SMt > paramk.zAT.SMt)
        {
          AppMethodBeat.o(268753);
          return 1;
        }
      }
      AppMethodBeat.o(268753);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(268752);
    int i = ar.class.hashCode();
    AppMethodBeat.o(268752);
    return i;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(268751);
    long l = hashCode();
    AppMethodBeat.o(268751);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ar
 * JD-Core Version:    0.7.0.1
 */