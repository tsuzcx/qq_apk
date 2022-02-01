package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "", "start", "", "count", "topic", "", "(IILjava/lang/String;)V", "getCount", "()I", "getStart", "getTopic", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bo
{
  public final int count;
  public final int start;
  public final String topic;
  
  public bo(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(333127);
    this.start = paramInt1;
    this.count = paramInt2;
    this.topic = paramString;
    AppMethodBeat.o(333127);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(333159);
    if (this == paramObject)
    {
      AppMethodBeat.o(333159);
      return true;
    }
    if (!(paramObject instanceof bo))
    {
      AppMethodBeat.o(333159);
      return false;
    }
    paramObject = (bo)paramObject;
    if (this.start != paramObject.start)
    {
      AppMethodBeat.o(333159);
      return false;
    }
    if (this.count != paramObject.count)
    {
      AppMethodBeat.o(333159);
      return false;
    }
    if (!s.p(this.topic, paramObject.topic))
    {
      AppMethodBeat.o(333159);
      return false;
    }
    AppMethodBeat.o(333159);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(333145);
    int i = this.start;
    int j = this.count;
    int k = this.topic.hashCode();
    AppMethodBeat.o(333145);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(333138);
    String str = "TopicStringInfo(start=" + this.start + ", count=" + this.count + ", topic=" + this.topic + ')';
    AppMethodBeat.o(333138);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bo
 * JD-Core Version:    0.7.0.1
 */