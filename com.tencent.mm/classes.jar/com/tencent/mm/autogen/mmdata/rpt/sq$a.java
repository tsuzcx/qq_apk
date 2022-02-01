package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sq$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43537);
    jzo = new a("release", 0, 1);
    jzp = new a("debug", 1, 2);
    jzq = new a("demo", 2, 3);
    jzr = new a[] { jzo, jzp, jzq };
    AppMethodBeat.o(43537);
  }
  
  private sq$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jzo;
    case 2: 
      return jzp;
    }
    return jzq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sq.a
 * JD-Core Version:    0.7.0.1
 */