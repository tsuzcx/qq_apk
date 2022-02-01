package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;

public enum b
{
  public final String lkt;
  
  static
  {
    AppMethodBeat.i(147307);
    lkp = new b("UPDATING", 0, "updating");
    lkq = new b("NO_UPDATE", 1, "noUpdate");
    lkr = new b("UPDATE_READY", 2, "updateReady");
    lks = new b("UPDATE_FAILED", 3, "updateFailed");
    lku = new b[] { lkp, lkq, lkr, lks };
    AppMethodBeat.o(147307);
  }
  
  private b(String paramString)
  {
    this.lkt = paramString;
  }
  
  public static b QC(String paramString)
  {
    AppMethodBeat.i(147306);
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.lkt.equals(paramString))
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
    return this.lkt;
  }
  
  public static final class a
    extends p
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onUpdateStatusChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.b
 * JD-Core Version:    0.7.0.1
 */