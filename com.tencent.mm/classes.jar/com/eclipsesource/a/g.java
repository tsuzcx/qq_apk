package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class g
  extends h
{
  private final String cBR;
  
  g(String paramString)
  {
    AppMethodBeat.i(74767);
    if (paramString == null)
    {
      paramString = new NullPointerException("string is null");
      AppMethodBeat.o(74767);
      throw paramString;
    }
    this.cBR = paramString;
    AppMethodBeat.o(74767);
  }
  
  public final String PF()
  {
    return this.cBR;
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74768);
    parami.aU(this.cBR);
    AppMethodBeat.o(74768);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(74770);
    if (this == paramObject)
    {
      AppMethodBeat.o(74770);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(74770);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(74770);
      return false;
    }
    paramObject = (g)paramObject;
    boolean bool = this.cBR.equals(paramObject.cBR);
    AppMethodBeat.o(74770);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(74769);
    int i = this.cBR.hashCode();
    AppMethodBeat.o(74769);
    return i;
  }
  
  public final boolean isString()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.eclipsesource.a.g
 * JD-Core Version:    0.7.0.1
 */