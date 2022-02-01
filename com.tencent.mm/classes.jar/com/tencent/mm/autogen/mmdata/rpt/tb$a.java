package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum tb$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43603);
    jAR = new a("release", 0, 1);
    jAS = new a("debug", 1, 2);
    jAT = new a("demo", 2, 3);
    jAU = new a[] { jAR, jAS, jAT };
    AppMethodBeat.o(43603);
  }
  
  private tb$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jAR;
    case 2: 
      return jAS;
    }
    return jAT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tb.a
 * JD-Core Version:    0.7.0.1
 */