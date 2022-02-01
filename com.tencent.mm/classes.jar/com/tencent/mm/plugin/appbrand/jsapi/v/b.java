package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;

public enum b
{
  public final String kNQ;
  
  static
  {
    AppMethodBeat.i(147307);
    kNM = new b("UPDATING", 0, "updating");
    kNN = new b("NO_UPDATE", 1, "noUpdate");
    kNO = new b("UPDATE_READY", 2, "updateReady");
    kNP = new b("UPDATE_FAILED", 3, "updateFailed");
    kNR = new b[] { kNM, kNN, kNO, kNP };
    AppMethodBeat.o(147307);
  }
  
  private b(String paramString)
  {
    this.kNQ = paramString;
  }
  
  public static b Nf(String paramString)
  {
    AppMethodBeat.i(147306);
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.kNQ.equals(paramString))
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
    return this.kNQ;
  }
  
  public static final class a
    extends p
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onUpdateStatusChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.b
 * JD-Core Version:    0.7.0.1
 */