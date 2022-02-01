package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.view.recyclerview.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "likeObj", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "hasBlink", "getHasBlink", "setHasBlink", "getLikeObj", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeObj", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class p
  implements i, a
{
  public boolean sta;
  public boolean stb;
  public apg sti;
  
  public p(apg paramapg)
  {
    AppMethodBeat.i(203437);
    this.sti = paramapg;
    AppMethodBeat.o(203437);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(203436);
    d.g.b.p.h(parami, "obj");
    AppMethodBeat.o(203436);
    return 0;
  }
  
  public final int bZz()
  {
    return 0;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(203435);
    long l = Long.valueOf(this.sti.rPT).hashCode();
    AppMethodBeat.o(203435);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.p
 * JD-Core Version:    0.7.0.1
 */