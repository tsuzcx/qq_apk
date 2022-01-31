package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cd$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128668);
    daC = new a("release", 0, 1);
    daD = new a("debug", 1, 2);
    daE = new a("demo", 2, 3);
    daF = new a[] { daC, daD, daE };
    AppMethodBeat.o(128668);
  }
  
  private cd$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gQ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return daC;
    case 2: 
      return daD;
    }
    return daE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cd.a
 * JD-Core Version:    0.7.0.1
 */