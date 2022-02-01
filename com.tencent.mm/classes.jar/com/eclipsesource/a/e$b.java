package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$b
{
  private final h cBY;
  private final String name;
  
  e$b(String paramString, h paramh)
  {
    this.name = paramString;
    this.cBY = paramh;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(74725);
    if (this == paramObject)
    {
      AppMethodBeat.o(74725);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(74725);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(74725);
      return false;
    }
    paramObject = (b)paramObject;
    if ((this.name.equals(paramObject.name)) && (this.cBY.equals(paramObject.cBY)))
    {
      AppMethodBeat.o(74725);
      return true;
    }
    AppMethodBeat.o(74725);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(74724);
    int i = this.name.hashCode();
    int j = this.cBY.hashCode();
    AppMethodBeat.o(74724);
    return (i + 31) * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.a.e.b
 * JD-Core Version:    0.7.0.1
 */