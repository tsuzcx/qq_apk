package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/ScreenDeviceData;", "", "displayName", "", "id", "(Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-base_release"})
public final class n
{
  private final String id;
  public final String jmB;
  
  public n(String paramString1, String paramString2)
  {
    this.jmB = paramString1;
    this.id = paramString2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(260640);
    if (this != paramObject)
    {
      if ((paramObject instanceof n))
      {
        paramObject = (n)paramObject;
        if ((!p.h(this.jmB, paramObject.jmB)) || (!p.h(this.id, paramObject.id))) {}
      }
    }
    else
    {
      AppMethodBeat.o(260640);
      return true;
    }
    AppMethodBeat.o(260640);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(260638);
    String str = this.jmB;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.id;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(260638);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(260637);
    String str = "ScreenDeviceData(displayName=" + this.jmB + ", id=" + this.id + ")";
    AppMethodBeat.o(260637);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.n
 * JD-Core Version:    0.7.0.1
 */