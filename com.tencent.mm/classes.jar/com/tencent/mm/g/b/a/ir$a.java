package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ir$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43643);
    exd = new a("release", 0, 1);
    exe = new a("debug", 1, 2);
    exf = new a("demo", 2, 3);
    exg = new a[] { exd, exe, exf };
    AppMethodBeat.o(43643);
  }
  
  private ir$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jw(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return exd;
    case 2: 
      return exe;
    }
    return exf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ir.a
 * JD-Core Version:    0.7.0.1
 */