package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqq;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/PageMegaVideoItem;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "sourceFlag", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(IJILcom/tencent/mm/protocal/protobuf/FinderObject;)V", "extract", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "targetDataType", "toRVFeed", "plugin-finder_release"})
public final class u
  extends s
{
  public u(long paramLong, int paramInt, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(252046);
    aqq localaqq = this.vGD;
    localaqq.id = paramLong;
    localaqq.type = 0;
    localaqq.LCD = paramFinderObject;
    localaqq.LCE = paramInt;
    paramFinderObject = p.vGB;
    localaqq.dataType = 2;
    localaqq.LCG = null;
    AppMethodBeat.o(252046);
  }
  
  public u(aqq paramaqq)
  {
    super(paramaqq);
    AppMethodBeat.i(252045);
    AppMethodBeat.o(252045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.u
 * JD-Core Version:    0.7.0.1
 */