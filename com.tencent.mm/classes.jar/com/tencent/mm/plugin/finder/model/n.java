package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.view.recyclerview.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "likeObj", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "getLikeObj", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeObj", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class n
  implements h, a
{
  public alo ruS;
  
  public n(alo paramalo)
  {
    AppMethodBeat.i(202560);
    this.ruS = paramalo;
    AppMethodBeat.o(202560);
  }
  
  public final int a(h paramh)
  {
    AppMethodBeat.i(202559);
    k.h(paramh, "obj");
    AppMethodBeat.o(202559);
    return 0;
  }
  
  public final int bTF()
  {
    return 0;
  }
  
  public final long lx()
  {
    AppMethodBeat.i(202558);
    long l = Long.valueOf(this.ruS.qWK).hashCode();
    AppMethodBeat.o(202558);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.n
 * JD-Core Version:    0.7.0.1
 */