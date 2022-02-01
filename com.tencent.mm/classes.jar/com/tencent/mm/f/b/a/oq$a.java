package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum oq$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(180152);
    hcr = new a("release", 0, 1);
    hcs = new a("debug", 1, 2);
    hct = new a("demo", 2, 3);
    hcu = new a[] { hcr, hcs, hct };
    AppMethodBeat.o(180152);
  }
  
  private oq$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hcr;
    case 2: 
      return hcs;
    }
    return hct;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.oq.a
 * JD-Core Version:    0.7.0.1
 */