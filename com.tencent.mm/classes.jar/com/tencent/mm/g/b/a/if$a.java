package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum if$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43552);
    evf = new a("release", 0, 1);
    evg = new a("debug", 1, 2);
    evh = new a("demo", 2, 3);
    evi = new a[] { evf, evg, evh };
    AppMethodBeat.o(43552);
  }
  
  private if$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jm(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.if.a
 * JD-Core Version:    0.7.0.1
 */