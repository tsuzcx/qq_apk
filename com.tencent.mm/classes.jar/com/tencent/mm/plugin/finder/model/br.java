package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.epd;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderPoiRelateData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "info", "Lcom/tencent/mm/protocal/protobuf/RelativePoiInfo;", "(Lcom/tencent/mm/protocal/protobuf/RelativePoiInfo;)V", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/RelativePoiInfo;", "isCheck", "", "()Z", "setCheck", "(Z)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class br
  implements cc
{
  public final epd EDy;
  public boolean tGP;
  
  public br(epd paramepd)
  {
    AppMethodBeat.i(331887);
    this.EDy = paramepd;
    AppMethodBeat.o(331887);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(331909);
    s.u(paramk, "obj");
    AppMethodBeat.o(331909);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(331894);
    long l = hashCode();
    AppMethodBeat.o(331894);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(331902);
    int i = br.class.getName().hashCode();
    AppMethodBeat.o(331902);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.br
 * JD-Core Version:    0.7.0.1
 */