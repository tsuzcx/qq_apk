package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum or$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43485);
    hcG = new a("release", 0, 1);
    hcH = new a("debug", 1, 2);
    hcI = new a("test", 2, 3);
    hcJ = new a[] { hcG, hcH, hcI };
    AppMethodBeat.o(43485);
  }
  
  private or$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a op(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hcG;
    case 2: 
      return hcH;
    }
    return hcI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.or.a
 * JD-Core Version:    0.7.0.1
 */