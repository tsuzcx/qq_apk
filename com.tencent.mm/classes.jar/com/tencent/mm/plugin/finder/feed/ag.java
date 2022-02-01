package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bcu;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/model/IFeedSessionBuffer;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "layoutType", "", "rvFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;ILjava/util/LinkedList;)V", "getCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "setCard", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;)V", "getLayoutType", "()I", "position", "getPosition", "setPosition", "(I)V", "recTimeMs", "", "getRecTimeMs", "()J", "setRecTimeMs", "(J)V", "getRvFeedList", "()Ljava/util/LinkedList;", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "getSessionBuffer", "", "plugin-finder_release"})
public final class ag
  implements bo
{
  public int position;
  public final LinkedList<BaseFinderFeed> rvFeedList;
  public long tQP;
  public bcu tQQ;
  private final int tQR;
  
  public ag(bcu parambcu, int paramInt, LinkedList<BaseFinderFeed> paramLinkedList)
  {
    AppMethodBeat.i(244172);
    this.tQQ = parambcu;
    this.tQR = paramInt;
    this.rvFeedList = paramLinkedList;
    this.tQP = cl.aWA();
    this.position = -1;
    AppMethodBeat.o(244172);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(244171);
    p.h(parami, "obj");
    if (((parami instanceof bcu)) && (((bcu)parami).uOx == this.tQQ.uOx) && (((bcu)parami).tQR == this.tQQ.tQR))
    {
      AppMethodBeat.o(244171);
      return 0;
    }
    AppMethodBeat.o(244171);
    return -1;
  }
  
  public final int cxn()
  {
    switch (this.tQR)
    {
    case 1: 
    default: 
      return 0;
    case 0: 
      return 2010;
    }
    return 2013;
  }
  
  public final long lT()
  {
    return this.tQQ.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ag
 * JD-Core Version:    0.7.0.1
 */