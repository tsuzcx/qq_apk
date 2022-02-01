package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum hw$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43488);
    etR = new b("undefined", 0, 0);
    etS = new b("normal", 1, 1000);
    etT = new b("plugin", 2, 1001);
    etU = new b("wxstore", 3, 1002);
    etV = new b("merchant", 4, 1003);
    etW = new b("wagame", 5, 1004);
    etX = new b("gift", 6, 1005);
    etY = new b[] { etR, etS, etT, etU, etV, etW, etX };
    AppMethodBeat.o(43488);
  }
  
  private hw$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static b jb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return etR;
    case 1000: 
      return etS;
    case 1001: 
      return etT;
    case 1002: 
      return etU;
    case 1003: 
      return etV;
    case 1004: 
      return etW;
    }
    return etX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hw.b
 * JD-Core Version:    0.7.0.1
 */