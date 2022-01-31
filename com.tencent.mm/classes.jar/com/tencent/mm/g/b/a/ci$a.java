package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ci$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128718);
    dbd = new a("release", 0, 1);
    dbe = new a("debug", 1, 2);
    dbf = new a("demo", 2, 3);
    dbg = new a[] { dbd, dbe, dbf };
    AppMethodBeat.o(128718);
  }
  
  private ci$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gV(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return dbd;
    case 2: 
      return dbe;
    }
    return dbf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ci.a
 * JD-Core Version:    0.7.0.1
 */