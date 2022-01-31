package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cv$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128875);
    ddA = new a("release", 0, 1);
    ddB = new a("debug", 1, 2);
    ddC = new a("demo", 2, 3);
    ddD = new a[] { ddA, ddB, ddC };
    AppMethodBeat.o(128875);
  }
  
  private cv$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a hj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ddA;
    case 2: 
      return ddB;
    }
    return ddC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cv.a
 * JD-Core Version:    0.7.0.1
 */