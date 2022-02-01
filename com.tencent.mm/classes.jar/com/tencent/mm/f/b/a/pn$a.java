package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pn$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43635);
    hfF = new a("release", 0, 1);
    hfG = new a("debug", 1, 2);
    hfH = new a("demo", 2, 3);
    hfI = new a[] { hfF, hfG, hfH };
    AppMethodBeat.o(43635);
  }
  
  private pn$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hfF;
    case 2: 
      return hfG;
    }
    return hfH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pn.a
 * JD-Core Version:    0.7.0.1
 */