package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.model.am;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "position", "", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "(Ljava/util/ArrayList;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/plugin/finder/feed/model/CacheCustom;)V", "getCustomData", "()Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "getDataList", "()Ljava/util/ArrayList;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPosition", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class e
{
  public final ArrayList<am> jhZ;
  public final b lastBuffer;
  public final int position;
  public final a slj;
  
  public e(ArrayList<am> paramArrayList, b paramb, int paramInt, a parama)
  {
    AppMethodBeat.i(202982);
    this.jhZ = paramArrayList;
    this.lastBuffer = paramb;
    this.position = paramInt;
    this.slj = parama;
    AppMethodBeat.o(202982);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202985);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.i(this.jhZ, paramObject.jhZ)) || (!p.i(this.lastBuffer, paramObject.lastBuffer)) || (this.position != paramObject.position) || (!p.i(this.slj, paramObject.slj))) {}
      }
    }
    else
    {
      AppMethodBeat.o(202985);
      return true;
    }
    AppMethodBeat.o(202985);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(202984);
    Object localObject = this.jhZ;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.lastBuffer;
      if (localObject == null) {
        break label92;
      }
    }
    label92:
    for (int j = localObject.hashCode();; j = 0)
    {
      int m = this.position;
      localObject = this.slj;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(202984);
      return ((j + i * 31) * 31 + m) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202983);
    String str = "LoaderCache(dataList=" + this.jhZ + ", lastBuffer=" + this.lastBuffer + ", position=" + this.position + ", customData=" + this.slj + ")";
    AppMethodBeat.o(202983);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.e
 * JD-Core Version:    0.7.0.1
 */