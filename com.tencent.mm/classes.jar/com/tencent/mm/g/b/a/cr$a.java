package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cr$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128820);
    dcG = new a("release", 0, 1);
    dcH = new a("debug", 1, 2);
    dcI = new a("demo", 2, 3);
    dcJ = new a[] { dcG, dcH, dcI };
    AppMethodBeat.o(128820);
  }
  
  private cr$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a he(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return dcG;
    case 2: 
      return dcH;
    }
    return dcI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cr.a
 * JD-Core Version:    0.7.0.1
 */