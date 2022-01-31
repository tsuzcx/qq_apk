package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cm$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128760);
    dbF = new a("release", 0, 1);
    dbG = new a("debug", 1, 2);
    dbH = new a("demo", 2, 3);
    dbI = new a[] { dbF, dbG, dbH };
    AppMethodBeat.o(128760);
  }
  
  private cm$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return dbF;
    case 2: 
      return dbG;
    }
    return dbH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cm.a
 * JD-Core Version:    0.7.0.1
 */