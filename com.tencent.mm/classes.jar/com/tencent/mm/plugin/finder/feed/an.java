package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.protocal.protobuf.bjp;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/model/IFeedSessionBuffer;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "layoutType", "", "rvFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;ILjava/util/LinkedList;)V", "getCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "setCard", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;)V", "getLayoutType", "()I", "position", "getPosition", "setPosition", "(I)V", "recTimeMs", "", "getRecTimeMs", "()J", "setRecTimeMs", "(J)V", "getRvFeedList", "()Ljava/util/LinkedList;", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "getSessionBuffer", "", "toFeedItem", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "plugin-finder_release"})
public final class an
  implements bu
{
  public int position;
  public final LinkedList<BaseFinderFeed> rvFeedList;
  public long xBG;
  public bjp xBH;
  private final int xBI;
  
  public an(bjp parambjp, int paramInt, LinkedList<BaseFinderFeed> paramLinkedList)
  {
    AppMethodBeat.i(286429);
    this.xBH = parambjp;
    this.xBI = paramInt;
    this.rvFeedList = paramLinkedList;
    this.xBG = cm.bfE();
    this.position = -1;
    AppMethodBeat.o(286429);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(286427);
    p.k(paramk, "obj");
    if (((paramk instanceof bjp)) && (((bjp)paramk).zAO == this.xBH.zAO) && (((bjp)paramk).xBI == this.xBH.xBI))
    {
      AppMethodBeat.o(286427);
      return 0;
    }
    AppMethodBeat.o(286427);
    return -1;
  }
  
  public final int bAQ()
  {
    switch (this.xBI)
    {
    case 1: 
    default: 
      return 0;
    case 0: 
      return 2010;
    }
    return 2013;
  }
  
  public final FeedData dtn()
  {
    AppMethodBeat.i(286428);
    FeedData localFeedData = new FeedData();
    localFeedData.setFeedId(this.xBH.id);
    localFeedData.setMediaType(bAQ());
    localFeedData.setRvFeedList(this.rvFeedList);
    AppMethodBeat.o(286428);
    return localFeedData;
  }
  
  public final long mf()
  {
    return this.xBH.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.an
 * JD-Core Version:    0.7.0.1
 */