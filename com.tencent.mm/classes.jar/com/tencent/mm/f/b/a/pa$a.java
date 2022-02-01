package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pa$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43552);
    hdZ = new a("release", 0, 1);
    hea = new a("debug", 1, 2);
    heb = new a("demo", 2, 3);
    hec = new a[] { hdZ, hea, heb };
    AppMethodBeat.o(43552);
  }
  
  private pa$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hdZ;
    case 2: 
      return hea;
    }
    return heb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pa.a
 * JD-Core Version:    0.7.0.1
 */