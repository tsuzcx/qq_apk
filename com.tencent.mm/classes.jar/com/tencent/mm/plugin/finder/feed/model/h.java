package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.model.bo;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "position", "", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "(Ljava/util/ArrayList;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/plugin/finder/feed/model/CacheCustom;)V", "getCustomData", "()Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "getDataList", "()Ljava/util/ArrayList;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPosition", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class h
{
  public final ArrayList<bo> kgc;
  public final b lastBuffer;
  public final int position;
  public final a tXU;
  
  public h(ArrayList<bo> paramArrayList, b paramb, int paramInt, a parama)
  {
    AppMethodBeat.i(244934);
    this.kgc = paramArrayList;
    this.lastBuffer = paramb;
    this.position = paramInt;
    this.tXU = parama;
    AppMethodBeat.o(244934);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(244937);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.j(this.kgc, paramObject.kgc)) || (!p.j(this.lastBuffer, paramObject.lastBuffer)) || (this.position != paramObject.position) || (!p.j(this.tXU, paramObject.tXU))) {}
      }
    }
    else
    {
      AppMethodBeat.o(244937);
      return true;
    }
    AppMethodBeat.o(244937);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(244936);
    Object localObject = this.kgc;
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
      localObject = this.tXU;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(244936);
      return ((j + i * 31) * 31 + m) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(244935);
    String str = "LoaderCache(dataList=" + this.kgc + ", lastBuffer=" + this.lastBuffer + ", position=" + this.position + ", customData=" + this.tXU + ")";
    AppMethodBeat.o(244935);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.h
 * JD-Core Version:    0.7.0.1
 */