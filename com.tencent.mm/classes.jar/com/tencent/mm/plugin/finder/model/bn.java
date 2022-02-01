package com.tencent.mm.plugin.finder.model;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderNearbyLiveFollowPlacedDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "isMoreRecomFeed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bn
  implements cc
{
  public final bwc AWZ;
  public int index;
  
  public bn(bwc parambwc)
  {
    AppMethodBeat.i(331938);
    this.AWZ = parambwc;
    this.index = -1;
    AppMethodBeat.o(331938);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(331956);
    s.u(paramk, "obj");
    AppMethodBeat.o(331956);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(331941);
    long l = this.AWZ.hashCode();
    AppMethodBeat.o(331941);
    return l;
  }
  
  public final int bZB()
  {
    return this.AWZ.aadB;
  }
  
  public final boolean eDD()
  {
    AppMethodBeat.i(331962);
    boolean bool = s.p(this.AWZ.wording, MMApplicationContext.getResources().getString(e.h.nearby_live_divider_tips));
    AppMethodBeat.o(331962);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bn
 * JD-Core Version:    0.7.0.1
 */