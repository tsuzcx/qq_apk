package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$b
{
  private final h aub;
  private final String name;
  
  e$b(String paramString, h paramh)
  {
    this.name = paramString;
    this.aub = paramh;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70538);
    if (this == paramObject)
    {
      AppMethodBeat.o(70538);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(70538);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(70538);
      return false;
    }
    paramObject = (b)paramObject;
    if ((this.name.equals(paramObject.name)) && (this.aub.equals(paramObject.aub)))
    {
      AppMethodBeat.o(70538);
      return true;
    }
    AppMethodBeat.o(70538);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(70537);
    int i = this.name.hashCode();
    int j = this.aub.hashCode();
    AppMethodBeat.o(70537);
    return (i + 31) * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.a.e.b
 * JD-Core Version:    0.7.0.1
 */