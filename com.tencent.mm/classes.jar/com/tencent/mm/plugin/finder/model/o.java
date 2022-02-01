package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.view.recyclerview.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "likeObj", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "hasBlink", "getHasBlink", "setHasBlink", "getLikeObj", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeObj", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class o
  implements i, a
{
  public boolean skd;
  public boolean ske;
  public aot skl;
  
  public o(aot paramaot)
  {
    AppMethodBeat.i(202954);
    this.skl = paramaot;
    AppMethodBeat.o(202954);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(202953);
    p.h(parami, "obj");
    AppMethodBeat.o(202953);
    return 0;
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(202952);
    long l = Long.valueOf(this.skl.rHI).hashCode();
    AppMethodBeat.o(202952);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.o
 * JD-Core Version:    0.7.0.1
 */