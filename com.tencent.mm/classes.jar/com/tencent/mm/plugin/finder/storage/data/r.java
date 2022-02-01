package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqq;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/PageFinderItem;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceFlag", "(IJLcom/tencent/mm/protocal/protobuf/FinderObject;I)V", "extract", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class r
  extends s
{
  public r(int paramInt1, long paramLong, FinderObject paramFinderObject, int paramInt2)
  {
    AppMethodBeat.i(252040);
    aqq localaqq = this.vGD;
    localaqq.id = paramLong;
    localaqq.type = paramInt1;
    localaqq.LCD = paramFinderObject;
    localaqq.LCE = paramInt2;
    paramFinderObject = i.vGl;
    localaqq.dataType = 0;
    AppMethodBeat.o(252040);
  }
  
  public r(aqq paramaqq)
  {
    super(paramaqq);
    AppMethodBeat.i(252039);
    AppMethodBeat.o(252039);
  }
  
  public final bo dyH()
  {
    AppMethodBeat.i(252038);
    int i = this.vGD.dataType;
    Object localObject = i.vGl;
    if (i == 0)
    {
      localObject = i.vGl;
      localObject = i.a(this.vGD);
      if (localObject != null)
      {
        k localk = k.vGq;
        localObject = k.o((FinderItem)localObject);
        AppMethodBeat.o(252038);
        return localObject;
      }
      AppMethodBeat.o(252038);
      return null;
    }
    AppMethodBeat.o(252038);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.r
 * JD-Core Version:    0.7.0.1
 */