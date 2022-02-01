package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axb;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/PageFinderItem;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceFlag", "(IJLcom/tencent/mm/protocal/protobuf/FinderObject;I)V", "extract", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends s
{
  public r(int paramInt1, long paramLong, FinderObject paramFinderObject, int paramInt2)
  {
    AppMethodBeat.i(339309);
    Object localObject = z.FrZ;
    z.p(paramFinderObject);
    localObject = this.FNr;
    ((axb)localObject).id = paramLong;
    ((axb)localObject).type = paramInt1;
    ((axb)localObject).ZIo = paramFinderObject;
    ((axb)localObject).ZIp = paramInt2;
    paramFinderObject = h.FMZ;
    ((axb)localObject).dataType = h.fac();
    AppMethodBeat.o(339309);
  }
  
  public r(axb paramaxb)
  {
    super(paramaxb);
    AppMethodBeat.i(339302);
    AppMethodBeat.o(339302);
  }
  
  public final cc eIE()
  {
    AppMethodBeat.i(339318);
    int i = this.FNr.dataType;
    Object localObject = h.FMZ;
    if (i == h.fac())
    {
      localObject = h.FMZ;
      localObject = h.a(this.FNr);
      if (localObject != null)
      {
        j localj = j.FNf;
        localObject = j.t((FinderItem)localObject);
        AppMethodBeat.o(339318);
        return localObject;
      }
      AppMethodBeat.o(339318);
      return null;
    }
    AppMethodBeat.o(339318);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.r
 * JD-Core Version:    0.7.0.1
 */