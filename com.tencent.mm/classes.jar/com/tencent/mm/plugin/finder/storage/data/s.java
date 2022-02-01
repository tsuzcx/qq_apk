package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.bfl;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/PageLbsSection;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "sourceFlag", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(IJILcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "extract", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class s
  extends r
{
  public s(long paramLong, bfl parambfl)
  {
    AppMethodBeat.i(287557);
    asm localasm = this.AnB;
    localasm.id = paramLong;
    localasm.type = 0;
    localasm.SFP = new FinderObject();
    localasm.SFQ = 1;
    localasm.SFR = parambfl;
    parambfl = m.Any;
    localasm.dataType = 1;
    AppMethodBeat.o(287557);
  }
  
  public s(asm paramasm)
  {
    super(paramasm);
    AppMethodBeat.i(287556);
    AppMethodBeat.o(287556);
  }
  
  public final bu dZA()
  {
    AppMethodBeat.i(287555);
    Object localObject = m.Any;
    localObject = (bu)m.b(this.AnB);
    AppMethodBeat.o(287555);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.s
 * JD-Core Version:    0.7.0.1
 */