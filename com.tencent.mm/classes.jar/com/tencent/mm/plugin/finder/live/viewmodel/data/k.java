package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveSubtitle;", "", "subtitle", "", "index", "", "duration", "(Ljava/lang/String;II)V", "getDuration", "()I", "setDuration", "(I)V", "getIndex", "setIndex", "getSubtitle", "()Ljava/lang/String;", "setSubtitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public int duration;
  public String igN;
  public int index;
  
  public k(String paramString, int paramInt1, int paramInt2)
  {
    this.igN = paramString;
    this.index = paramInt1;
    this.duration = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356851);
    if (this == paramObject)
    {
      AppMethodBeat.o(356851);
      return true;
    }
    if (!(paramObject instanceof k))
    {
      AppMethodBeat.o(356851);
      return false;
    }
    paramObject = (k)paramObject;
    if (!s.p(this.igN, paramObject.igN))
    {
      AppMethodBeat.o(356851);
      return false;
    }
    if (this.index != paramObject.index)
    {
      AppMethodBeat.o(356851);
      return false;
    }
    if (this.duration != paramObject.duration)
    {
      AppMethodBeat.o(356851);
      return false;
    }
    AppMethodBeat.o(356851);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(356845);
    if (this.igN == null) {}
    for (int i = 0;; i = this.igN.hashCode())
    {
      int j = this.index;
      int k = this.duration;
      AppMethodBeat.o(356845);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356835);
    String str = "subtitle:" + this.igN + ",index:" + this.index + ",duration:" + this.duration;
    AppMethodBeat.o(356835);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.k
 * JD-Core Version:    0.7.0.1
 */