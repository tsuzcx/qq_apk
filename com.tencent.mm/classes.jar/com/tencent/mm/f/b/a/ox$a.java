package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ox$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43537);
    hdB = new a("release", 0, 1);
    hdC = new a("debug", 1, 2);
    hdD = new a("demo", 2, 3);
    hdE = new a[] { hdB, hdC, hdD };
    AppMethodBeat.o(43537);
  }
  
  private ox$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a ow(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hdB;
    case 2: 
      return hdC;
    }
    return hdD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ox.a
 * JD-Core Version:    0.7.0.1
 */