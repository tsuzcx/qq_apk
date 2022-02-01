package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.awi;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class an
  implements bo
{
  public final awi tWe;
  
  public an(awi paramawi)
  {
    AppMethodBeat.i(248783);
    this.tWe = paramawi;
    AppMethodBeat.o(248783);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248782);
    p.h(parami, "obj");
    if (!(parami instanceof an)) {
      parami = null;
    }
    for (;;)
    {
      parami = (an)parami;
      if (parami != null)
      {
        if (p.j(parami.tWe.id, this.tWe.id))
        {
          AppMethodBeat.o(248782);
          return 0;
        }
        if (this.tWe.iqg > parami.tWe.iqg)
        {
          AppMethodBeat.o(248782);
          return 1;
        }
      }
      AppMethodBeat.o(248782);
      return -1;
    }
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248781);
    int i = an.class.hashCode();
    AppMethodBeat.o(248781);
    return i;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248780);
    long l = hashCode();
    AppMethodBeat.o(248780);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.an
 * JD-Core Version:    0.7.0.1
 */