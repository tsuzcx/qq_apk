package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bjr;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderPlacedDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class bl
  implements bu
{
  public final bjr xzB;
  
  public bl(bjr parambjr)
  {
    AppMethodBeat.i(244393);
    this.xzB = parambjr;
    AppMethodBeat.o(244393);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(244392);
    p.k(paramk, "obj");
    AppMethodBeat.o(244392);
    return -1;
  }
  
  public final int bAQ()
  {
    return this.xzB.STx;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(244391);
    long l = this.xzB.hashCode();
    AppMethodBeat.o(244391);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bl
 * JD-Core Version:    0.7.0.1
 */