package com.tencent.mm.plugin.finder.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLike;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "likeObj", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;)V", "blink", "", "getBlink", "()Z", "setBlink", "(Z)V", "hasBlink", "getHasBlink", "setHasBlink", "getLikeObj", "()Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "setLikeObj", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  implements k, a
{
  public boolean ECA;
  public bco ECH;
  public boolean ECz;
  
  public w(bco parambco)
  {
    AppMethodBeat.i(332234);
    this.ECH = parambco;
    AppMethodBeat.o(332234);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332250);
    s.u(paramk, "obj");
    AppMethodBeat.o(332250);
    return 0;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332240);
    long l = q.a..ExternalSyntheticBackport0.m(this.ECH.AyP);
    AppMethodBeat.o(332240);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.w
 * JD-Core Version:    0.7.0.1
 */