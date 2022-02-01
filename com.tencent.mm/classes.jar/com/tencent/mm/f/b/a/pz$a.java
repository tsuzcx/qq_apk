package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pz$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43744);
    hiV = new a("release", 0, 1);
    hiW = new a("debug", 1, 2);
    hiX = new a("demo", 2, 3);
    hiY = new a[] { hiV, hiW, hiX };
    AppMethodBeat.o(43744);
  }
  
  private pz$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hiV;
    case 2: 
      return hiW;
    }
    return hiX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pz.a
 * JD-Core Version:    0.7.0.1
 */