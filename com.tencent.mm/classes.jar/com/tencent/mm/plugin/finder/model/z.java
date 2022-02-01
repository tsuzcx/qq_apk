package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "obj", "getObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "compare", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "equals", "", "other", "", "getFriendLikeCount", "getItemId", "", "getItemType", "getLiveId", "getLiveUrl", "getSessionBuffer", "getSmallResolutionLiveUrl", "isAudioLive", "isLiveFinish", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  implements cc
{
  public final FinderObject ECN;
  private final String TAG;
  
  public z(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(332239);
    this.TAG = "FinderFeedLiveListItem";
    this.ECN = paramFinderObject;
    AppMethodBeat.o(332239);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332255);
    s.u(paramk, "obj");
    z localz;
    if ((paramk instanceof z)) {
      localz = (z)paramk;
    }
    while (localz != null) {
      if (((z)paramk).ECN.id == this.ECN.id)
      {
        AppMethodBeat.o(332255);
        return 0;
        localz = null;
      }
      else
      {
        AppMethodBeat.o(332255);
        return -1;
      }
    }
    AppMethodBeat.o(332255);
    return -1;
  }
  
  public final long bZA()
  {
    return this.ECN.id;
  }
  
  public final int bZB()
  {
    return 2004;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if ((paramObject instanceof z)) {}
    for (paramObject = (z)paramObject;; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.ECN.id == this.ECN.id) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(332269);
    StringBuilder localStringBuilder1 = new StringBuilder("liveItem:");
    StringBuilder localStringBuilder2 = new StringBuilder("[nickname:").append(o.aBv(this.ECN.nickname)).append(",feedId:").append(this.ECN.id).append(",liveId:");
    Object localObject = this.ECN.liveInfo;
    if (localObject == null) {}
    for (localObject = null;; localObject = Long.valueOf(((bip)localObject).liveId))
    {
      localObject = localStringBuilder2.append(localObject).append(",friendLikeCount:").append(this.ECN.friendLikeCount).append(']').toString();
      s.s(localObject, "sb.toString()");
      AppMethodBeat.o(332269);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.z
 * JD-Core Version:    0.7.0.1
 */