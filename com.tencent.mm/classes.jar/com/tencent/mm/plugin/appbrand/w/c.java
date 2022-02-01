package com.tencent.mm.plugin.appbrand.w;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private Map<a, Long> qHQ;
  private Map<a, Long> qHR;
  
  static
  {
    AppMethodBeat.i(140786);
    qHP = new c("INSTANCE");
    qHS = new c[] { qHP };
    AppMethodBeat.o(140786);
  }
  
  private c()
  {
    AppMethodBeat.i(140783);
    this.qHQ = new HashMap();
    this.qHR = new HashMap();
    AppMethodBeat.o(140783);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140784);
    this.qHQ.put(parama, Long.valueOf(SystemClock.elapsedRealtime()));
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
      qHT = new a("AppStart", 0, "AppStart");
      qHU = new a("LoadPageFrame", 1, "LoadPageFrame");
      qHV = new a("PrepareJsRuntime", 2, "PrepareJsRuntime");
      qHW = new a("GetDom", 3, "GetDom");
      qHX = new a("ParseDom", 4, "ParseDom");
      qHY = new a("DiffDom", 5, "DiffDom");
      qHZ = new a("GetGlobalCss", 6, "GetGlobalCss");
      qIa = new a("GetCss", 7, "GetCss");
      qIb = new a("ParseCss", 8, "ParseCss");
      qIc = new a("GetData", 9, "GetData");
      qId = new a("Layout", 10, "Layout");
      qIe = new a("JSEvent", 11, "JSEvent");
      qIf = new a("StartUp", 12, "StartUp");
      qIg = new a[] { qHT, qHU, qHV, qHW, qHX, qHY, qHZ, qIa, qIb, qIc, qId, qIe, qIf };
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