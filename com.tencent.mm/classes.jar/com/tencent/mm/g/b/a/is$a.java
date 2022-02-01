package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum is$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(160517);
    exJ = new a("release", 0, 1);
    exK = new a("debug", 1, 2);
    exL = new a("demo", 2, 3);
    exM = new a[] { exJ, exK, exL };
    AppMethodBeat.o(160517);
  }
  
  private is$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jx(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return exJ;
    case 2: 
      return exK;
    }
    return exL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.is.a
 * JD-Core Version:    0.7.0.1
 */