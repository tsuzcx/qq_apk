package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum qa$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43752);
    hja = new a("release", 0, 1);
    hjb = new a("debug", 1, 2);
    hjc = new a("demo", 2, 3);
    hjd = new a[] { hja, hjb, hjc };
    AppMethodBeat.o(43752);
  }
  
  private qa$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hja;
    case 2: 
      return hjb;
    }
    return hjc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qa.a
 * JD-Core Version:    0.7.0.1
 */