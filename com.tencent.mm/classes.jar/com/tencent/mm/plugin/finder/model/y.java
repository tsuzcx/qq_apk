package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "obj", "getObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "compare", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "equals", "", "other", "", "getFriendLikeCount", "getItemId", "", "getItemType", "getSessionBuffer", "toString", "plugin-finder_release"})
public final class y
  implements bo
{
  private final String TAG;
  public final FinderObject uOo;
  
  public y(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(248750);
    this.TAG = "FinderFeedLiveListItem";
    this.uOo = paramFinderObject;
    AppMethodBeat.o(248750);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248748);
    p.h(parami, "obj");
    if (!(parami instanceof y)) {}
    for (i locali = null;; locali = parami)
    {
      if ((y)locali != null)
      {
        if (((y)parami).uOo.id == this.uOo.id)
        {
          AppMethodBeat.o(248748);
          return 0;
        }
        AppMethodBeat.o(248748);
        return -1;
      }
      AppMethodBeat.o(248748);
      return -1;
    }
  }
  
  public final int cxn()
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
        return paramObject.uOo.id == this.uOo.id;
      }
      return false;
    }
  }
  
  public final long lT()
  {
    return this.uOo.id;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248749);
    StringBuilder localStringBuilder1 = new StringBuilder("liveItem:");
    StringBuilder localStringBuilder2 = new StringBuilder("[username:").append(this.uOo.nickname).append(",feedId:").append(this.uOo.id).append(",liveId:");
    Object localObject = this.uOo.liveInfo;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((awe)localObject).liveId);; localObject = null)
    {
      localObject = localStringBuilder1.append(localObject + ",friendLikeCount:" + this.uOo.friendLikeCount + ']');
      p.g(localObject, "StringBuilder(\"liveItem:…${obj.friendLikeCount}]\")");
      localObject = ((StringBuilder)localObject).toString();
      p.g(localObject, "sb.toString()");
      AppMethodBeat.o(248749);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.y
 * JD-Core Version:    0.7.0.1
 */