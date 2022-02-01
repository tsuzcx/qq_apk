package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum or$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43488);
    hcK = new b("undefined", 0, 0);
    hcL = new b("normal", 1, 1000);
    hcM = new b("plugin", 2, 1001);
    hcN = new b("wxstore", 3, 1002);
    hcO = new b("merchant", 4, 1003);
    hcP = new b("wagame", 5, 1004);
    hcQ = new b("gift", 6, 1005);
    hcR = new b[] { hcK, hcL, hcM, hcN, hcO, hcP, hcQ };
    AppMethodBeat.o(43488);
  }
  
  private or$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static b oq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return hcK;
    case 1000: 
      return hcL;
    case 1001: 
      return hcM;
    case 1002: 
      return hcN;
    case 1003: 
      return hcO;
    case 1004: 
      return hcP;
    }
    return hcQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.or.b
 * JD-Core Version:    0.7.0.1
 */