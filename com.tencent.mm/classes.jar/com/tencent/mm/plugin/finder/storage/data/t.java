package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asm;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/PageMegaVideoItem;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "sourceFlag", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(IJILcom/tencent/mm/protocal/protobuf/FinderObject;)V", "extract", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "targetDataType", "toRVFeed", "plugin-finder_release"})
public final class t
  extends r
{
  public t(long paramLong, int paramInt, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(278970);
    asm localasm = this.AnB;
    localasm.id = paramLong;
    localasm.type = 0;
    localasm.SFP = paramFinderObject;
    localasm.SFQ = paramInt;
    paramFinderObject = o.Anz;
    localasm.dataType = 2;
    localasm.SFS = null;
    AppMethodBeat.o(278970);
  }
  
  public t(asm paramasm)
  {
    super(paramasm);
    AppMethodBeat.i(278969);
    AppMethodBeat.o(278969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.t
 * JD-Core Version:    0.7.0.1
 */