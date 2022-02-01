package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bkr;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderTopicInfoFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "type", "", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;I)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getType", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class br
  implements bu
{
  public final bkr fGc;
  private final int type;
  public boolean xUg;
  
  public br(bkr parambkr, int paramInt)
  {
    AppMethodBeat.i(221485);
    this.fGc = parambkr;
    this.type = paramInt;
    AppMethodBeat.o(221485);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(221483);
    p.k(paramk, "obj");
    if (((paramk instanceof br)) && (((br)paramk).fGc.xee == this.fGc.xee))
    {
      AppMethodBeat.o(221483);
      return 0;
    }
    AppMethodBeat.o(221483);
    return -1;
  }
  
  public final int bAQ()
  {
    return this.type;
  }
  
  public final long mf()
  {
    return this.fGc.xee;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.br
 * JD-Core Version:    0.7.0.1
 */