package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.model.bu;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "position", "", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "(Ljava/util/ArrayList;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/plugin/finder/feed/model/CacheCustom;)V", "getCustomData", "()Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "getDataList", "()Ljava/util/ArrayList;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPosition", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-base_release"})
public final class q
{
  boolean hasMore;
  public final b lastBuffer;
  public final ArrayList<bu> mXB;
  public final int position;
  public final c xJT;
  
  public q(ArrayList<bu> paramArrayList, b paramb, int paramInt, c paramc)
  {
    AppMethodBeat.i(258876);
    this.mXB = paramArrayList;
    this.lastBuffer = paramb;
    this.position = paramInt;
    this.xJT = paramc;
    AppMethodBeat.o(258876);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(258882);
    if (this != paramObject)
    {
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if ((!p.h(this.mXB, paramObject.mXB)) || (!p.h(this.lastBuffer, paramObject.lastBuffer)) || (this.position != paramObject.position) || (!p.h(this.xJT, paramObject.xJT))) {}
      }
    }
    else
    {
      AppMethodBeat.o(258882);
      return true;
    }
    AppMethodBeat.o(258882);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(258880);
    Object localObject = this.mXB;
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
      localObject = this.xJT;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(258880);
      return ((j + i * 31) * 31 + m) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258878);
    String str = "LoaderCache(dataList=" + this.mXB + ", lastBuffer=" + this.lastBuffer + ", position=" + this.position + ", customData=" + this.xJT + ")";
    AppMethodBeat.o(258878);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.q
 * JD-Core Version:    0.7.0.1
 */