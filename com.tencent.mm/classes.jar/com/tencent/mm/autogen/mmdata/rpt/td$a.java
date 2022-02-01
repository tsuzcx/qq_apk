package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum td$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43613);
    jBa = new a("release", 0, 1);
    jBb = new a("debug", 1, 2);
    jBc = new a("demo", 2, 3);
    jBd = new a[] { jBa, jBb, jBc };
    AppMethodBeat.o(43613);
  }
  
  private td$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jBa;
    case 2: 
      return jBb;
    }
    return jBc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.td.a
 * JD-Core Version:    0.7.0.1
 */