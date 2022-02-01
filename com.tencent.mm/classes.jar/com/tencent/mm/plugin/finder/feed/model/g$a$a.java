package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$Companion$FoldedFeedCache;", "", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;)V", "getDataList", "()Ljava/util/List;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
public final class g$a$a
{
  final List<BaseFinderFeed> dataList;
  private final b lastBuffer;
  
  public g$a$a(List<? extends BaseFinderFeed> paramList)
  {
    AppMethodBeat.i(202099);
    this.dataList = paramList;
    this.lastBuffer = null;
    AppMethodBeat.o(202099);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202102);
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
      AppMethodBeat.o(202102);
      return true;
    }
    AppMethodBeat.o(202102);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(202101);
    Object localObject = this.dataList;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.lastBuffer;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(202101);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202100);
    String str = "FoldedFeedCache(dataList=" + this.dataList + ", lastBuffer=" + this.lastBuffer + ")";
    AppMethodBeat.o(202100);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.g.a.a
 * JD-Core Version:    0.7.0.1
 */