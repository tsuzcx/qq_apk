package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum oy$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43547);
    hdG = new a("release", 0, 1);
    hdH = new a("debug", 1, 2);
    hdI = new a("demo", 2, 3);
    hdJ = new a[] { hdG, hdH, hdI };
    AppMethodBeat.o(43547);
  }
  
  private oy$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a ox(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hdG;
    case 2: 
      return hdH;
    }
    return hdI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.oy.a
 * JD-Core Version:    0.7.0.1
 */