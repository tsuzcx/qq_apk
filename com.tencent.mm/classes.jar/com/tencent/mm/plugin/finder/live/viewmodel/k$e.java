package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;", "", "key", "", "(I)V", "getKey", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k$e
{
  final int key;
  
  public k$e(int paramInt)
  {
    this.key = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
    } while (this.key == paramObject.key);
    return false;
  }
  
  public final int hashCode()
  {
    return this.key;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356304);
    String str = "OptionInfo(key=" + this.key + ')';
    AppMethodBeat.o(356304);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.k.e
 * JD-Core Version:    0.7.0.1
 */