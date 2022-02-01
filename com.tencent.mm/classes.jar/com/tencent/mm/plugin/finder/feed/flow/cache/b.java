package com.tencent.mm.plugin.finder.feed.flow.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b Bdn;
  public int Bdl = 0;
  public int Bdm = -1;
  public int bUo = 0;
  public int maxHeight = 0;
  
  static
  {
    AppMethodBeat.i(363584);
    Bdn = new b();
    AppMethodBeat.o(363584);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(363591);
    if (this == paramObject)
    {
      AppMethodBeat.o(363591);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(363591);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.bUo != paramObject.bUo)
    {
      AppMethodBeat.o(363591);
      return false;
    }
    if (this.Bdl != paramObject.Bdl)
    {
      AppMethodBeat.o(363591);
      return false;
    }
    if (this.maxHeight != paramObject.maxHeight)
    {
      AppMethodBeat.o(363591);
      return false;
    }
    if (this.Bdm == paramObject.Bdm)
    {
      AppMethodBeat.o(363591);
      return true;
    }
    AppMethodBeat.o(363591);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.bUo * 31 + this.Bdl) * 31 + this.maxHeight) * 31 + this.Bdm;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(363599);
    String str = "Line{itemCount=" + this.bUo + ", totalWidth=" + this.Bdl + ", maxHeight=" + this.maxHeight + ", maxHeightIndex=" + this.Bdm + '}';
    AppMethodBeat.o(363599);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.flow.cache.b
 * JD-Core Version:    0.7.0.1
 */