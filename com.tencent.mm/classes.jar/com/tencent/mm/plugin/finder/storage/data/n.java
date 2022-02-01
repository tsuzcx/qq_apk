package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amo;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/PageFinderItem;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceFlag", "(IJLcom/tencent/mm/protocal/protobuf/FinderObject;I)V", "extract", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class n
  extends o
{
  public n(int paramInt1, long paramLong, FinderObject paramFinderObject, int paramInt2)
  {
    AppMethodBeat.i(203843);
    amo localamo = this.sAk;
    localamo.id = paramLong;
    localamo.type = paramInt1;
    localamo.Gmf = paramFinderObject;
    localamo.Gmg = paramInt2;
    paramFinderObject = h.szU;
    localamo.dataType = 0;
    AppMethodBeat.o(203843);
  }
  
  public n(amo paramamo)
  {
    super(paramamo);
    AppMethodBeat.i(203842);
    AppMethodBeat.o(203842);
  }
  
  public final al cJk()
  {
    AppMethodBeat.i(203841);
    int i = this.sAk.dataType;
    Object localObject = h.szU;
    if (i == 0)
    {
      localObject = h.szU;
      localObject = h.a(this.sAk);
      if (localObject != null)
      {
        j localj = j.szZ;
        localObject = j.g((FinderItem)localObject);
        AppMethodBeat.o(203841);
        return localObject;
      }
      AppMethodBeat.o(203841);
      return null;
    }
    AppMethodBeat.o(203841);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.n
 * JD-Core Version:    0.7.0.1
 */