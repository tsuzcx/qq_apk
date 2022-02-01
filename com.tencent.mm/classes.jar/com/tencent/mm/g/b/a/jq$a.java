package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum jq$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(2589);
    eDg = new a("undefined", 0, 0);
    eDh = new a("normal", 1, 1000);
    eDi = new a("plugin", 2, 1001);
    eDj = new a("wxstore", 3, 1002);
    eDk = new a("merchant", 4, 1003);
    eDl = new a("wagame", 5, 1004);
    eDm = new a("gift", 6, 1005);
    eDn = new a[] { eDg, eDh, eDi, eDj, eDk, eDl, eDm };
    AppMethodBeat.o(2589);
  }
  
  private jq$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jV(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return eDg;
    case 1000: 
      return eDh;
    case 1001: 
      return eDi;
    case 1002: 
      return eDj;
    case 1003: 
      return eDk;
    case 1004: 
      return eDl;
    }
    return eDm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jq.a
 * JD-Core Version:    0.7.0.1
 */