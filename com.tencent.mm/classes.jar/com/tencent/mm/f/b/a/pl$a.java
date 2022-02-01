package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pl$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43621);
    hfs = new a("release", 0, 1);
    hft = new a("debug", 1, 2);
    hfu = new a("demo", 2, 3);
    hfv = new a[] { hfs, hft, hfu };
    AppMethodBeat.o(43621);
  }
  
  private pl$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oJ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hfs;
    case 2: 
      return hft;
    }
    return hfu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pl.a
 * JD-Core Version:    0.7.0.1
 */