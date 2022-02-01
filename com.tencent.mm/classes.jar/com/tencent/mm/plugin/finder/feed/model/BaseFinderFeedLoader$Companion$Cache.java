package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$Companion$Cache;", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/util/ArrayList;Lcom/tencent/mm/protobuf/ByteString;)V", "getDataList", "()Ljava/util/ArrayList;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class BaseFinderFeedLoader$Companion$Cache
{
  private final ArrayList<BaseFinderFeed> dataList;
  private final b lastBuffer;
  
  public BaseFinderFeedLoader$Companion$Cache(ArrayList<BaseFinderFeed> paramArrayList, b paramb)
  {
    AppMethodBeat.i(185702);
    this.dataList = paramArrayList;
    this.lastBuffer = paramb;
    AppMethodBeat.o(185702);
  }
  
  public final ArrayList<BaseFinderFeed> component1()
  {
    return this.dataList;
  }
  
  public final b component2()
  {
    return this.lastBuffer;
  }
  
  public final Cache copy(ArrayList<BaseFinderFeed> paramArrayList, b paramb)
  {
    AppMethodBeat.i(202037);
    k.h(paramArrayList, "dataList");
    paramArrayList = new Cache(paramArrayList, paramb);
    AppMethodBeat.o(202037);
    return paramArrayList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(185705);
    if (this != paramObject)
    {
      if ((paramObject instanceof Cache))
      {
        paramObject = (Cache)paramObject;
        if ((!k.g(this.dataList, paramObject.dataList)) || (!k.g(this.lastBuffer, paramObject.lastBuffer))) {}
      }
    }
    else
    {
      AppMethodBeat.o(185705);
      return true;
    }
    AppMethodBeat.o(185705);
    return false;
  }
  
  public final ArrayList<BaseFinderFeed> getDataList()
  {
    return this.dataList;
  }
  
  public final b getLastBuffer()
  {
    return this.lastBuffer;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(185704);
    Object localObject = this.dataList;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.lastBuffer;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(185704);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(185703);
    String str = "Cache(dataList=" + this.dataList + ", lastBuffer=" + this.lastBuffer + ")";
    AppMethodBeat.o(185703);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader.Companion.Cache
 * JD-Core Version:    0.7.0.1
 */