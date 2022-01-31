package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cj$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128725);
    dbk = new a("release", 0, 1);
    dbl = new a("debug", 1, 2);
    dbm = new a("demo", 2, 3);
    dbn = new a[] { dbk, dbl, dbm };
    AppMethodBeat.o(128725);
  }
  
  private cj$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gW(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return dbk;
    case 2: 
      return dbl;
    }
    return dbm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cj.a
 * JD-Core Version:    0.7.0.1
 */