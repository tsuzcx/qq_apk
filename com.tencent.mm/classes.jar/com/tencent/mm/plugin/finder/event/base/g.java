package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dataPos", "", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;ILcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getDataPos", "()I", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class g
{
  public final bo tIu;
  public final int tIv;
  public i tIw;
  
  private g(bo parambo, int paramInt)
  {
    AppMethodBeat.i(243463);
    this.tIu = parambo;
    this.tIv = paramInt;
    this.tIw = null;
    AppMethodBeat.o(243463);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(243466);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((!p.j(this.tIu, paramObject.tIu)) || (this.tIv != paramObject.tIv) || (!p.j(this.tIw, paramObject.tIw))) {}
      }
    }
    else
    {
      AppMethodBeat.o(243466);
      return true;
    }
    AppMethodBeat.o(243466);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(243465);
    Object localObject = this.tIu;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      int k = this.tIv;
      localObject = this.tIw;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(243465);
      return (i * 31 + k) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(243464);
    String str = "FlowScrollEventFeedData(feed=" + this.tIu + ", dataPos=" + this.tIv + ", showInfo=" + this.tIw + ")";
    AppMethodBeat.o(243464);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.g
 * JD-Core Version:    0.7.0.1
 */