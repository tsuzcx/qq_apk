package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.view.recyclerview.f;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataPos", "", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ILcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getDataPos", "()I", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class k
{
  public final int KMi;
  public f KMj;
  public final BaseFinderFeed qHv;
  
  private k(BaseFinderFeed paramBaseFinderFeed, int paramInt)
  {
    AppMethodBeat.i(197541);
    this.qHv = paramBaseFinderFeed;
    this.KMi = paramInt;
    this.KMj = null;
    AppMethodBeat.o(197541);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197544);
    if (this != paramObject)
    {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if ((!d.g.b.k.g(this.qHv, paramObject.qHv)) || (this.KMi != paramObject.KMi) || (!d.g.b.k.g(this.KMj, paramObject.KMj))) {}
      }
    }
    else
    {
      AppMethodBeat.o(197544);
      return true;
    }
    AppMethodBeat.o(197544);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(197543);
    Object localObject = this.qHv;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      int k = this.KMi;
      localObject = this.KMj;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(197543);
      return (i * 31 + k) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197542);
    String str = "FlowScrollEventFeedData(feed=" + this.qHv + ", dataPos=" + this.KMi + ", showInfo=" + this.KMj + ")";
    AppMethodBeat.o(197542);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.k
 * JD-Core Version:    0.7.0.1
 */