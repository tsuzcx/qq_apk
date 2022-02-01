package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.view.recyclerview.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dataPos", "", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;ILcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getDataPos", "()I", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-base_release"})
public final class g
{
  public final bu xrd;
  public final int xre;
  public j xrf;
  
  private g(bu parambu, int paramInt)
  {
    AppMethodBeat.i(259074);
    this.xrd = parambu;
    this.xre = paramInt;
    this.xrf = null;
    AppMethodBeat.o(259074);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(259083);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((!p.h(this.xrd, paramObject.xrd)) || (this.xre != paramObject.xre) || (!p.h(this.xrf, paramObject.xrf))) {}
      }
    }
    else
    {
      AppMethodBeat.o(259083);
      return true;
    }
    AppMethodBeat.o(259083);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(259081);
    Object localObject = this.xrd;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      int k = this.xre;
      localObject = this.xrf;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(259081);
      return (i * 31 + k) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(259078);
    String str = "FlowScrollEventFeedData(feed=" + this.xrd + ", dataPos=" + this.xre + ", showInfo=" + this.xrf + ")";
    AppMethodBeat.o(259078);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.g
 * JD-Core Version:    0.7.0.1
 */