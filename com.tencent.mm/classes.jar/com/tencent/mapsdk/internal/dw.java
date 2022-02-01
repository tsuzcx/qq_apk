package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum dw
{
  private final int e;
  private final String f;
  
  static
  {
    AppMethodBeat.i(222979);
    a = new dw("None", 0, "", 0);
    b = new dw("Gradient", 1, "heat", 2);
    c = new dw("Aggregation", 2, "honey", 3);
    d = new dw("ArcLine", 3, "arcline", 4);
    g = new dw[] { a, b, c, d };
    AppMethodBeat.o(222979);
  }
  
  private dw(String paramString, int paramInt)
  {
    this.f = paramString;
    this.e = paramInt;
  }
  
  public static dw a(int paramInt)
  {
    AppMethodBeat.i(222967);
    Object localObject = values();
    int k = localObject.length;
    int i = 0;
    while (i < k)
    {
      dw localdw = localObject[i];
      if (localdw.e == paramInt) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(222967);
        return localdw;
      }
      i += 1;
    }
    localObject = a;
    AppMethodBeat.o(222967);
    return localObject;
  }
  
  private static dw b(String paramString)
  {
    AppMethodBeat.i(222960);
    dw[] arrayOfdw = values();
    int j = arrayOfdw.length;
    int i = 0;
    while (i < j)
    {
      dw localdw = arrayOfdw[i];
      if (localdw.a(paramString))
      {
        AppMethodBeat.o(222960);
        return localdw;
      }
      i += 1;
    }
    paramString = a;
    AppMethodBeat.o(222960);
    return paramString;
  }
  
  private boolean b(int paramInt)
  {
    return this.e == paramInt;
  }
  
  public final boolean a(String paramString)
  {
    AppMethodBeat.i(222984);
    boolean bool = this.f.equals(paramString);
    AppMethodBeat.o(222984);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.internal.dw
 * JD-Core Version:    0.7.0.1
 */