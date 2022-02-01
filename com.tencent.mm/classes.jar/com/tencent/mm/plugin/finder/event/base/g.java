package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.view.recyclerview.l;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dataPos", "", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;ILcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "getDataPos", "()I", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public final cc AOm;
  public final int AOn;
  public l AOo;
  
  private g(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(330331);
    this.AOm = paramcc;
    this.AOn = paramInt;
    this.AOo = null;
    AppMethodBeat.o(330331);
  }
  
  public final cc dYK()
  {
    return this.AOm;
  }
  
  public final int dYL()
  {
    return this.AOn;
  }
  
  public final l dYM()
  {
    return this.AOo;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(330399);
    if (this == paramObject)
    {
      AppMethodBeat.o(330399);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(330399);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(this.AOm, paramObject.AOm))
    {
      AppMethodBeat.o(330399);
      return false;
    }
    if (this.AOn != paramObject.AOn)
    {
      AppMethodBeat.o(330399);
      return false;
    }
    if (!s.p(this.AOo, paramObject.AOo))
    {
      AppMethodBeat.o(330399);
      return false;
    }
    AppMethodBeat.o(330399);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(330389);
    int j = this.AOm.hashCode();
    int k = this.AOn;
    if (this.AOo == null) {}
    for (int i = 0;; i = this.AOo.hashCode())
    {
      AppMethodBeat.o(330389);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(330379);
    String str = "FlowScrollEventFeedData(feed=" + this.AOm + ", dataPos=" + this.AOn + ", showInfo=" + this.AOo + ')';
    AppMethodBeat.o(330379);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.g
 * JD-Core Version:    0.7.0.1
 */