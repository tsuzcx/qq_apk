package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum qo$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(2589);
    hkP = new a("undefined", 0, 0);
    hkQ = new a("normal", 1, 1000);
    hkR = new a("plugin", 2, 1001);
    hkS = new a("wxstore", 3, 1002);
    hkT = new a("merchant", 4, 1003);
    hkU = new a("wagame", 5, 1004);
    hkV = new a("gift", 6, 1005);
    hkW = new a[] { hkP, hkQ, hkR, hkS, hkT, hkU, hkV };
    AppMethodBeat.o(2589);
  }
  
  private qo$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a pj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return hkP;
    case 1000: 
      return hkQ;
    case 1001: 
      return hkR;
    case 1002: 
      return hkS;
    case 1003: 
      return hkT;
    case 1004: 
      return hkU;
    }
    return hkV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qo.a
 * JD-Core Version:    0.7.0.1
 */