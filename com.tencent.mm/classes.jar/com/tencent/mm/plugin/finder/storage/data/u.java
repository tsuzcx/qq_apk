package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axb;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/PageMegaVideoItem;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "sourceFlag", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(IJILcom/tencent/mm/protocal/protobuf/FinderObject;)V", "extract", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "targetDataType", "toRVFeed", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends s
{
  public u(long paramLong, int paramInt, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(339307);
    axb localaxb = this.FNr;
    localaxb.id = paramLong;
    localaxb.type = 0;
    localaxb.ZIo = paramFinderObject;
    localaxb.ZIp = paramInt;
    paramFinderObject = p.FNp;
    localaxb.dataType = p.fac();
    localaxb.ZIr = null;
    AppMethodBeat.o(339307);
  }
  
  public u(axb paramaxb)
  {
    super(paramaxb);
    AppMethodBeat.i(339297);
    AppMethodBeat.o(339297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.u
 * JD-Core Version:    0.7.0.1
 */