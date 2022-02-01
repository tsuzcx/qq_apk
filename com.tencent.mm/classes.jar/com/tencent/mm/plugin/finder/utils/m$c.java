package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "", "start", "", "count", "topic", "", "(IILjava/lang/String;)V", "getCount", "()I", "getStart", "getTopic", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class m$c
{
  public final int count;
  public final String dol;
  public final int start;
  
  public m$c(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(167912);
    this.start = paramInt1;
    this.count = paramInt2;
    this.dol = paramString;
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
        if ((this.start != paramObject.start) || (this.count != paramObject.count) || (!k.g(this.dol, paramObject.dol))) {}
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
    String str = this.dol;
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
    String str = "TopicStringInfo(start=" + this.start + ", count=" + this.count + ", topic=" + this.dol + ")";
    AppMethodBeat.o(167913);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m.c
 * JD-Core Version:    0.7.0.1
 */