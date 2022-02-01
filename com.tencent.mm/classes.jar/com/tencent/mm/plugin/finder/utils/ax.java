package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "", "start", "", "count", "topic", "", "(IILjava/lang/String;)V", "getCount", "()I", "getStart", "getTopic", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-base_release"})
public final class ax
{
  public final int count;
  public final int start;
  public final String topic;
  
  public ax(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(263125);
    this.start = paramInt1;
    this.count = paramInt2;
    this.topic = paramString;
    AppMethodBeat.o(263125);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(263128);
    if (this != paramObject)
    {
      if ((paramObject instanceof ax))
      {
        paramObject = (ax)paramObject;
        if ((this.start != paramObject.start) || (this.count != paramObject.count) || (!p.h(this.topic, paramObject.topic))) {}
      }
    }
    else
    {
      AppMethodBeat.o(263128);
      return true;
    }
    AppMethodBeat.o(263128);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(263127);
    int j = this.start;
    int k = this.count;
    String str = this.topic;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(263127);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(263126);
    String str = "TopicStringInfo(start=" + this.start + ", count=" + this.count + ", topic=" + this.topic + ")";
    AppMethodBeat.o(263126);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ax
 * JD-Core Version:    0.7.0.1
 */