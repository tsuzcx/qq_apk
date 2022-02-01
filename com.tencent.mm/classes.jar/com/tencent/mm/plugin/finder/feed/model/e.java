package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.model.al;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "position", "", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "(Ljava/util/ArrayList;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/plugin/finder/feed/model/CacheCustom;)V", "getCustomData", "()Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "getDataList", "()Ljava/util/ArrayList;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPosition", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class e
{
  public final ArrayList<al> jfg;
  public final b lastBuffer;
  public final int position;
  public final a scs;
  
  public e(ArrayList<al> paramArrayList, b paramb, int paramInt, a parama)
  {
    AppMethodBeat.i(202506);
    this.jfg = paramArrayList;
    this.lastBuffer = paramb;
    this.position = paramInt;
    this.scs = parama;
    AppMethodBeat.o(202506);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202509);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.i(this.jfg, paramObject.jfg)) || (!p.i(this.lastBuffer, paramObject.lastBuffer)) || (this.position != paramObject.position) || (!p.i(this.scs, paramObject.scs))) {}
      }
    }
    else
    {
      AppMethodBeat.o(202509);
      return true;
    }
    AppMethodBeat.o(202509);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(202508);
    Object localObject = this.jfg;
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
      localObject = this.scs;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(202508);
      return ((j + i * 31) * 31 + m) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202507);
    String str = "LoaderCache(dataList=" + this.jfg + ", lastBuffer=" + this.lastBuffer + ", position=" + this.position + ", customData=" + this.scs + ")";
    AppMethodBeat.o(202507);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.e
 * JD-Core Version:    0.7.0.1
 */