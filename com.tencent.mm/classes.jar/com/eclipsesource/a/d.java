package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
  extends h
{
  private final String cBR;
  
  d(String paramString)
  {
    AppMethodBeat.i(74710);
    if (paramString == null)
    {
      paramString = new NullPointerException("string is null");
      AppMethodBeat.o(74710);
      throw paramString;
    }
    this.cBR = paramString;
    AppMethodBeat.o(74710);
  }
  
  public final int Pe()
  {
    AppMethodBeat.i(74712);
    int i = Integer.parseInt(this.cBR, 10);
    AppMethodBeat.o(74712);
    return i;
  }
  
  public final long Pf()
  {
    AppMethodBeat.i(74713);
    long l = Long.parseLong(this.cBR, 10);
    AppMethodBeat.o(74713);
    return l;
  }
  
  public final double Pg()
  {
    AppMethodBeat.i(74714);
    double d = Double.parseDouble(this.cBR);
    AppMethodBeat.o(74714);
    return d;
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74711);
    parami.cw(this.cBR);
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
    boolean bool = this.cBR.equals(paramObject.cBR);
    AppMethodBeat.o(74716);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(74715);
    int i = this.cBR.hashCode();
    AppMethodBeat.o(74715);
    return i;
  }
  
  public final boolean isNumber()
  {
    return true;
  }
  
  public final String toString()
  {
    return this.cBR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.eclipsesource.a.d
 * JD-Core Version:    0.7.0.1
 */