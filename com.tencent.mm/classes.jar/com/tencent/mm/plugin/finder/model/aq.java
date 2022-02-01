package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.awh;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryWinnerData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "winnerInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;)V", "getWinnerInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class aq
  implements bo
{
  public final awh uOC;
  
  public aq(awh paramawh)
  {
    AppMethodBeat.i(248794);
    this.uOC = paramawh;
    AppMethodBeat.o(248794);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248793);
    p.h(parami, "obj");
    if (!(parami instanceof awh)) {
      parami = null;
    }
    for (;;)
    {
      parami = (awh)parami;
      if ((parami != null) && (p.j(parami.username, this.uOC.username)) && (p.j(parami.nickname, this.uOC.nickname)))
      {
        AppMethodBeat.o(248793);
        return 0;
      }
      AppMethodBeat.o(248793);
      return -1;
    }
  }
  
  public final int cxn()
  {
    AppMethodBeat.i(248792);
    int i = aq.class.hashCode();
    AppMethodBeat.o(248792);
    return i;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248791);
    long l = hashCode();
    AppMethodBeat.o(248791);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.aq
 * JD-Core Version:    0.7.0.1
 */