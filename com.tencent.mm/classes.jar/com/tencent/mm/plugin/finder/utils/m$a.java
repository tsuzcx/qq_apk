package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderEnhanceUtils$EventDetail;", "", "listenEventType", "", "playPercent", "(II)V", "getListenEventType", "()I", "getPlayPercent", "stayTimeSecond", "getStayTimeSecond", "setStayTimeSecond", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m$a
{
  public final int Ggr;
  public final int Ggs;
  public int Ggt;
  
  public m$a(int paramInt1, int paramInt2)
  {
    this.Ggr = paramInt1;
    this.Ggs = paramInt2;
    this.Ggt = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.Ggr != paramObject.Ggr) {
        return false;
      }
    } while (this.Ggs == paramObject.Ggs);
    return false;
  }
  
  public final int hashCode()
  {
    return this.Ggr * 31 + this.Ggs;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(333823);
    String str = "EventDetail(listenEventType=" + this.Ggr + ", playPercent=" + this.Ggs + ')';
    AppMethodBeat.o(333823);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m.a
 * JD-Core Version:    0.7.0.1
 */