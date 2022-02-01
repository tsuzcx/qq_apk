package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum jc$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43744);
    ezK = new a("release", 0, 1);
    ezL = new a("debug", 1, 2);
    ezM = new a("demo", 2, 3);
    ezN = new a[] { ezK, ezL, ezM };
    AppMethodBeat.o(43744);
  }
  
  private jc$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ezK;
    case 2: 
      return ezL;
    }
    return ezM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jc.a
 * JD-Core Version:    0.7.0.1
 */