package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum fa$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(180152);
    eaN = new a("release", 0, 1);
    eaO = new a("debug", 1, 2);
    eaP = new a("demo", 2, 3);
    eaQ = new a[] { eaN, eaO, eaP };
    AppMethodBeat.o(180152);
  }
  
  private fa$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a iI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return eaN;
    case 2: 
      return eaO;
    }
    return eaP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fa.a
 * JD-Core Version:    0.7.0.1
 */