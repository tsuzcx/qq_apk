package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sk$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43488);
    jyy = new b("undefined", 0, 0);
    jyz = new b("normal", 1, 1000);
    jyA = new b("plugin", 2, 1001);
    jyB = new b("wxstore", 3, 1002);
    jyC = new b("merchant", 4, 1003);
    jyD = new b("wagame", 5, 1004);
    jyE = new b("gift", 6, 1005);
    jyF = new b[] { jyy, jyz, jyA, jyB, jyC, jyD, jyE };
    AppMethodBeat.o(43488);
  }
  
  private sk$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static b oG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return jyy;
    case 1000: 
      return jyz;
    case 1001: 
      return jyA;
    case 1002: 
      return jyB;
    case 1003: 
      return jyC;
    case 1004: 
      return jyD;
    }
    return jyE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sk.b
 * JD-Core Version:    0.7.0.1
 */