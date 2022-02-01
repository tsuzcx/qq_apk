package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum po$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43643);
    hgk = new a("release", 0, 1);
    hgl = new a("debug", 1, 2);
    hgm = new a("demo", 2, 3);
    hgn = new a[] { hgk, hgl, hgm };
    AppMethodBeat.o(43643);
  }
  
  private po$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hgk;
    case 2: 
      return hgl;
    }
    return hgm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.po.a
 * JD-Core Version:    0.7.0.1
 */