package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "likeObj", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "hasBlink", "getHasBlink", "setHasBlink", "getLikeObj", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeObj", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class v
  implements k, a
{
  public boolean zAp;
  public boolean zAq;
  public awr zAz;
  
  public v(awr paramawr)
  {
    AppMethodBeat.i(276297);
    this.zAz = paramawr;
    AppMethodBeat.o(276297);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(276296);
    p.k(paramk, "obj");
    AppMethodBeat.o(276296);
    return 0;
  }
  
  public final int bAQ()
  {
    return 0;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(276294);
    long l = Long.valueOf(this.zAz.xaG).hashCode();
    AppMethodBeat.o(276294);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.v
 * JD-Core Version:    0.7.0.1
 */