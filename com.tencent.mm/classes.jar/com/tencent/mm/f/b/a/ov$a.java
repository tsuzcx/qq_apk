package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ov$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43521);
    hdo = new a("release", 0, 1);
    hdp = new a("debug", 1, 2);
    hdq = new a("demo", 2, 3);
    hds = new a[] { hdo, hdp, hdq };
    AppMethodBeat.o(43521);
  }
  
  private ov$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a ou(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hdo;
    case 2: 
      return hdp;
    }
    return hdq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ov.a
 * JD-Core Version:    0.7.0.1
 */