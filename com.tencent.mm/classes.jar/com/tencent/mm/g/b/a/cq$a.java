package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cq$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128804);
    dcu = new a("release", 0, 1);
    dcv = new a("debug", 1, 2);
    dcw = new a("demo", 2, 3);
    dcx = new a[] { dcu, dcv, dcw };
    AppMethodBeat.o(128804);
  }
  
  private cq$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a hd(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return dcu;
    case 2: 
      return dcv;
    }
    return dcw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cq.a
 * JD-Core Version:    0.7.0.1
 */