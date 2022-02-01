package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/FilterConfig;", "", "filterKey", "", "filterPath", "", "filterValue", "(ILjava/lang/String;I)V", "getFilterKey", "()I", "setFilterKey", "(I)V", "getFilterPath", "()Ljava/lang/String;", "setFilterPath", "(Ljava/lang/String;)V", "getFilterValue", "setFilterValue", "component1", "component2", "component3", "copy", "enableFilter", "", "equals", "other", "hashCode", "toString", "plugin-core_release"})
public final class b
{
  public int krb;
  public String krc;
  public int krd;
  
  public b(int paramInt1, String paramString, int paramInt2)
  {
    this.krb = paramInt1;
    this.krc = paramString;
    this.krd = paramInt2;
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(199020);
    if ((this.krd >= 0) && (u.agG(this.krc)))
    {
      AppMethodBeat.o(199020);
      return true;
    }
    AppMethodBeat.o(199020);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199026);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.krb != paramObject.krb) || (!p.h(this.krc, paramObject.krc)) || (this.krd != paramObject.krd)) {}
      }
    }
    else
    {
      AppMethodBeat.o(199026);
      return true;
    }
    AppMethodBeat.o(199026);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(199024);
    int j = this.krb;
    String str = this.krc;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int k = this.krd;
      AppMethodBeat.o(199024);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199023);
    String str = "FilterConfig(filterKey=" + this.krb + ", filterPath=" + this.krc + ", filterValue=" + this.krd + ")";
    AppMethodBeat.o(199023);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.b
 * JD-Core Version:    0.7.0.1
 */