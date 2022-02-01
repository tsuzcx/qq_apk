package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum jb$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43733);
    ezF = new a("release", 0, 1);
    ezG = new a("debug", 1, 2);
    ezH = new a("demo", 2, 3);
    ezI = new a[] { ezF, ezG, ezH };
    AppMethodBeat.o(43733);
  }
  
  private jb$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ezF;
    case 2: 
      return ezG;
    }
    return ezH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jb.a
 * JD-Core Version:    0.7.0.1
 */