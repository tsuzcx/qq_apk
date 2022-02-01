package com.tencent.mm.plugin.finder.live.view.adapter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$FinderLiveWhiteListGroupData;", "", "type", "", "selectedInfo", "", "(ILjava/lang/String;)V", "getSelectedInfo", "()Ljava/lang/String;", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveWhiteListGroupAdapter$b
{
  final String DTZ;
  final int type;
  
  public FinderLiveWhiteListGroupAdapter$b(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.DTZ = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(358676);
    if (this == paramObject)
    {
      AppMethodBeat.o(358676);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(358676);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(358676);
      return false;
    }
    if (!s.p(this.DTZ, paramObject.DTZ))
    {
      AppMethodBeat.o(358676);
      return false;
    }
    AppMethodBeat.o(358676);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(358666);
    int j = this.type;
    if (this.DTZ == null) {}
    for (int i = 0;; i = this.DTZ.hashCode())
    {
      AppMethodBeat.o(358666);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(358657);
    String str = "FinderLiveWhiteListGroupData(type=" + this.type + ", selectedInfo=" + this.DTZ + ')';
    AppMethodBeat.o(358657);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter.b
 * JD-Core Version:    0.7.0.1
 */