package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
  extends h
{
  private final String string;
  
  d(String paramString)
  {
    AppMethodBeat.i(74710);
    if (paramString == null)
    {
      paramString = new NullPointerException("string is null");
      AppMethodBeat.o(74710);
      throw paramString;
    }
    this.string = paramString;
    AppMethodBeat.o(74710);
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74711);
    parami.aY(this.string);
    AppMethodBeat.o(74711);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(74716);
    if (this == paramObject)
    {
      AppMethodBeat.o(74716);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(74716);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(74716);
      return false;
    }
    paramObject = (d)paramObject;
    boolean bool = this.string.equals(paramObject.string);
    AppMethodBeat.o(74716);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(74715);
    int i = this.string.hashCode();
    AppMethodBeat.o(74715);
    return i;
  }
  
  public final boolean isNumber()
  {
    return true;
  }
  
  public final int sc()
  {
    AppMethodBeat.i(74712);
    int i = Integer.parseInt(this.string, 10);
    AppMethodBeat.o(74712);
    return i;
  }
  
  public final long sd()
  {
    AppMethodBeat.i(74713);
    long l = Long.parseLong(this.string, 10);
    AppMethodBeat.o(74713);
    return l;
  }
  
  public final double se()
  {
    AppMethodBeat.i(74714);
    double d = Double.parseDouble(this.string);
    AppMethodBeat.o(74714);
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