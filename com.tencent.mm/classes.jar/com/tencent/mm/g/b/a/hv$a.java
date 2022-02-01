package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum hv$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(180152);
    ety = new a("release", 0, 1);
    etz = new a("debug", 1, 2);
    etA = new a("demo", 2, 3);
    etB = new a[] { ety, etz, etA };
    AppMethodBeat.o(180152);
  }
  
  private hv$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a iZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ety;
    case 2: 
      return etz;
    }
    return etA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hv.a
 * JD-Core Version:    0.7.0.1
 */