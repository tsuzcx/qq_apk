package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.w;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.protocal.protobuf.aqq;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/LbsSectionOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "targetDataType", "plugin-finder_release"})
public final class n
{
  public static final n vGA;
  
  static
  {
    AppMethodBeat.i(252026);
    vGA = new n();
    AppMethodBeat.o(252026);
  }
  
  public static c b(aqq paramaqq)
  {
    int i = 1;
    AppMethodBeat.i(252025);
    p.h(paramaqq, "data");
    if (paramaqq.dataType == 1) {}
    while (i != 0)
    {
      paramaqq = paramaqq.LCF;
      if (paramaqq != null)
      {
        w localw = w.tOM;
        p.g(paramaqq, "it");
        paramaqq = w.a(paramaqq);
        AppMethodBeat.o(252025);
        return paramaqq;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(252025);
        return null;
      }
    }
    AppMethodBeat.o(252025);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.n
 * JD-Core Version:    0.7.0.1
 */