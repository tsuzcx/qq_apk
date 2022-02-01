package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/render/FilterConfig;", "", "filterKey", "", "filterPath", "", "filterValue", "(ILjava/lang/String;I)V", "getFilterKey", "()I", "setFilterKey", "(I)V", "getFilterPath", "()Ljava/lang/String;", "setFilterPath", "(Ljava/lang/String;)V", "getFilterValue", "setFilterValue", "component1", "component2", "component3", "copy", "enableFilter", "", "equals", "other", "hashCode", "toString", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public int mUX;
  public String mUY;
  public int mUZ;
  
  public b(int paramInt1, String paramString, int paramInt2)
  {
    this.mUX = paramInt1;
    this.mUY = paramString;
    this.mUZ = paramInt2;
  }
  
  public final boolean bgu()
  {
    AppMethodBeat.i(247710);
    if ((this.mUZ >= 0) && (y.ZC(this.mUY)))
    {
      AppMethodBeat.o(247710);
      return true;
    }
    AppMethodBeat.o(247710);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247738);
    if (this == paramObject)
    {
      AppMethodBeat.o(247738);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(247738);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.mUX != paramObject.mUX)
    {
      AppMethodBeat.o(247738);
      return false;
    }
    if (!s.p(this.mUY, paramObject.mUY))
    {
      AppMethodBeat.o(247738);
      return false;
    }
    if (this.mUZ != paramObject.mUZ)
    {
      AppMethodBeat.o(247738);
      return false;
    }
    AppMethodBeat.o(247738);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(247730);
    int j = this.mUX;
    if (this.mUY == null) {}
    for (int i = 0;; i = this.mUY.hashCode())
    {
      int k = this.mUZ;
      AppMethodBeat.o(247730);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247720);
    String str = "FilterConfig(filterKey=" + this.mUX + ", filterPath=" + this.mUY + ", filterValue=" + this.mUZ + ')';
    AppMethodBeat.o(247720);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.b
 * JD-Core Version:    0.7.0.1
 */