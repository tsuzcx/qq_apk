package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ana;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/PageFinderItem;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceFlag", "(IJLcom/tencent/mm/protocal/protobuf/FinderObject;I)V", "extract", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class n
  extends o
{
  public n(int paramInt1, long paramLong, FinderObject paramFinderObject, int paramInt2)
  {
    AppMethodBeat.i(204434);
    ana localana = this.sLi;
    localana.id = paramLong;
    localana.type = paramInt1;
    localana.GFh = paramFinderObject;
    localana.GFi = paramInt2;
    paramFinderObject = h.sKR;
    localana.dataType = 0;
    AppMethodBeat.o(204434);
  }
  
  public n(ana paramana)
  {
    super(paramana);
    AppMethodBeat.i(204433);
    AppMethodBeat.o(204433);
  }
  
  public final am cLN()
  {
    AppMethodBeat.i(204432);
    int i = this.sLi.dataType;
    Object localObject = h.sKR;
    if (i == 0)
    {
      localObject = h.sKR;
      localObject = h.a(this.sLi);
      if (localObject != null)
      {
        j localj = j.sKW;
        localObject = j.g((FinderItem)localObject);
        AppMethodBeat.o(204432);
        return localObject;
      }
      AppMethodBeat.o(204432);
      return null;
    }
    AppMethodBeat.o(204432);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.n
 * JD-Core Version:    0.7.0.1
 */