package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bxv;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderTopicInfoFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "type", "", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;I)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "getTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getType", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class by
  implements cc
{
  public boolean Bvd;
  public final bxv hLt;
  private final int type;
  
  public by(bxv parambxv, int paramInt)
  {
    AppMethodBeat.i(331910);
    this.hLt = parambxv;
    this.type = paramInt;
    AppMethodBeat.o(331910);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(331930);
    s.u(paramk, "obj");
    if (((paramk instanceof by)) && (((by)paramk).hLt.ADo == this.hLt.ADo))
    {
      AppMethodBeat.o(331930);
      return 0;
    }
    AppMethodBeat.o(331930);
    return -1;
  }
  
  public final long bZA()
  {
    return this.hLt.ADo;
  }
  
  public final int bZB()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.by
 * JD-Core Version:    0.7.0.1
 */