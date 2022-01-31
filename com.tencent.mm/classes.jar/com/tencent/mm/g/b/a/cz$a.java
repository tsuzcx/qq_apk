package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cz$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128904);
    ddW = new a("release", 0, 1);
    ddX = new a("debug", 1, 2);
    ddY = new a("demo", 2, 3);
    ddZ = new a[] { ddW, ddX, ddY };
    AppMethodBeat.o(128904);
  }
  
  private cz$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a hm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ddW;
    case 2: 
      return ddX;
    }
    return ddY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cz.a
 * JD-Core Version:    0.7.0.1
 */