package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  extends h
{
  private final boolean atS;
  private final boolean atT;
  private final boolean atU;
  private final String value;
  
  c(String paramString)
  {
    AppMethodBeat.i(70518);
    this.value = paramString;
    this.atS = "null".equals(paramString);
    this.atT = "true".equals(paramString);
    this.atU = "false".equals(paramString);
    AppMethodBeat.o(70518);
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(70519);
    parami.ag(this.value);
    AppMethodBeat.o(70519);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70522);
    if (this == paramObject)
    {
      AppMethodBeat.o(70522);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(70522);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(70522);
      return false;
    }
    paramObject = (c)paramObject;
    boolean bool = this.value.equals(paramObject.value);
    AppMethodBeat.o(70522);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(70520);
    int i = this.value.hashCode();
    AppMethodBeat.o(70520);
    return i;
  }
  
  public final boolean isBoolean()
  {
    return (this.atT) || (this.atU);
  }
  
  public final boolean lI()
  {
    AppMethodBeat.i(70521);
    if (this.atS)
    {
      bool = super.lI();
      AppMethodBeat.o(70521);
      return bool;
    }
    boolean bool = this.atT;
    AppMethodBeat.o(70521);
    return bool;
  }
  
  public final String toString()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.a.c
 * JD-Core Version:    0.7.0.1
 */