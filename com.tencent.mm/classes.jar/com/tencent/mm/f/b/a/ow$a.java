package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ow$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43529);
    hdu = new a("release", 0, 1);
    hdv = new a("debug", 1, 2);
    hdw = new a("demo", 2, 3);
    hdx = new a[] { hdu, hdv, hdw };
    AppMethodBeat.o(43529);
  }
  
  private ow$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a ov(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hdu;
    case 2: 
      return hdv;
    }
    return hdw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ow.a
 * JD-Core Version:    0.7.0.1
 */