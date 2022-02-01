package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.model.cc;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "position", "", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "(Ljava/util/ArrayList;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/plugin/finder/feed/model/CacheCustom;)V", "getCustomData", "()Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "getDataList", "()Ljava/util/ArrayList;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPosition", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public final c BjG;
  boolean hasMore;
  public final b lastBuffer;
  public final ArrayList<cc> pUj;
  public final int position;
  
  public s(ArrayList<cc> paramArrayList, b paramb, int paramInt, c paramc)
  {
    AppMethodBeat.i(366392);
    this.pUj = paramArrayList;
    this.lastBuffer = paramb;
    this.position = paramInt;
    this.BjG = paramc;
    AppMethodBeat.o(366392);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(366414);
    if (this == paramObject)
    {
      AppMethodBeat.o(366414);
      return true;
    }
    if (!(paramObject instanceof s))
    {
      AppMethodBeat.o(366414);
      return false;
    }
    paramObject = (s)paramObject;
    if (!kotlin.g.b.s.p(this.pUj, paramObject.pUj))
    {
      AppMethodBeat.o(366414);
      return false;
    }
    if (!kotlin.g.b.s.p(this.lastBuffer, paramObject.lastBuffer))
    {
      AppMethodBeat.o(366414);
      return false;
    }
    if (this.position != paramObject.position)
    {
      AppMethodBeat.o(366414);
      return false;
    }
    if (!kotlin.g.b.s.p(this.BjG, paramObject.BjG))
    {
      AppMethodBeat.o(366414);
      return false;
    }
    AppMethodBeat.o(366414);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(366407);
    int k = this.pUj.hashCode();
    int i;
    int m;
    if (this.lastBuffer == null)
    {
      i = 0;
      m = this.position;
      if (this.BjG != null) {
        break label71;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(366407);
      return ((i + k * 31) * 31 + m) * 31 + j;
      i = this.lastBuffer.hashCode();
      break;
      label71:
      j = this.BjG.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(366399);
    String str = "LoaderCache(dataList=" + this.pUj + ", lastBuffer=" + this.lastBuffer + ", position=" + this.position + ", customData=" + this.BjG + ')';
    AppMethodBeat.o(366399);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.s
 * JD-Core Version:    0.7.0.1
 */