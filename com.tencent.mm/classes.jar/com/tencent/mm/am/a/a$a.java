package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  private final int dDp;
  
  static
  {
    AppMethodBeat.i(207199);
    hRn = new a("ALL", 0, 2);
    hRo = new a("DEPARTMENT", 1, 32);
    hRp = new a("EXTERNAL", 2, 128);
    hRq = new a("NORMAL", 3, 0);
    hRr = new a[] { hRn, hRo, hRp, hRq };
    AppMethodBeat.o(207199);
  }
  
  private a$a(int paramInt)
  {
    this.dDp = paramInt;
  }
  
  public static a oZ(int paramInt)
  {
    AppMethodBeat.i(207198);
    Object localObject = values();
    int k = localObject.length;
    int i = 0;
    while (i < k)
    {
      a locala = localObject[i];
      if ((locala.dDp & paramInt) != 0) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(207198);
        return locala;
      }
      i += 1;
    }
    localObject = hRq;
    AppMethodBeat.o(207198);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.a.a.a
 * JD-Core Version:    0.7.0.1
 */