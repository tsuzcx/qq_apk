package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cg$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128698);
    daS = new a("release", 0, 1);
    daT = new a("debug", 1, 2);
    daU = new a("demo", 2, 3);
    daV = new a[] { daS, daT, daU };
    AppMethodBeat.o(128698);
  }
  
  private cg$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return daS;
    case 2: 
      return daT;
    }
    return daU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cg.a
 * JD-Core Version:    0.7.0.1
 */