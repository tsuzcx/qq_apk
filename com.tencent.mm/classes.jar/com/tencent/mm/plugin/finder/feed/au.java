package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/model/IFeedSessionBuffer;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "layoutType", "", "rvFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;ILjava/util/LinkedList;)V", "getCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "setCard", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;)V", "getLayoutType", "()I", "position", "getPosition", "setPosition", "(I)V", "recTimeMs", "", "getRecTimeMs", "()J", "setRecTimeMs", "(J)V", "getRvFeedList", "()Ljava/util/LinkedList;", "setRvFeedList", "(Ljava/util/LinkedList;)V", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "getSessionBuffer", "", "toFeedItem", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  implements cc
{
  public static final a AYV;
  public bwa AYW;
  public final int AYX;
  public long AYY;
  public int position;
  public LinkedList<BaseFinderFeed> rvFeedList;
  
  static
  {
    AppMethodBeat.i(362971);
    AYV = new a((byte)0);
    AppMethodBeat.o(362971);
  }
  
  public au(bwa parambwa, int paramInt, LinkedList<BaseFinderFeed> paramLinkedList)
  {
    AppMethodBeat.i(362962);
    this.AYW = parambwa;
    this.AYX = paramInt;
    this.rvFeedList = paramLinkedList;
    this.AYY = cn.bDw();
    Log.i("FinderStreamCardFeed", "#init");
    this.position = -1;
    AppMethodBeat.o(362962);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(362991);
    s.u(paramk, "obj");
    if (((paramk instanceof bwa)) && (((bwa)paramk).ECY == this.AYW.ECY) && (((bwa)paramk).AYX == this.AYW.AYX))
    {
      AppMethodBeat.o(362991);
      return 0;
    }
    AppMethodBeat.o(362991);
    return -1;
  }
  
  public final long bZA()
  {
    return this.AYW.id;
  }
  
  public final int bZB()
  {
    switch (this.AYX)
    {
    case 1: 
    case 3: 
    default: 
      return 0;
    case 0: 
      return 2010;
    case 2: 
      return 2013;
    }
    return 4;
  }
  
  public final FeedData ecz()
  {
    AppMethodBeat.i(362997);
    FeedData localFeedData = new FeedData();
    localFeedData.setFeedId(this.AYW.id);
    localFeedData.setMediaType(bZB());
    localFeedData.setRvFeedList(this.rvFeedList);
    AppMethodBeat.o(362997);
    return localFeedData;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.au
 * JD-Core Version:    0.7.0.1
 */