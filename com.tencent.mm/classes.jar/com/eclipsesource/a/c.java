package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  extends h
{
  private final boolean aJd;
  private final boolean aJe;
  private final boolean aJf;
  private final String value;
  
  c(String paramString)
  {
    AppMethodBeat.i(74705);
    this.value = paramString;
    this.aJd = "null".equals(paramString);
    this.aJe = "true".equals(paramString);
    this.aJf = "false".equals(paramString);
    AppMethodBeat.o(74705);
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74706);
    parami.bi(this.value);
    AppMethodBeat.o(74706);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(74709);
    if (this == paramObject)
    {
      AppMethodBeat.o(74709);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(74709);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(74709);
      return false;
    }
    paramObject = (c)paramObject;
    boolean bool = this.value.equals(paramObject.value);
    AppMethodBeat.o(74709);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(74707);
    int i = this.value.hashCode();
    AppMethodBeat.o(74707);
    return i;
  }
  
  public final boolean isBoolean()
  {
    return (this.aJe) || (this.aJf);
  }
  
  public final boolean pS()
  {
    AppMethodBeat.i(74708);
    if (this.aJd)
    {
      bool = super.pS();
      AppMethodBeat.o(74708);
      return bool;
    }
    boolean bool = this.aJe;
    AppMethodBeat.o(74708);
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