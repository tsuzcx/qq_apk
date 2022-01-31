package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cf$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128688);
    daN = new a("release", 0, 1);
    daO = new a("debug", 1, 2);
    daP = new a("demo", 2, 3);
    daQ = new a[] { daN, daO, daP };
    AppMethodBeat.o(128688);
  }
  
  private cf$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a gS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return daN;
    case 2: 
      return daO;
    }
    return daP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cf.a
 * JD-Core Version:    0.7.0.1
 */