package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ol$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43468);
    hbQ = new a("release", 0, 1);
    hbR = new a("debug", 1, 2);
    hbS = new a("demo", 2, 3);
    hbT = new a[] { hbQ, hbR, hbS };
    AppMethodBeat.o(43468);
  }
  
  private ol$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a om(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hbQ;
    case 2: 
      return hbR;
    }
    return hbS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ol.a
 * JD-Core Version:    0.7.0.1
 */