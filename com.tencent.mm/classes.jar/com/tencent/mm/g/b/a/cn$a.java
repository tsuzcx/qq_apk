package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cn$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128772);
    dbL = new a("release", 0, 1);
    dbM = new a("debug", 1, 2);
    dbN = new a("demo", 2, 3);
    dbO = new a[] { dbL, dbM, dbN };
    AppMethodBeat.o(128772);
  }
  
  private cn$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a ha(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return dbL;
    case 2: 
      return dbM;
    }
    return dbN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cn.a
 * JD-Core Version:    0.7.0.1
 */