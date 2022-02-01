package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "()I", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "visibleNotFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getVisibleNotFeedList", "()Ljava/util/LinkedList;", "setVisibleNotFeedList", "(Ljava/util/LinkedList;)V", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends h
{
  public long AIv = -1L;
  public List<g> AOA;
  public List<g> AOB;
  public LinkedList<cc> AOC;
  public int vIj = -1;
  public int vIk = -1;
  
  public k(int paramInt)
  {
    super(paramInt);
  }
  
  public final int dYI()
  {
    return this.vIk;
  }
  
  public final int dYQ()
  {
    return this.vIj;
  }
  
  public final List<g> dYR()
  {
    return this.AOB;
  }
  
  public final LinkedList<cc> dYS()
  {
    return this.AOC;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(330334);
    StringBuilder localStringBuilder = new StringBuilder("ScrollEvent(type=").append(this.type).append(", ").append(this.AOq).append(", ").append(this.AOr).append(", ").append(this.AOs).append(", ").append(this.AOt).append(", itemCount=").append(this.bUo).append(", newState=").append(this.AOu).append(") idleAcrossFeedList=");
    Object localObject = this.AOA;
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((List)localObject).size()))
    {
      localObject = localObject;
      AppMethodBeat.o(330334);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.k
 * JD-Core Version:    0.7.0.1
 */