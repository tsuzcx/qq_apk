package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.view.recyclerview.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "likeObj", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "getLikeObj", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeObj", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class z
  implements i, a
{
  public dzd KTs;
  
  public z(dzd paramdzd)
  {
    AppMethodBeat.i(198633);
    this.KTs = paramdzd;
    AppMethodBeat.o(198633);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(198632);
    k.h(parami, "obj");
    AppMethodBeat.o(198632);
    return 0;
  }
  
  public final long bMs()
  {
    AppMethodBeat.i(198631);
    long l = Long.valueOf(this.KTs.qou).hashCode();
    AppMethodBeat.o(198631);
    return l;
  }
  
  public final int bMt()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.z
 * JD-Core Version:    0.7.0.1
 */