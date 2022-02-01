package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum hr$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43474);
    etc = new a("release", 0, 1);
    etd = new a("debug", 1, 2);
    ete = new a("demo", 2, 3);
    etf = new a[] { etc, etd, ete };
    AppMethodBeat.o(43474);
  }
  
  private hr$a(int paramInt)
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
      return etc;
    case 2: 
      return etd;
    }
    return ete;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hr.a
 * JD-Core Version:    0.7.0.1
 */