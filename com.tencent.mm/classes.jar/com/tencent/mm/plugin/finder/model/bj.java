package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bjr;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderNearbyLiveFollowPlacedDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class bj
  implements bu
{
  public int index;
  public final bjr xzB;
  
  public bj(bjr parambjr)
  {
    AppMethodBeat.i(288704);
    this.xzB = parambjr;
    this.index = -1;
    AppMethodBeat.o(288704);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(288703);
    p.k(paramk, "obj");
    AppMethodBeat.o(288703);
    return -1;
  }
  
  public final int bAQ()
  {
    return this.xzB.STx;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(288702);
    long l = this.xzB.hashCode();
    AppMethodBeat.o(288702);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bj
 * JD-Core Version:    0.7.0.1
 */