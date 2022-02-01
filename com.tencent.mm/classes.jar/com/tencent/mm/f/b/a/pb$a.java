package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pb$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(243299);
    hei = new a("release", 0, 1);
    hej = new a("debug", 1, 2);
    hek = new a("demo", 2, 3);
    hel = new a[] { hei, hej, hek };
    AppMethodBeat.o(243299);
  }
  
  private pb$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oC(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hei;
    case 2: 
      return hej;
    }
    return hek;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pb.a
 * JD-Core Version:    0.7.0.1
 */