package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ic$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43537);
    euH = new a("release", 0, 1);
    euI = new a("debug", 1, 2);
    euJ = new a("demo", 2, 3);
    euK = new a[] { euH, euI, euJ };
    AppMethodBeat.o(43537);
  }
  
  private ic$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return euH;
    case 2: 
      return euI;
    }
    return euJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ic.a
 * JD-Core Version:    0.7.0.1
 */