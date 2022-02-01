package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.v;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.protocal.protobuf.ana;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/LbsSectionOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "targetDataType", "plugin-finder_release"})
public final class l
{
  public static final l sLg;
  
  static
  {
    AppMethodBeat.i(204427);
    sLg = new l();
    AppMethodBeat.o(204427);
  }
  
  public static c b(ana paramana)
  {
    int i = 1;
    AppMethodBeat.i(204426);
    p.h(paramana, "data");
    if (paramana.dataType == 1) {}
    while (i != 0)
    {
      paramana = paramana.GFj;
      if (paramana != null)
      {
        v localv = v.sff;
        p.g(paramana, "it");
        paramana = v.a(paramana);
        AppMethodBeat.o(204426);
        return paramana;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(204426);
        return null;
      }
    }
    AppMethodBeat.o(204426);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.l
 * JD-Core Version:    0.7.0.1
 */