package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "", "start", "", "count", "topic", "", "(IILjava/lang/String;)V", "getCount", "()I", "getStart", "getTopic", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class o$c
{
  public final int count;
  public final String dBe;
  public final int start;
  
  public o$c(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(167912);
    this.start = paramInt1;
    this.count = paramInt2;
    this.dBe = paramString;
    AppMethodBeat.o(167912);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(167915);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.start != paramObject.start) || (this.count != paramObject.count) || (!p.i(this.dBe, paramObject.dBe))) {}
      }
    }
    else
    {
      AppMethodBeat.o(167915);
      return true;
    }
    AppMethodBeat.o(167915);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(167914);
    int j = this.start;
    int k = this.count;
    String str = this.dBe;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(167914);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167913);
    String str = "TopicStringInfo(start=" + this.start + ", count=" + this.count + ", topic=" + this.dBe + ")";
    AppMethodBeat.o(167913);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.o.c
 * JD-Core Version:    0.7.0.1
 */