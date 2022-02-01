package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.view.recyclerview.f;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ILcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getDataPos", "()I", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class g
{
  public final BaseFinderFeed rZB;
  public final int rZC;
  public f rZD;
  
  private g(BaseFinderFeed paramBaseFinderFeed, int paramInt)
  {
    AppMethodBeat.i(202010);
    this.rZB = paramBaseFinderFeed;
    this.rZC = paramInt;
    this.rZD = null;
    AppMethodBeat.o(202010);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(202013);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((!p.i(this.rZB, paramObject.rZB)) || (this.rZC != paramObject.rZC) || (!p.i(this.rZD, paramObject.rZD))) {}
      }
    }
    else
    {
      AppMethodBeat.o(202013);
      return true;
    }
    AppMethodBeat.o(202013);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(202012);
    Object localObject = this.rZB;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      int k = this.rZC;
      localObject = this.rZD;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(202012);
      return (i * 31 + k) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202011);
    String str = "FlowScrollEventFeedData(feed=" + this.rZB + ", dataPos=" + this.rZC + ", showInfo=" + this.rZD + ")";
    AppMethodBeat.o(202011);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.g
 * JD-Core Version:    0.7.0.1
 */