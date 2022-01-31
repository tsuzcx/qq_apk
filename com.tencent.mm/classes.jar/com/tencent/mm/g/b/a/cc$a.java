package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cc$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128658);
    daw = new a("release", 0, 1);
    dax = new a("debug", 1, 2);
    day = new a("demo", 2, 3);
    daz = new a[] { daw, dax, day };
    AppMethodBeat.o(128658);
  }
  
  private cc$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gP(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return daw;
    case 2: 
      return dax;
    }
    return day;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cc.a
 * JD-Core Version:    0.7.0.1
 */