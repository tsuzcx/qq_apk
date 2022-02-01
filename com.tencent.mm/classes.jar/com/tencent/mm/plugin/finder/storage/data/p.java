package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.aqj;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/PageLbsSection;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "sourceFlag", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(IJILcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "extract", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class p
  extends o
{
  public p(long paramLong, aqj paramaqj)
  {
    AppMethodBeat.i(204437);
    ana localana = this.sLi;
    localana.id = paramLong;
    localana.type = 0;
    localana.GFh = new FinderObject();
    localana.GFi = 1;
    localana.GFj = paramaqj;
    paramaqj = l.sLg;
    localana.dataType = 1;
    AppMethodBeat.o(204437);
  }
  
  public p(ana paramana)
  {
    super(paramana);
    AppMethodBeat.i(204436);
    AppMethodBeat.o(204436);
  }
  
  public final am cLN()
  {
    AppMethodBeat.i(204435);
    Object localObject = l.sLg;
    localObject = (am)l.b(this.sLi);
    AppMethodBeat.o(204435);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.p
 * JD-Core Version:    0.7.0.1
 */