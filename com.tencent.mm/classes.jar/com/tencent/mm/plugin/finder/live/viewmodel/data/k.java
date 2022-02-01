package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveSubtitle;", "", "subtitle", "", "index", "", "duration", "(Ljava/lang/String;II)V", "getDuration", "()I", "setDuration", "(I)V", "getIndex", "setIndex", "getSubtitle", "()Ljava/lang/String;", "setSubtitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-base_release"})
public final class k
{
  public int duration;
  public int index;
  public String subtitle;
  
  public k(String paramString, int paramInt1, int paramInt2)
  {
    this.subtitle = paramString;
    this.index = paramInt1;
    this.duration = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(258984);
    if (this != paramObject)
    {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if ((!p.h(this.subtitle, paramObject.subtitle)) || (this.index != paramObject.index) || (this.duration != paramObject.duration)) {}
      }
    }
    else
    {
      AppMethodBeat.o(258984);
      return true;
    }
    AppMethodBeat.o(258984);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(258982);
    String str = this.subtitle;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int j = this.index;
      int k = this.duration;
      AppMethodBeat.o(258982);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258980);
    String str = "subtitle:" + this.subtitle + ",index:" + this.index + ",duration:" + this.duration;
    AppMethodBeat.o(258980);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.k
 * JD-Core Version:    0.7.0.1
 */