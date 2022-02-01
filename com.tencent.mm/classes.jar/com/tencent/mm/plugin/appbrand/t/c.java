package com.tencent.mm.plugin.appbrand.t;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  public Map<a, Long> mpV;
  public Map<a, Long> mpW;
  
  static
  {
    AppMethodBeat.i(140786);
    mpU = new c("INSTANCE");
    mpX = new c[] { mpU };
    AppMethodBeat.o(140786);
  }
  
  private c()
  {
    AppMethodBeat.i(140783);
    this.mpV = new HashMap();
    this.mpW = new HashMap();
    AppMethodBeat.o(140783);
  }
  
  public static long bwW()
  {
    AppMethodBeat.i(221673);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(221673);
    return l;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140784);
    this.mpV.put(parama, Long.valueOf(SystemClock.elapsedRealtime()));
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
      mpY = new a("AppStart", 0, "AppStart");
      mpZ = new a("LoadPageFrame", 1, "LoadPageFrame");
      mqa = new a("PrepareJsRuntime", 2, "PrepareJsRuntime");
      mqb = new a("GetDom", 3, "GetDom");
      mqc = new a("ParseDom", 4, "ParseDom");
      mqd = new a("DiffDom", 5, "DiffDom");
      mqe = new a("GetGlobalCss", 6, "GetGlobalCss");
      mqf = new a("GetCss", 7, "GetCss");
      mqg = new a("ParseCss", 8, "ParseCss");
      mqh = new a("GetData", 9, "GetData");
      mqi = new a("Layout", 10, "Layout");
      mqj = new a("JSEvent", 11, "JSEvent");
      mqk = new a("StartUp", 12, "StartUp");
      mql = new a[] { mpY, mpZ, mqa, mqb, mqc, mqd, mqe, mqf, mqg, mqh, mqi, mqj, mqk };
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