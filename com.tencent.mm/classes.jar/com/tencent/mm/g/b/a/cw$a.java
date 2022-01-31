package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cw$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128885);
    ddF = new a("release", 0, 1);
    ddG = new a("debug", 1, 2);
    ddH = new a("demo", 2, 3);
    ddI = new a[] { ddF, ddG, ddH };
    AppMethodBeat.o(128885);
  }
  
  private cw$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a hk(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ddF;
    case 2: 
      return ddG;
    }
    return ddH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cw.a
 * JD-Core Version:    0.7.0.1
 */