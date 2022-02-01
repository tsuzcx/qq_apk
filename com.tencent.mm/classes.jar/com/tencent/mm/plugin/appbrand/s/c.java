package com.tencent.mm.plugin.appbrand.s;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  public Map<a, Long> muT;
  public Map<a, Long> muU;
  
  static
  {
    AppMethodBeat.i(140786);
    muS = new c("INSTANCE");
    muV = new c[] { muS };
    AppMethodBeat.o(140786);
  }
  
  private c()
  {
    AppMethodBeat.i(140783);
    this.muT = new HashMap();
    this.muU = new HashMap();
    AppMethodBeat.o(140783);
  }
  
  public static long bxP()
  {
    AppMethodBeat.i(224449);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(224449);
    return l;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140784);
    this.muT.put(parama, Long.valueOf(SystemClock.elapsedRealtime()));
    AppMethodBeat.o(140784);
  }
  
  public final String toString()
  {
    return "";
  }
  
  public static enum a
  {
    private String name;
    
    static
    {
      AppMethodBeat.i(140780);
      muW = new a("AppStart", 0, "AppStart");
      muX = new a("LoadPageFrame", 1, "LoadPageFrame");
      muY = new a("PrepareJsRuntime", 2, "PrepareJsRuntime");
      muZ = new a("GetDom", 3, "GetDom");
      mva = new a("ParseDom", 4, "ParseDom");
      mvb = new a("DiffDom", 5, "DiffDom");
      mvc = new a("GetGlobalCss", 6, "GetGlobalCss");
      mvd = new a("GetCss", 7, "GetCss");
      mve = new a("ParseCss", 8, "ParseCss");
      mvf = new a("GetData", 9, "GetData");
      mvg = new a("Layout", 10, "Layout");
      mvh = new a("JSEvent", 11, "JSEvent");
      mvi = new a("StartUp", 12, "StartUp");
      mvj = new a[] { muW, muX, muY, muZ, mva, mvb, mvc, mvd, mve, mvf, mvg, mvh, mvi };
      AppMethodBeat.o(140780);
    }
    
    private a(String paramString)
    {
      this.name = paramString;
    }
    
    public final String toString()
    {
      return this.name;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.c
 * JD-Core Version:    0.7.0.1
 */