package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.awj;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryRecordData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryRecord", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;)V", "getLotteryRecord", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class ap
  implements bo
{
  public final awj uOB;
  
  public ap(awj paramawj)
  {
    AppMethodBeat.i(248790);
    this.uOB = paramawj;
    AppMethodBeat.o(248790);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248789);
    p.h(parami, "obj");
    if (!(parami instanceof ap)) {
      parami = null;
    }
    for (;;)
    {
      parami = (ap)parami;
      if (parami != null)
      {
        if ((parami.uOB.liveId == this.uOB.liveId) && (parami.uOB.hFK == this.uOB.hFK) && (p.j(parami.uOB.objectNonceId, this.uOB.objectNonceId)))
        {
          AppMethodBeat.o(248789);
          return 0;
        }
        if (this.uOB.LHd > parami.uOB.LHd)
        {
          AppMethodBeat.o(248789);
          return 1;
        }
      }
      AppMethodBeat.o(248789);
      return -1;
    }
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248788);
    int i = ap.class.hashCode();
    AppMethodBeat.o(248788);
    return i;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248787);
    long l = hashCode();
    AppMethodBeat.o(248787);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ap
 * JD-Core Version:    0.7.0.1
 */