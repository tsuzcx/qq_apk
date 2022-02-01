package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "()I", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "visibleNotFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getVisibleNotFeedList", "()Ljava/util/LinkedList;", "setVisibleNotFeedList", "(Ljava/util/LinkedList;)V", "toString", "", "plugin-finder_release"})
public final class j
  extends h
{
  public int obN = -1;
  public int obO = -1;
  public long rNl = -1L;
  public List<g> rRp;
  public List<g> rRq;
  public LinkedList<a> rRr;
  
  public j(int paramInt)
  {
    super(paramInt);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201571);
    StringBuilder localStringBuilder = new StringBuilder("ScrollEvent(type=").append(this.type).append(", firstCompletelyVisibleItemPosition=").append(this.rRc).append(", firstVisibleItemPosition=").append(this.rRd).append(", lastCompletelyVisibleItemPosition=").append(this.rRe).append(", lastVisibleItemPosition=").append(this.rRf).append(", itemCount=").append(this.ajO).append(", newState=").append(this.rRi).append(") idleAcrossFeedList=");
    Object localObject = this.rRp;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((List)localObject).size());; localObject = null)
    {
      localObject = localObject;
      AppMethodBeat.o(201571);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.j
 * JD-Core Version:    0.7.0.1
 */