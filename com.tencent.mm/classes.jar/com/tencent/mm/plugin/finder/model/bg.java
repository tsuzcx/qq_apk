package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.bcw;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderPlacedDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class bg
  implements bo
{
  public final bcw tOP;
  
  public bg(bcw parambcw)
  {
    AppMethodBeat.i(248844);
    this.tOP = parambcw;
    AppMethodBeat.o(248844);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248843);
    p.h(parami, "obj");
    AppMethodBeat.o(248843);
    return -1;
  }
  
  public final int cxn()
  {
    return this.tOP.LLE;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248842);
    long l = this.tOP.hashCode();
    AppMethodBeat.o(248842);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bg
 * JD-Core Version:    0.7.0.1
 */