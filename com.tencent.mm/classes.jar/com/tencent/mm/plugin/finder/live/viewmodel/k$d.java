package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$NetSpeedTestResult;", "", "testResult", "", "avgSpeed", "(II)V", "getAvgSpeed", "()I", "setAvgSpeed", "(I)V", "getTestResult", "setTestResult", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k$d
{
  int DZs = -1;
  int DZt = 0;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
      if (this.DZs != paramObject.DZs) {
        return false;
      }
    } while (this.DZt == paramObject.DZt);
    return false;
  }
  
  public final int hashCode()
  {
    return this.DZs * 31 + this.DZt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356254);
    String str = "NetSpeedTestResult(testResult=" + this.DZs + ", avgSpeed=" + this.DZt + ')';
    AppMethodBeat.o(356254);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.k.d
 * JD-Core Version:    0.7.0.1
 */