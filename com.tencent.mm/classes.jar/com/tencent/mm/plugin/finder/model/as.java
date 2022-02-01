package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryWinnerData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "winnerInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;)V", "getWinnerInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class as
  implements bu
{
  public final bak zAU;
  
  public as(bak parambak)
  {
    AppMethodBeat.i(261300);
    this.zAU = parambak;
    AppMethodBeat.o(261300);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(261298);
    p.k(paramk, "obj");
    if (!(paramk instanceof bak)) {
      paramk = null;
    }
    for (;;)
    {
      paramk = (bak)paramk;
      if ((paramk != null) && (p.h(paramk.username, this.zAU.username)) && (p.h(paramk.nickname, this.zAU.nickname)))
      {
        AppMethodBeat.o(261298);
        return 0;
      }
      AppMethodBeat.o(261298);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(261296);
    int i = as.class.hashCode();
    AppMethodBeat.o(261296);
    return i;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(261292);
    long l = hashCode();
    AppMethodBeat.o(261292);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.as
 * JD-Core Version:    0.7.0.1
 */