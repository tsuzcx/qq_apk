package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pv$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43704);
    hic = new a("release", 0, 1);
    hid = new a("debug", 1, 2);
    hie = new a("demo", 2, 3);
    hif = new a[] { hic, hid, hie };
    AppMethodBeat.o(43704);
  }
  
  private pv$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hic;
    case 2: 
      return hid;
    }
    return hie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pv.a
 * JD-Core Version:    0.7.0.1
 */