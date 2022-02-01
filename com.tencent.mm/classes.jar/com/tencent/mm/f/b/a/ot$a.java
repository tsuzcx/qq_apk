package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ot$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43503);
    hdd = new a("release", 0, 1);
    hde = new a("debug", 1, 2);
    hdf = new a("demo", 2, 3);
    hdg = new a[] { hdd, hde, hdf };
    AppMethodBeat.o(43503);
  }
  
  private ot$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a os(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hdd;
    case 2: 
      return hde;
    }
    return hdf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ot.a
 * JD-Core Version:    0.7.0.1
 */