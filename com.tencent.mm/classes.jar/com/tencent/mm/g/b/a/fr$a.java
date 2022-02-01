package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum fr$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43613);
    edq = new a("release", 0, 1);
    edr = new a("debug", 1, 2);
    eds = new a("demo", 2, 3);
    edt = new a[] { edq, edr, eds };
    AppMethodBeat.o(43613);
  }
  
  private fr$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a iY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return edq;
    case 2: 
      return edr;
    }
    return eds;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fr.a
 * JD-Core Version:    0.7.0.1
 */