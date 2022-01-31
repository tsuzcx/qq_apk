package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class g
  extends h
{
  private final String string;
  
  g(String paramString)
  {
    AppMethodBeat.i(70580);
    if (paramString == null)
    {
      paramString = new NullPointerException("string is null");
      AppMethodBeat.o(70580);
      throw paramString;
    }
    this.string = paramString;
    AppMethodBeat.o(70580);
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(70581);
    parami.writeString(this.string);
    AppMethodBeat.o(70581);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70583);
    if (this == paramObject)
    {
      AppMethodBeat.o(70583);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(70583);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(70583);
      return false;
    }
    paramObject = (g)paramObject;
    boolean bool = this.string.equals(paramObject.string);
    AppMethodBeat.o(70583);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(70582);
    int i = this.string.hashCode();
    AppMethodBeat.o(70582);
    return i;
  }
  
  public final boolean isString()
  {
    return true;
  }
  
  public final String mk()
  {
    return this.string;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.a.g
 * JD-Core Version:    0.7.0.1
 */