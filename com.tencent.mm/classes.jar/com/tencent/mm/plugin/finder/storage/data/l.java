package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.v;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.protocal.protobuf.amo;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/LbsSectionOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "targetDataType", "plugin-finder_release"})
public final class l
{
  public static final l sAi;
  
  static
  {
    AppMethodBeat.i(203836);
    sAi = new l();
    AppMethodBeat.o(203836);
  }
  
  public static c b(amo paramamo)
  {
    int i = 1;
    AppMethodBeat.i(203835);
    p.h(paramamo, "data");
    if (paramamo.dataType == 1) {}
    while (i != 0)
    {
      v localv = v.rWu;
      paramamo = paramamo.Gmh;
      p.g(paramamo, "data.lbsSection");
      paramamo = v.a(paramamo);
      AppMethodBeat.o(203835);
      return paramamo;
      i = 0;
    }
    AppMethodBeat.o(203835);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.l
 * JD-Core Version:    0.7.0.1
 */