package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum hx$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(180152);
    evf = new a("release", 0, 1);
    evg = new a("debug", 1, 2);
    evh = new a("demo", 2, 3);
    evi = new a[] { evf, evg, evh };
    AppMethodBeat.o(180152);
  }
  
  private hx$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return evf;
    case 2: 
      return evg;
    }
    return evh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hx.a
 * JD-Core Version:    0.7.0.1
 */