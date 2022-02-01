package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pw$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43711);
    hiw = new a("release", 0, 1);
    hix = new a("debug", 1, 2);
    hiy = new a("demo", 2, 3);
    hiz = new a[] { hiw, hix, hiy };
    AppMethodBeat.o(43711);
  }
  
  private pw$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hiw;
    case 2: 
      return hix;
    }
    return hiy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pw.a
 * JD-Core Version:    0.7.0.1
 */