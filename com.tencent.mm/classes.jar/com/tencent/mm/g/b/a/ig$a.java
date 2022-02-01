package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ig$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(187834);
    evo = new a("release", 0, 1);
    evp = new a("debug", 1, 2);
    evq = new a("demo", 2, 3);
    evr = new a[] { evo, evp, evq };
    AppMethodBeat.o(187834);
  }
  
  private ig$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jn(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return evo;
    case 2: 
      return evp;
    }
    return evq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ig.a
 * JD-Core Version:    0.7.0.1
 */