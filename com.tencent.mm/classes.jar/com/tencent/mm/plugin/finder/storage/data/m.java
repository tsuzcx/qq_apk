package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.af;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.protocal.protobuf.axb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/LbsSectionOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "targetDataType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m FNo;
  
  static
  {
    AppMethodBeat.i(339347);
    FNo = new m();
    AppMethodBeat.o(339347);
  }
  
  public static c b(axb paramaxb)
  {
    int i = 1;
    AppMethodBeat.i(339344);
    s.u(paramaxb, "data");
    if (paramaxb.dataType == 1) {}
    while (i != 0)
    {
      paramaxb = paramaxb.ZIq;
      if (paramaxb == null)
      {
        AppMethodBeat.o(339344);
        return null;
        i = 0;
      }
      else
      {
        af localaf = af.AWY;
        paramaxb = af.a(paramaxb);
        AppMethodBeat.o(339344);
        return paramaxb;
      }
    }
    AppMethodBeat.o(339344);
    return null;
  }
  
  public static int fac()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.m
 * JD-Core Version:    0.7.0.1
 */