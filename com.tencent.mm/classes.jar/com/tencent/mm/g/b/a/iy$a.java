package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum iy$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43704);
    eyW = new a("release", 0, 1);
    eyX = new a("debug", 1, 2);
    eyY = new a("demo", 2, 3);
    eyZ = new a[] { eyW, eyX, eyY };
    AppMethodBeat.o(43704);
  }
  
  private iy$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return eyW;
    case 2: 
      return eyX;
    }
    return eyY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iy.a
 * JD-Core Version:    0.7.0.1
 */