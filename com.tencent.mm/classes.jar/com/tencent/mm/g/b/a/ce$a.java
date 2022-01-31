package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ce$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128678);
    daH = new a("release", 0, 1);
    daI = new a("debug", 1, 2);
    daJ = new a("demo", 2, 3);
    daK = new a[] { daH, daI, daJ };
    AppMethodBeat.o(128678);
  }
  
  private ce$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return daH;
    case 2: 
      return daI;
    }
    return daJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ce.a
 * JD-Core Version:    0.7.0.1
 */