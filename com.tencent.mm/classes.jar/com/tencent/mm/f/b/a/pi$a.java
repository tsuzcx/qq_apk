package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum pi$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43603);
    hfc = new a("release", 0, 1);
    hfd = new a("debug", 1, 2);
    hfe = new a("demo", 2, 3);
    hff = new a[] { hfc, hfd, hfe };
    AppMethodBeat.o(43603);
  }
  
  private pi$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hfc;
    case 2: 
      return hfd;
    }
    return hfe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.pi.a
 * JD-Core Version:    0.7.0.1
 */