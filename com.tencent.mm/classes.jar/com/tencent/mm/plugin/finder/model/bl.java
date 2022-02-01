package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.bds;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderTopicInfoFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class bl
  implements bo
{
  public final bds dMU;
  public boolean uOQ;
  
  public bl(bds parambds)
  {
    AppMethodBeat.i(248852);
    this.dMU = parambds;
    AppMethodBeat.o(248852);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248851);
    p.h(parami, "obj");
    if (((parami instanceof bl)) && (((bl)parami).dMU.twp == this.dMU.twp))
    {
      AppMethodBeat.o(248851);
      return 0;
    }
    AppMethodBeat.o(248851);
    return -1;
  }
  
  public final int cxn()
  {
    return 1;
  }
  
  public final long lT()
  {
    return this.dMU.twp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bl
 * JD-Core Version:    0.7.0.1
 */