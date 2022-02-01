package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  private final int dtM;
  
  static
  {
    AppMethodBeat.i(191072);
    gYu = new a("ALL", 0, 2);
    gYv = new a("DEPARTMENT", 1, 32);
    gYw = new a("EXTERNAL", 2, 128);
    gYx = new a("NORMAL", 3, 0);
    gYy = new a[] { gYu, gYv, gYw, gYx };
    AppMethodBeat.o(191072);
  }
  
  private a$a(int paramInt)
  {
    this.dtM = paramInt;
  }
  
  public static a nK(int paramInt)
  {
    AppMethodBeat.i(191071);
    Object localObject = values();
    int k = localObject.length;
    int i = 0;
    while (i < k)
    {
      a locala = localObject[i];
      if ((locala.dtM & paramInt) != 0) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(191071);
        return locala;
      }
      i += 1;
    }
    localObject = gYx;
    AppMethodBeat.o(191071);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.a.a
 * JD-Core Version:    0.7.0.1
 */