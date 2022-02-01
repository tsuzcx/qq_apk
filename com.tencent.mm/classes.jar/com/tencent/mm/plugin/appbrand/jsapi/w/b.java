package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;

public enum b
{
  public final String kmy;
  
  static
  {
    AppMethodBeat.i(147307);
    kmu = new b("UPDATING", 0, "updating");
    kmv = new b("NO_UPDATE", 1, "noUpdate");
    kmw = new b("UPDATE_READY", 2, "updateReady");
    kmx = new b("UPDATE_FAILED", 3, "updateFailed");
    kmz = new b[] { kmu, kmv, kmw, kmx };
    AppMethodBeat.o(147307);
  }
  
  private b(String paramString)
  {
    this.kmy = paramString;
  }
  
  public static b Jb(String paramString)
  {
    AppMethodBeat.i(147306);
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.kmy.equals(paramString))
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
    return this.kmy;
  }
  
  public static final class a
    extends p
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onUpdateStatusChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.b
 * JD-Core Version:    0.7.0.1
 */