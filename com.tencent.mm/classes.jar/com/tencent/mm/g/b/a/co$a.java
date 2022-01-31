package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum co$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128786);
    dcf = new a("release", 0, 1);
    dcg = new a("debug", 1, 2);
    dch = new a("demo", 2, 3);
    dci = new a[] { dcf, dcg, dch };
    AppMethodBeat.o(128786);
  }
  
  private co$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a hb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return dcf;
    case 2: 
      return dcg;
    }
    return dch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.co.a
 * JD-Core Version:    0.7.0.1
 */