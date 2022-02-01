package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;", "", "key", "", "(I)V", "getKey", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class FinderLivePostUIC$d
{
  final int key;
  
  public FinderLivePostUIC$d(int paramInt)
  {
    this.key = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if (this.key != paramObject.key) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.key;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247895);
    String str = "OptionInfo(key=" + this.key + ")";
    AppMethodBeat.o(247895);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC.d
 * JD-Core Version:    0.7.0.1
 */