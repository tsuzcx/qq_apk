package com.tencent.mm.plugin.appbrand.jsapi.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;

public enum b
{
  public final String mvx;
  
  static
  {
    AppMethodBeat.i(147307);
    mvt = new b("UPDATING", 0, "updating");
    mvu = new b("NO_UPDATE", 1, "noUpdate");
    mvv = new b("UPDATE_READY", 2, "updateReady");
    mvw = new b("UPDATE_FAILED", 3, "updateFailed");
    mvy = new b[] { mvt, mvu, mvv, mvw };
    AppMethodBeat.o(147307);
  }
  
  private b(String paramString)
  {
    this.mvx = paramString;
  }
  
  public static b aaQ(String paramString)
  {
    AppMethodBeat.i(147306);
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.mvx.equals(paramString))
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
    return this.mvx;
  }
  
  public static final class a
    extends s
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onUpdateStatusChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.b
 * JD-Core Version:    0.7.0.1
 */