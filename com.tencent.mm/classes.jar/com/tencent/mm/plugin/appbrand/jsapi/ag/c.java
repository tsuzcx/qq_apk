package com.tencent.mm.plugin.appbrand.jsapi.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public final String szc;
  
  static
  {
    AppMethodBeat.i(147307);
    syY = new c("UPDATING", 0, "updating");
    syZ = new c("NO_UPDATE", 1, "noUpdate");
    sza = new c("UPDATE_READY", 2, "updateReady");
    szb = new c("UPDATE_FAILED", 3, "updateFailed");
    szd = new c[] { syY, syZ, sza, szb };
    AppMethodBeat.o(147307);
  }
  
  private c(String paramString)
  {
    this.szc = paramString;
  }
  
  public static c abI(String paramString)
  {
    AppMethodBeat.i(147306);
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfc[i];
      if (localc.szc.equals(paramString))
      {
        AppMethodBeat.o(147306);
        return localc;
      }
      i += 1;
    }
    paramString = new IllegalArgumentException(String.format("Invalid name %s", new Object[] { paramString }));
    AppMethodBeat.o(147306);
    throw paramString;
  }
  
  public final String toString()
  {
    return this.szc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.c
 * JD-Core Version:    0.7.0.1
 */