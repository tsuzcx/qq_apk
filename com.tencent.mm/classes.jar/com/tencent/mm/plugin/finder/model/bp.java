package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bwc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderPlacedDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bp
  implements cc
{
  public final bwc AWZ;
  
  public bp(bwc parambwc)
  {
    AppMethodBeat.i(331942);
    this.AWZ = parambwc;
    AppMethodBeat.o(331942);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(331963);
    s.u(paramk, "obj");
    AppMethodBeat.o(331963);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(331950);
    long l = this.AWZ.hashCode();
    AppMethodBeat.o(331950);
    return l;
  }
  
  public final int bZB()
  {
    return this.AWZ.aadB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bp
 * JD-Core Version:    0.7.0.1
 */