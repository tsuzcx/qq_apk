package com.tencent.mm.plugin.appbrand.t;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  public Map<a, Long> lQf;
  public Map<a, Long> lQg;
  
  static
  {
    AppMethodBeat.i(140786);
    lQe = new c("INSTANCE");
    lQh = new c[] { lQe };
    AppMethodBeat.o(140786);
  }
  
  private c()
  {
    AppMethodBeat.i(140783);
    this.lQf = new HashMap();
    this.lQg = new HashMap();
    AppMethodBeat.o(140783);
  }
  
  public static long bsS()
  {
    AppMethodBeat.i(210333);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(210333);
    return l;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140784);
    this.lQf.put(parama, Long.valueOf(SystemClock.elapsedRealtime()));
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
      lQi = new a("AppStart", 0, "AppStart");
      lQj = new a("LoadPageFrame", 1, "LoadPageFrame");
      lQk = new a("PrepareJsRuntime", 2, "PrepareJsRuntime");
      lQl = new a("GetDom", 3, "GetDom");
      lQm = new a("ParseDom", 4, "ParseDom");
      lQn = new a("DiffDom", 5, "DiffDom");
      lQo = new a("GetGlobalCss", 6, "GetGlobalCss");
      lQp = new a("GetCss", 7, "GetCss");
      lQq = new a("ParseCss", 8, "ParseCss");
      lQr = new a("GetData", 9, "GetData");
      lQs = new a("Layout", 10, "Layout");
      lQt = new a("JSEvent", 11, "JSEvent");
      lQu = new a("StartUp", 12, "StartUp");
      lQv = new a[] { lQi, lQj, lQk, lQl, lQm, lQn, lQo, lQp, lQq, lQr, lQs, lQt, lQu };
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c
 * JD-Core Version:    0.7.0.1
 */