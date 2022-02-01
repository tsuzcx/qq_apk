package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pk$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43613);
    hfl = new a("release", 0, 1);
    hfm = new a("debug", 1, 2);
    hfn = new a("demo", 2, 3);
    hfo = new a[] { hfl, hfm, hfn };
    AppMethodBeat.o(43613);
  }
  
  private pk$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oI(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hfl;
    case 2: 
      return hfm;
    }
    return hfn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pk.a
 * JD-Core Version:    0.7.0.1
 */