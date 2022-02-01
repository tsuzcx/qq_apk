package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.bqs;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/PageLbsSection;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "sourceFlag", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(IJILcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "extract", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends s
{
  public t(long paramLong, bqs parambqs)
  {
    AppMethodBeat.i(339308);
    axb localaxb = this.FNr;
    localaxb.id = paramLong;
    localaxb.type = 0;
    localaxb.ZIo = new FinderObject();
    localaxb.ZIp = 1;
    localaxb.ZIq = parambqs;
    parambqs = m.FNo;
    localaxb.dataType = m.fac();
    AppMethodBeat.o(339308);
  }
  
  public t(axb paramaxb)
  {
    super(paramaxb);
    AppMethodBeat.i(339300);
    AppMethodBeat.o(339300);
  }
  
  public final cc eIE()
  {
    AppMethodBeat.i(339317);
    Object localObject = m.FNo;
    localObject = (cc)m.b(this.FNr);
    AppMethodBeat.o(339317);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.t
 * JD-Core Version:    0.7.0.1
 */