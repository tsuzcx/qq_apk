package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.blm;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderShopFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "productInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;)V", "getProductInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class bp
  implements bu
{
  public final blm zBn;
  
  public bp(blm paramblm)
  {
    AppMethodBeat.i(284781);
    this.zBn = paramblm;
    AppMethodBeat.o(284781);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(284780);
    p.k(paramk, "obj");
    if (!(paramk instanceof bp)) {
      paramk = null;
    }
    for (;;)
    {
      paramk = (bp)paramk;
      if ((paramk != null) && (paramk.zBn.zaO == this.zBn.zaO))
      {
        AppMethodBeat.o(284780);
        return 0;
      }
      AppMethodBeat.o(284780);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(284779);
    int i = bp.class.hashCode();
    AppMethodBeat.o(284779);
    return i;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(284778);
    long l = hashCode();
    AppMethodBeat.o(284778);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bp
 * JD-Core Version:    0.7.0.1
 */