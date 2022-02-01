package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pc$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43564);
    heq = new a("release", 0, 1);
    her = new a("debug", 1, 2);
    hes = new a("demo", 2, 3);
    het = new a[] { heq, her, hes };
    AppMethodBeat.o(43564);
  }
  
  private pc$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oD(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return heq;
    case 2: 
      return her;
    }
    return hes;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pc.a
 * JD-Core Version:    0.7.0.1
 */