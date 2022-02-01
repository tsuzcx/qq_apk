package com.tencent.mm.plugin.finder.preload.tabPreload;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$CacheTime;", "", "lastTime", "", "(J)V", "getLastTime", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$b
{
  private final long mJI;
  
  public g$b(long paramLong)
  {
    this.mJI = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
    } while (this.mJI == paramObject.mJI);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(346210);
    int i = q.a..ExternalSyntheticBackport0.m(this.mJI);
    AppMethodBeat.o(346210);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(346204);
    String str = "CacheTime(lastTime=" + this.mJI + ')';
    AppMethodBeat.o(346204);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.g.b
 * JD-Core Version:    0.7.0.1
 */