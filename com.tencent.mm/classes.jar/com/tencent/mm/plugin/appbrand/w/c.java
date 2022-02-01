package com.tencent.mm.plugin.appbrand.w;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private Map<a, Long> nFE;
  private Map<a, Long> nFF;
  
  static
  {
    AppMethodBeat.i(140786);
    nFD = new c("INSTANCE");
    nFG = new c[] { nFD };
    AppMethodBeat.o(140786);
  }
  
  private c()
  {
    AppMethodBeat.i(140783);
    this.nFE = new HashMap();
    this.nFF = new HashMap();
    AppMethodBeat.o(140783);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140784);
    this.nFE.put(parama, Long.valueOf(SystemClock.elapsedRealtime()));
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
      nFH = new a("AppStart", 0, "AppStart");
      nFI = new a("LoadPageFrame", 1, "LoadPageFrame");
      nFJ = new a("PrepareJsRuntime", 2, "PrepareJsRuntime");
      nFK = new a("GetDom", 3, "GetDom");
      nFL = new a("ParseDom", 4, "ParseDom");
      nFM = new a("DiffDom", 5, "DiffDom");
      nFN = new a("GetGlobalCss", 6, "GetGlobalCss");
      nFO = new a("GetCss", 7, "GetCss");
      nFP = new a("ParseCss", 8, "ParseCss");
      nFQ = new a("GetData", 9, "GetData");
      nFR = new a("Layout", 10, "Layout");
      nFS = new a("JSEvent", 11, "JSEvent");
      nFT = new a("StartUp", 12, "StartUp");
      nFU = new a[] { nFH, nFI, nFJ, nFK, nFL, nFM, nFN, nFO, nFP, nFQ, nFR, nFS, nFT };
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.c
 * JD-Core Version:    0.7.0.1
 */