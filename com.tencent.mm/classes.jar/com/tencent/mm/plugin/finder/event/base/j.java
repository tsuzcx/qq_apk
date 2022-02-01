package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "()I", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "visibleNotFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getVisibleNotFeedList", "()Ljava/util/LinkedList;", "setVisibleNotFeedList", "(Ljava/util/LinkedList;)V", "toString", "", "plugin-finder_release"})
public final class j
  extends h
{
  public int ohB = -1;
  public int ohC = -1;
  public long rVz = -1L;
  public List<g> rZR;
  public List<g> rZS;
  public LinkedList<a> rZT;
  
  public j(int paramInt)
  {
    super(paramInt);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202018);
    StringBuilder localStringBuilder = new StringBuilder("ScrollEvent(type=").append(this.type).append(", firstCompletelyVisibleItemPosition=").append(this.rZE).append(", firstVisibleItemPosition=").append(this.rZF).append(", lastCompletelyVisibleItemPosition=").append(this.rZG).append(", lastVisibleItemPosition=").append(this.rZH).append(", itemCount=").append(this.ajO).append(", newState=").append(this.rZK).append(") idleAcrossFeedList=");
    Object localObject = this.rZR;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((List)localObject).size());; localObject = null)
    {
      localObject = localObject;
      AppMethodBeat.o(202018);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.j
 * JD-Core Version:    0.7.0.1
 */