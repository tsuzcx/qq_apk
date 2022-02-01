package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pp$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(160517);
    hgQ = new a("release", 0, 1);
    hgR = new a("debug", 1, 2);
    hgS = new a("demo", 2, 3);
    hgT = new a[] { hgQ, hgR, hgS };
    AppMethodBeat.o(160517);
  }
  
  private pp$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hgQ;
    case 2: 
      return hgR;
    }
    return hgS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pp.a
 * JD-Core Version:    0.7.0.1
 */