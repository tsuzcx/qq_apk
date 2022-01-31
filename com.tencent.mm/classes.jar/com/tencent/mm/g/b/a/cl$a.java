package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cl$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128748);
    dby = new a("release", 0, 1);
    dbz = new a("debug", 1, 2);
    dbA = new a("demo", 2, 3);
    dbB = new a[] { dby, dbz, dbA };
    AppMethodBeat.o(128748);
  }
  
  private cl$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return dby;
    case 2: 
      return dbz;
    }
    return dbA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cl.a
 * JD-Core Version:    0.7.0.1
 */