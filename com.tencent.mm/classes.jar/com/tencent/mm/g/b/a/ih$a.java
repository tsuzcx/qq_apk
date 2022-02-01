package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ih$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43564);
    evw = new a("release", 0, 1);
    evx = new a("debug", 1, 2);
    evy = new a("demo", 2, 3);
    evz = new a[] { evw, evx, evy };
    AppMethodBeat.o(43564);
  }
  
  private ih$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return evw;
    case 2: 
      return evx;
    }
    return evy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ih.a
 * JD-Core Version:    0.7.0.1
 */