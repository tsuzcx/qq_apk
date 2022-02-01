package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pf$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43577);
    heE = new a("release", 0, 1);
    heF = new a("debug", 1, 2);
    heG = new a("demo", 2, 3);
    heH = new a[] { heE, heF, heG };
    AppMethodBeat.o(43577);
  }
  
  private pf$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return heE;
    case 2: 
      return heF;
    }
    return heG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pf.a
 * JD-Core Version:    0.7.0.1
 */