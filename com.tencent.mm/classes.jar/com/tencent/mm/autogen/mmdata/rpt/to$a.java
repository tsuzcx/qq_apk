package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum to$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43704);
    jDV = new a("release", 0, 1);
    jDW = new a("debug", 1, 2);
    jDX = new a("demo", 2, 3);
    jDY = new a[] { jDV, jDW, jDX };
    AppMethodBeat.o(43704);
  }
  
  private to$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a pf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jDV;
    case 2: 
      return jDW;
    }
    return jDX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.to.a
 * JD-Core Version:    0.7.0.1
 */