package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum py$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43733);
    hiQ = new a("release", 0, 1);
    hiR = new a("debug", 1, 2);
    hiS = new a("demo", 2, 3);
    hiT = new a[] { hiQ, hiR, hiS };
    AppMethodBeat.o(43733);
  }
  
  private py$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oW(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hiQ;
    case 2: 
      return hiR;
    }
    return hiS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.py.a
 * JD-Core Version:    0.7.0.1
 */