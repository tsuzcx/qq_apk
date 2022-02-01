package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pg$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43585);
    heM = new a("release", 0, 1);
    heN = new a("debug", 1, 2);
    heO = new a("demo", 2, 3);
    heP = new a[] { heM, heN, heO };
    AppMethodBeat.o(43585);
  }
  
  private pg$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return heM;
    case 2: 
      return heN;
    }
    return heO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pg.a
 * JD-Core Version:    0.7.0.1
 */