package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/FilterConfig;", "", "filterKey", "", "filterPath", "", "filterValue", "(ILjava/lang/String;I)V", "getFilterKey", "()I", "setFilterKey", "(I)V", "getFilterPath", "()Ljava/lang/String;", "setFilterPath", "(Ljava/lang/String;)V", "getFilterValue", "setFilterValue", "component1", "component2", "component3", "copy", "enableFilter", "", "equals", "other", "hashCode", "toString", "plugin-core_release"})
public final class b
{
  public int hDi;
  public String hDj;
  public int hDk;
  
  public b(int paramInt1, String paramString, int paramInt2)
  {
    this.hDi = paramInt1;
    this.hDj = paramString;
    this.hDk = paramInt2;
  }
  
  public final boolean aEv()
  {
    AppMethodBeat.i(196612);
    if ((this.hDk >= 0) && (s.YS(this.hDj)))
    {
      AppMethodBeat.o(196612);
      return true;
    }
    AppMethodBeat.o(196612);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196615);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.hDi != paramObject.hDi) || (!p.j(this.hDj, paramObject.hDj)) || (this.hDk != paramObject.hDk)) {}
      }
    }
    else
    {
      AppMethodBeat.o(196615);
      return true;
    }
    AppMethodBeat.o(196615);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(196614);
    int j = this.hDi;
    String str = this.hDj;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int k = this.hDk;
      AppMethodBeat.o(196614);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196613);
    String str = "FilterConfig(filterKey=" + this.hDi + ", filterPath=" + this.hDj + ", filterValue=" + this.hDk + ")";
    AppMethodBeat.o(196613);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.b.b
 * JD-Core Version:    0.7.0.1
 */