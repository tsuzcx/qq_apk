package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.view.recyclerview.f;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ILcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getDataPos", "()I", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class g
{
  public final BaseFinderFeed rQZ;
  public final int rRa;
  public f rRb;
  
  private g(BaseFinderFeed paramBaseFinderFeed, int paramInt)
  {
    AppMethodBeat.i(201563);
    this.rQZ = paramBaseFinderFeed;
    this.rRa = paramInt;
    this.rRb = null;
    AppMethodBeat.o(201563);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201566);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((!p.i(this.rQZ, paramObject.rQZ)) || (this.rRa != paramObject.rRa) || (!p.i(this.rRb, paramObject.rRb))) {}
      }
    }
    else
    {
      AppMethodBeat.o(201566);
      return true;
    }
    AppMethodBeat.o(201566);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(201565);
    Object localObject = this.rQZ;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      int k = this.rRa;
      localObject = this.rRb;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(201565);
      return (i * 31 + k) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201564);
    String str = "FlowScrollEventFeedData(feed=" + this.rQZ + ", dataPos=" + this.rRa + ", showInfo=" + this.rRb + ")";
    AppMethodBeat.o(201564);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.g
 * JD-Core Version:    0.7.0.1
 */