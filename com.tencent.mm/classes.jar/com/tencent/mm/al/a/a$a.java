package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  private final int cSx;
  
  static
  {
    AppMethodBeat.i(212194);
    iPr = new a("ALL", 0, 2);
    iPs = new a("DEPARTMENT", 1, 32);
    iPt = new a("EXTERNAL", 2, 128);
    iPu = new a("NORMAL", 3, 0);
    iPw = new a[] { iPr, iPs, iPt, iPu };
    AppMethodBeat.o(212194);
  }
  
  private a$a(int paramInt)
  {
    this.cSx = paramInt;
  }
  
  public static a sQ(int paramInt)
  {
    AppMethodBeat.i(212193);
    Object localObject = values();
    int k = localObject.length;
    int i = 0;
    while (i < k)
    {
      a locala = localObject[i];
      if ((locala.cSx & paramInt) != 0) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(212193);
        return locala;
      }
      i += 1;
    }
    localObject = iPu;
    AppMethodBeat.o(212193);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.a.a.a
 * JD-Core Version:    0.7.0.1
 */