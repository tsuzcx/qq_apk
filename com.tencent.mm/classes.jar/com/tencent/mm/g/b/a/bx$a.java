package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum bx$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(155893);
    cZF = new a("release", 0, 1);
    cZG = new a("debug", 1, 2);
    cZH = new a("demo", 2, 3);
    cZI = new a[] { cZF, cZG, cZH };
    AppMethodBeat.o(155893);
  }
  
  private bx$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return cZF;
    case 2: 
      return cZG;
    }
    return cZH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bx.a
 * JD-Core Version:    0.7.0.1
 */