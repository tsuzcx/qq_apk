package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class g
  extends h
{
  private final String string;
  
  g(String paramString)
  {
    AppMethodBeat.i(74767);
    if (paramString == null)
    {
      paramString = new NullPointerException("string is null");
      AppMethodBeat.o(74767);
      throw paramString;
    }
    this.string = paramString;
    AppMethodBeat.o(74767);
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74768);
    parami.writeString(this.string);
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
    boolean bool = this.string.equals(paramObject.string);
    AppMethodBeat.o(74770);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(74769);
    int i = this.string.hashCode();
    AppMethodBeat.o(74769);
    return i;
  }
  
  public final boolean isString()
  {
    return true;
  }
  
  public final String sD()
  {
    return this.string;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.a.g
 * JD-Core Version:    0.7.0.1
 */