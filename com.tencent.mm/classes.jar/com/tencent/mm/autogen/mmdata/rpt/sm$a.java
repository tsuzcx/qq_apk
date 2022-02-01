package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sm$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43503);
    jyR = new a("release", 0, 1);
    jyS = new a("debug", 1, 2);
    jyT = new a("demo", 2, 3);
    jyU = new a[] { jyR, jyS, jyT };
    AppMethodBeat.o(43503);
  }
  
  private sm$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jyR;
    case 2: 
      return jyS;
    }
    return jyT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sm.a
 * JD-Core Version:    0.7.0.1
 */