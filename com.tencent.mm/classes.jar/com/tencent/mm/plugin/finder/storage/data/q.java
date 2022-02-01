package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asm;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/PageFinderItem;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceFlag", "(IJLcom/tencent/mm/protocal/protobuf/FinderObject;I)V", "extract", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class q
  extends r
{
  public q(int paramInt1, long paramLong, FinderObject paramFinderObject, int paramInt2)
  {
    AppMethodBeat.i(282582);
    Object localObject = n.zWF;
    n.l(paramFinderObject);
    localObject = this.AnB;
    ((asm)localObject).id = paramLong;
    ((asm)localObject).type = paramInt1;
    ((asm)localObject).SFP = paramFinderObject;
    ((asm)localObject).SFQ = paramInt2;
    paramFinderObject = h.Ang;
    ((asm)localObject).dataType = 0;
    AppMethodBeat.o(282582);
  }
  
  public q(asm paramasm)
  {
    super(paramasm);
    AppMethodBeat.i(282580);
    AppMethodBeat.o(282580);
  }
  
  public final bu dZA()
  {
    AppMethodBeat.i(282578);
    int i = this.AnB.dataType;
    Object localObject = h.Ang;
    if (i == 0)
    {
      localObject = h.Ang;
      localObject = h.a(this.AnB);
      if (localObject != null)
      {
        j localj = j.Ann;
        localObject = j.p((FinderItem)localObject);
        AppMethodBeat.o(282578);
        return localObject;
      }
      AppMethodBeat.o(282578);
      return null;
    }
    AppMethodBeat.o(282578);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.q
 * JD-Core Version:    0.7.0.1
 */