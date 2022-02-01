package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/PluginFinderLive$RequestAndRefreshActivityIconResult;", "", "interval", "", "actType", "(II)V", "getActType", "()I", "getInterval", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinderLive$b
{
  final int Bye;
  final int interval;
  
  public PluginFinderLive$b(int paramInt1, int paramInt2)
  {
    this.interval = paramInt1;
    this.Bye = paramInt2;
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
      if (this.interval != paramObject.interval) {
        return false;
      }
    } while (this.Bye == paramObject.Bye);
    return false;
  }
  
  public final int hashCode()
  {
    return this.interval * 31 + this.Bye;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(350816);
    String str = "RequestAndRefreshActivityIconResult(interval=" + this.interval + ", actType=" + this.Bye + ')';
    AppMethodBeat.o(350816);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.PluginFinderLive.b
 * JD-Core Version:    0.7.0.1
 */