package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
  extends h
{
  private final String string;
  
  d(String paramString)
  {
    AppMethodBeat.i(70523);
    if (paramString == null)
    {
      paramString = new NullPointerException("string is null");
      AppMethodBeat.o(70523);
      throw paramString;
    }
    this.string = paramString;
    AppMethodBeat.o(70523);
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(70524);
    parami.ah(this.string);
    AppMethodBeat.o(70524);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70529);
    if (this == paramObject)
    {
      AppMethodBeat.o(70529);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(70529);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(70529);
      return false;
    }
    paramObject = (d)paramObject;
    boolean bool = this.string.equals(paramObject.string);
    AppMethodBeat.o(70529);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(70528);
    int i = this.string.hashCode();
    AppMethodBeat.o(70528);
    return i;
  }
  
  public final boolean isNumber()
  {
    return true;
  }
  
  public final int lJ()
  {
    AppMethodBeat.i(70525);
    int i = Integer.parseInt(this.string, 10);
    AppMethodBeat.o(70525);
    return i;
  }
  
  public final long lK()
  {
    AppMethodBeat.i(70526);
    long l = Long.parseLong(this.string, 10);
    AppMethodBeat.o(70526);
    return l;
  }
  
  public final double lL()
  {
    AppMethodBeat.i(70527);
    double d = Double.parseDouble(this.string);
    AppMethodBeat.o(70527);
    return d;
  }
  
  public final String toString()
  {
    return this.string;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.d
 * JD-Core Version:    0.7.0.1
 */