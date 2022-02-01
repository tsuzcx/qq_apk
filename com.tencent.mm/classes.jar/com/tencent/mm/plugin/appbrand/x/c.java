package com.tencent.mm.plugin.appbrand.x;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private Map<a, Long> tMA;
  private Map<a, Long> tMz;
  
  static
  {
    AppMethodBeat.i(140786);
    tMy = new c("INSTANCE");
    tMB = new c[] { tMy };
    AppMethodBeat.o(140786);
  }
  
  private c()
  {
    AppMethodBeat.i(140783);
    this.tMz = new HashMap();
    this.tMA = new HashMap();
    AppMethodBeat.o(140783);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140784);
    this.tMz.put(parama, Long.valueOf(SystemClock.elapsedRealtime()));
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
      tMC = new a("AppStart", 0, "AppStart");
      tMD = new a("LoadPageFrame", 1, "LoadPageFrame");
      tME = new a("PrepareJsRuntime", 2, "PrepareJsRuntime");
      tMF = new a("GetDom", 3, "GetDom");
      tMG = new a("ParseDom", 4, "ParseDom");
      tMH = new a("DiffDom", 5, "DiffDom");
      tMI = new a("GetGlobalCss", 6, "GetGlobalCss");
      tMJ = new a("GetCss", 7, "GetCss");
      tMK = new a("ParseCss", 8, "ParseCss");
      tML = new a("GetData", 9, "GetData");
      tMM = new a("Layout", 10, "Layout");
      tMN = new a("JSEvent", 11, "JSEvent");
      tMO = new a("StartUp", 12, "StartUp");
      tMP = new a[] { tMC, tMD, tME, tMF, tMG, tMH, tMI, tMJ, tMK, tML, tMM, tMN, tMO };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x.c
 * JD-Core Version:    0.7.0.1
 */