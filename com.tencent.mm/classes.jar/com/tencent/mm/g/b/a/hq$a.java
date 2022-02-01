package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum hq$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43468);
    esW = new a("release", 0, 1);
    esX = new a("debug", 1, 2);
    esY = new a("demo", 2, 3);
    esZ = new a[] { esW, esX, esY };
    AppMethodBeat.o(43468);
  }
  
  private hq$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a iX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return esW;
    case 2: 
      return esX;
    }
    return esY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hq.a
 * JD-Core Version:    0.7.0.1
 */