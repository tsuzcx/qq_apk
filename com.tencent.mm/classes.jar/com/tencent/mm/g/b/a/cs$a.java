package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cs$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128834);
    dcR = new a("release", 0, 1);
    dcS = new a("debug", 1, 2);
    dcT = new a("demo", 2, 3);
    dcU = new a[] { dcR, dcS, dcT };
    AppMethodBeat.o(128834);
  }
  
  private cs$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a hg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return dcR;
    case 2: 
      return dcS;
    }
    return dcT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cs.a
 * JD-Core Version:    0.7.0.1
 */