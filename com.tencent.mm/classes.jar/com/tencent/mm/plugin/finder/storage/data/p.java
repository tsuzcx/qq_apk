package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.apw;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/PageLbsSection;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "sourceFlag", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(IJILcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "extract", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class p
  extends o
{
  public p(long paramLong, apw paramapw)
  {
    AppMethodBeat.i(203846);
    amo localamo = this.sAk;
    localamo.id = paramLong;
    localamo.type = 0;
    localamo.Gmf = new FinderObject();
    localamo.Gmg = 1;
    localamo.Gmh = paramapw;
    paramapw = l.sAi;
    localamo.dataType = 1;
    AppMethodBeat.o(203846);
  }
  
  public p(amo paramamo)
  {
    super(paramamo);
    AppMethodBeat.i(203845);
    AppMethodBeat.o(203845);
  }
  
  public final al cJk()
  {
    AppMethodBeat.i(203844);
    Object localObject = l.sAi;
    localObject = (al)l.b(this.sAk);
    AppMethodBeat.o(203844);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.p
 * JD-Core Version:    0.7.0.1
 */