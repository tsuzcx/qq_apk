package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "()I", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "visibleNotFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getVisibleNotFeedList", "()Ljava/util/LinkedList;", "setVisibleNotFeedList", "(Ljava/util/LinkedList;)V", "toString", "", "plugin-finder_release"})
public final class j
  extends h
{
  public int ptb = -1;
  public int ptc = -1;
  public long tCi = -1L;
  public List<g> tIH;
  public List<g> tII;
  public LinkedList<bo> tIJ;
  
  public j(int paramInt)
  {
    super(paramInt);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(243471);
    StringBuilder localStringBuilder = new StringBuilder("ScrollEvent(type=").append(this.type).append(", ").append(this.tIx).append(", ").append(this.tIy).append(", ").append(this.tIz).append(", ").append(this.tIA).append(", itemCount=").append(this.akb).append(", newState=").append(this.tIB).append(") idleAcrossFeedList=");
    Object localObject = this.tIH;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((List)localObject).size());; localObject = null)
    {
      localObject = localObject;
      AppMethodBeat.o(243471);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.j
 * JD-Core Version:    0.7.0.1
 */