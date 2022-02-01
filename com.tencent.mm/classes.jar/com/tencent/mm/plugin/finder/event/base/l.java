package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/SingleFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "()I", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "visibleNotFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "getVisibleNotFeedList", "()Ljava/util/LinkedList;", "setVisibleNotFeedList", "(Ljava/util/LinkedList;)V", "toString", "", "plugin-finder_release"})
public final class l
  extends i
{
  public List<k> KMl;
  public List<k> KMm;
  public LinkedList<a> KMn;
  public int mYh = -1;
  public int mYi = -1;
  public long qGl = -1L;
  
  public l(int paramInt)
  {
    super(paramInt);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197549);
    StringBuilder localStringBuilder = new StringBuilder("ScrollEvent(type=").append(this.type).append(", firstCompletelyVisibleItemPosition=").append(this.qsB).append(", firstVisibleItemPosition=").append(this.qsi).append(", lastCompletelyVisibleItemPosition=").append(this.qsC).append(", lastVisibleItemPosition=").append(this.qsj).append(", itemCount=").append(this.ahd).append(", newState=").append(this.qsD).append(") idleAcrossFeedList=");
    Object localObject = this.KMl;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((List)localObject).size());; localObject = null)
    {
      localObject = localObject;
      AppMethodBeat.o(197549);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.l
 * JD-Core Version:    0.7.0.1
 */