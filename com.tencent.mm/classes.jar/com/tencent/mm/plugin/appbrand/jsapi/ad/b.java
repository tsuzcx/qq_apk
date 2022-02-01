package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final String ptW;
  
  static
  {
    AppMethodBeat.i(147307);
    ptS = new b("UPDATING", 0, "updating");
    ptT = new b("NO_UPDATE", 1, "noUpdate");
    ptU = new b("UPDATE_READY", 2, "updateReady");
    ptV = new b("UPDATE_FAILED", 3, "updateFailed");
    ptX = new b[] { ptS, ptT, ptU, ptV };
    AppMethodBeat.o(147307);
  }
  
  private b(String paramString)
  {
    this.ptW = paramString;
  }
  
  public static b aiI(String paramString)
  {
    AppMethodBeat.i(147306);
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.ptW.equals(paramString))
      {
        AppMethodBeat.o(147306);
        return localb;
      }
      i += 1;
    }
    paramString = new IllegalArgumentException(String.format("Invalid name %s", new Object[] { paramString }));
    AppMethodBeat.o(147306);
    throw paramString;
  }
  
  public final String toString()
  {
    return this.ptW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.b
 * JD-Core Version:    0.7.0.1
 */