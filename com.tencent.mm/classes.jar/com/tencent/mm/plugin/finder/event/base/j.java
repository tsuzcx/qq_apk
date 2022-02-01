package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "()I", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "visibleNotFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getVisibleNotFeedList", "()Ljava/util/LinkedList;", "setVisibleNotFeedList", "(Ljava/util/LinkedList;)V", "toString", "", "plugin-finder_release"})
public final class j
  extends h
{
  public int nAG = -1;
  public int nAH = -1;
  public long raQ = -1L;
  public List<g> rdP;
  public List<g> rdQ;
  public LinkedList<a> rdR;
  
  public j(int paramInt)
  {
    super(paramInt);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201430);
    StringBuilder localStringBuilder = new StringBuilder("ScrollEvent(type=").append(this.type).append(", firstCompletelyVisibleItemPosition=").append(this.rdG).append(", firstVisibleItemPosition=").append(this.rdH).append(", lastCompletelyVisibleItemPosition=").append(this.rdI).append(", lastVisibleItemPosition=").append(this.rdJ).append(", itemCount=").append(this.ahX).append(", newState=").append(this.rdK).append(") idleAcrossFeedList=");
    Object localObject = this.rdP;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((List)localObject).size());; localObject = null)
    {
      localObject = localObject;
      AppMethodBeat.o(201430);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.j
 * JD-Core Version:    0.7.0.1
 */