package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.protocal.protobuf.asm;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/LbsSectionOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "targetDataType", "plugin-finder_release"})
public final class m
{
  public static final m Any;
  
  static
  {
    AppMethodBeat.i(289772);
    Any = new m();
    AppMethodBeat.o(289772);
  }
  
  public static c b(asm paramasm)
  {
    int i = 1;
    AppMethodBeat.i(289771);
    p.k(paramasm, "data");
    if (paramasm.dataType == 1) {}
    while (i != 0)
    {
      paramasm = paramasm.SFR;
      if (paramasm != null)
      {
        ab localab = ab.xzy;
        p.j(paramasm, "it");
        paramasm = ab.a(paramasm);
        AppMethodBeat.o(289771);
        return paramasm;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(289771);
        return null;
      }
    }
    AppMethodBeat.o(289771);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.m
 * JD-Core Version:    0.7.0.1
 */