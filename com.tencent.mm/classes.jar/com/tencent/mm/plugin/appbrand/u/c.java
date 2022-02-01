package com.tencent.mm.plugin.appbrand.u;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  public Map<a, Long> loe;
  public Map<a, Long> lof;
  
  static
  {
    AppMethodBeat.i(140786);
    lod = new c("INSTANCE");
    loh = new c[] { lod };
    AppMethodBeat.o(140786);
  }
  
  private c()
  {
    AppMethodBeat.i(140783);
    this.loe = new HashMap();
    this.lof = new HashMap();
    AppMethodBeat.o(140783);
  }
  
  public static long blW()
  {
    AppMethodBeat.i(201305);
    long l = SystemClock.elapsedRealtime();
    AppMethodBeat.o(201305);
    return l;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140784);
    this.loe.put(parama, Long.valueOf(SystemClock.elapsedRealtime()));
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
      loi = new a("AppStart", 0, "AppStart");
      loj = new a("LoadPageFrame", 1, "LoadPageFrame");
      lok = new a("PrepareJsRuntime", 2, "PrepareJsRuntime");
      lol = new a("GetDom", 3, "GetDom");
      lom = new a("ParseDom", 4, "ParseDom");
      lon = new a("DiffDom", 5, "DiffDom");
      loo = new a("GetGlobalCss", 6, "GetGlobalCss");
      lop = new a("GetCss", 7, "GetCss");
      loq = new a("ParseCss", 8, "ParseCss");
      lor = new a("GetData", 9, "GetData");
      los = new a("Layout", 10, "Layout");
      lot = new a("JSEvent", 11, "JSEvent");
      lou = new a("StartUp", 12, "StartUp");
      lov = new a[] { loi, loj, lok, lol, lom, lon, loo, lop, loq, lor, los, lot, lou };
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c
 * JD-Core Version:    0.7.0.1
 */