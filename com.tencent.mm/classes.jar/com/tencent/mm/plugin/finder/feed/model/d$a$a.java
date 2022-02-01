package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$Companion$FavFeedCache;", "", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;)V", "getDataList", "()Ljava/util/List;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class d$a$a
{
  final List<BaseFinderFeed> dataList;
  public final b lastBuffer;
  
  public d$a$a(List<? extends BaseFinderFeed> paramList, b paramb)
  {
    AppMethodBeat.i(202053);
    this.dataList = paramList;
    this.lastBuffer = paramb;
    AppMethodBeat.o(202053);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202056);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!k.g(this.dataList, paramObject.dataList)) || (!k.g(this.lastBuffer, paramObject.lastBuffer))) {}
      }
    }
    else
    {
      AppMethodBeat.o(202056);
      return true;
    }
    AppMethodBeat.o(202056);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(202055);
    Object localObject = this.dataList;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.lastBuffer;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(202055);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202054);
    String str = "FavFeedCache(dataList=" + this.dataList + ", lastBuffer=" + this.lastBuffer + ")";
    AppMethodBeat.o(202054);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.d.a.a
 * JD-Core Version:    0.7.0.1
 */