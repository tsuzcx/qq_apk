package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sz$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43585);
    jAA = new a("release", 0, 1);
    jAB = new a("debug", 1, 2);
    jAC = new a("demo", 2, 3);
    jAD = new a[] { jAA, jAB, jAC };
    AppMethodBeat.o(43585);
  }
  
  private sz$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jAA;
    case 2: 
      return jAB;
    }
    return jAC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sz.a
 * JD-Core Version:    0.7.0.1
 */