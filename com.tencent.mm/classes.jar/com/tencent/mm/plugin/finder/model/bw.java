package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bzc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderShopFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "productInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;)V", "getProductInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bw
  implements cc
{
  public final bzc DOS;
  
  public bw(bzc parambzc)
  {
    AppMethodBeat.i(331913);
    this.DOS = parambzc;
    AppMethodBeat.o(331913);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(331958);
    s.u(paramk, "obj");
    if ((paramk instanceof bw)) {}
    for (paramk = (bw)paramk; (paramk != null) && (paramk.DOS.DVk == this.DOS.DVk); paramk = null)
    {
      AppMethodBeat.o(331958);
      return 0;
    }
    AppMethodBeat.o(331958);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(331924);
    long l = hashCode();
    AppMethodBeat.o(331924);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(331936);
    int i = bw.class.hashCode();
    AppMethodBeat.o(331936);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bw
 * JD-Core Version:    0.7.0.1
 */