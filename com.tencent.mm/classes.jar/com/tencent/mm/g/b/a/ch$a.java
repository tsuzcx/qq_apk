package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ch$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128708);
    daY = new a("release", 0, 1);
    daZ = new a("debug", 1, 2);
    dba = new a("demo", 2, 3);
    dbb = new a[] { daY, daZ, dba };
    AppMethodBeat.o(128708);
  }
  
  private ch$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gU(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return daY;
    case 2: 
      return daZ;
    }
    return dba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ch.a
 * JD-Core Version:    0.7.0.1
 */