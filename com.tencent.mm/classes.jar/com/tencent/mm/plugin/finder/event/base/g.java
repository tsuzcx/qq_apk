package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.view.recyclerview.f;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ILcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getDataPos", "()I", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class g
{
  public final BaseFinderFeed rdD;
  public final int rdE;
  public f rdF;
  
  private g(BaseFinderFeed paramBaseFinderFeed, int paramInt)
  {
    AppMethodBeat.i(201422);
    this.rdD = paramBaseFinderFeed;
    this.rdE = paramInt;
    this.rdF = null;
    AppMethodBeat.o(201422);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201425);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((!k.g(this.rdD, paramObject.rdD)) || (this.rdE != paramObject.rdE) || (!k.g(this.rdF, paramObject.rdF))) {}
      }
    }
    else
    {
      AppMethodBeat.o(201425);
      return true;
    }
    AppMethodBeat.o(201425);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(201424);
    Object localObject = this.rdD;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      int k = this.rdE;
      localObject = this.rdF;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(201424);
      return (i * 31 + k) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201423);
    String str = "FlowScrollEventFeedData(feed=" + this.rdD + ", dataPos=" + this.rdE + ", showInfo=" + this.rdF + ")";
    AppMethodBeat.o(201423);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.g
 * JD-Core Version:    0.7.0.1
 */