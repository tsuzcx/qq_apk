package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.utils.j;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "obj", "getObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "compare", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "equals", "", "other", "", "getFriendLikeCount", "getItemId", "", "getItemType", "getLiveId", "getLiveUrl", "getSessionBuffer", "getSmallResolutionLiveUrl", "isAudioLive", "isLiveFinish", "toString", "plugin-finder_release"})
public final class y
  implements bu
{
  private final String TAG;
  public final FinderObject zAF;
  
  public y(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(244027);
    this.TAG = "FinderFeedLiveListItem";
    this.zAF = paramFinderObject;
    AppMethodBeat.o(244027);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(244022);
    p.k(paramk, "obj");
    if (!(paramk instanceof y)) {}
    for (k localk = null;; localk = paramk)
    {
      if ((y)localk != null)
      {
        if (((y)paramk).zAF.id == this.zAF.id)
        {
          AppMethodBeat.o(244022);
          return 0;
        }
        AppMethodBeat.o(244022);
        return -1;
      }
      AppMethodBeat.o(244022);
      return -1;
    }
  }
  
  public final int bAQ()
  {
    return 2004;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof y)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (y)paramObject;
      if (paramObject != null) {
        return paramObject.zAF.id == this.zAF.id;
      }
      return false;
    }
  }
  
  public final long mf()
  {
    return this.zAF.id;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(244025);
    StringBuilder localStringBuilder1 = new StringBuilder("liveItem:");
    StringBuilder localStringBuilder2 = new StringBuilder("[nickname:").append(j.aFz(this.zAF.nickname)).append(",feedId:").append(this.zAF.id).append(",liveId:");
    Object localObject = this.zAF.liveInfo;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((bac)localObject).liveId);; localObject = null)
    {
      localObject = localStringBuilder1.append(localObject + ",friendLikeCount:" + this.zAF.friendLikeCount + ']');
      p.j(localObject, "StringBuilder(\"liveItem:…${obj.friendLikeCount}]\")");
      localObject = ((StringBuilder)localObject).toString();
      p.j(localObject, "sb.toString()");
      AppMethodBeat.o(244025);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.y
 * JD-Core Version:    0.7.0.1
 */