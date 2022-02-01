package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.azm;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/PageLbsSection;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "sourceFlag", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(IJILcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "extract", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class t
  extends s
{
  public t(long paramLong, azm paramazm)
  {
    AppMethodBeat.i(252043);
    aqq localaqq = this.vGD;
    localaqq.id = paramLong;
    localaqq.type = 0;
    localaqq.LCD = new FinderObject();
    localaqq.LCE = 1;
    localaqq.LCF = paramazm;
    paramazm = n.vGA;
    localaqq.dataType = 1;
    AppMethodBeat.o(252043);
  }
  
  public t(aqq paramaqq)
  {
    super(paramaqq);
    AppMethodBeat.i(252042);
    AppMethodBeat.o(252042);
  }
  
  public final bo dyH()
  {
    AppMethodBeat.i(252041);
    Object localObject = n.vGA;
    localObject = (bo)n.b(this.vGD);
    AppMethodBeat.o(252041);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.t
 * JD-Core Version:    0.7.0.1
 */