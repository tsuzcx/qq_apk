package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ck$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128736);
    dbr = new a("release", 0, 1);
    dbs = new a("debug", 1, 2);
    dbt = new a("demo", 2, 3);
    dbu = new a[] { dbr, dbs, dbt };
    AppMethodBeat.o(128736);
  }
  
  private ck$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return dbr;
    case 2: 
      return dbs;
    }
    return dbt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ck.a
 * JD-Core Version:    0.7.0.1
 */