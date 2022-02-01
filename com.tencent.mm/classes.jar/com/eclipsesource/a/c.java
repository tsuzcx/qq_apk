package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  extends h
{
  private final boolean cBO;
  private final boolean cBP;
  private final boolean cBQ;
  private final String value;
  
  c(String paramString)
  {
    AppMethodBeat.i(74705);
    this.value = paramString;
    this.cBO = "null".equals(paramString);
    this.cBP = "true".equals(paramString);
    this.cBQ = "false".equals(paramString);
    AppMethodBeat.o(74705);
  }
  
  public final boolean Pd()
  {
    AppMethodBeat.i(74708);
    if (this.cBO)
    {
      bool = super.Pd();
      AppMethodBeat.o(74708);
      return bool;
    }
    boolean bool = this.cBP;
    AppMethodBeat.o(74708);
    return bool;
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74706);
    parami.cv(this.value);
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
    return (this.cBP) || (this.cBQ);
  }
  
  public final String toString()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.eclipsesource.a.c
 * JD-Core Version:    0.7.0.1
 */