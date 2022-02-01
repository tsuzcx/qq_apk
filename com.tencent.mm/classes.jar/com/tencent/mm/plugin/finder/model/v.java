package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "likeObj", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "hasBlink", "getHasBlink", "setHasBlink", "getLikeObj", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeObj", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class v
  implements i, a
{
  public boolean uOb;
  public boolean uOc;
  public aul uOk;
  
  public v(aul paramaul)
  {
    AppMethodBeat.i(248737);
    this.uOk = paramaul;
    AppMethodBeat.o(248737);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248736);
    p.h(parami, "obj");
    AppMethodBeat.o(248736);
    return 0;
  }
  
  public final int cxn()
  {
    return 0;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248735);
    long l = Long.valueOf(this.uOk.tsR).hashCode();
    AppMethodBeat.o(248735);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.v
 * JD-Core Version:    0.7.0.1
 */