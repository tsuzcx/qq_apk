package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum no$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(2589);
    fhE = new a("undefined", 0, 0);
    fhF = new a("normal", 1, 1000);
    fhG = new a("plugin", 2, 1001);
    fhH = new a("wxstore", 3, 1002);
    fhI = new a("merchant", 4, 1003);
    fhJ = new a("wagame", 5, 1004);
    fhK = new a("gift", 6, 1005);
    fhL = new a[] { fhE, fhF, fhG, fhH, fhI, fhJ, fhK };
    AppMethodBeat.o(2589);
  }
  
  private no$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a mX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return fhE;
    case 1000: 
      return fhF;
    case 1001: 
      return fhG;
    case 1002: 
      return fhH;
    case 1003: 
      return fhI;
    case 1004: 
      return fhJ;
    }
    return fhK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.no.a
 * JD-Core Version:    0.7.0.1
 */