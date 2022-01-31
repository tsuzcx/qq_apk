package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  private String name;
  
  static
  {
    AppMethodBeat.i(91130);
    iEP = new a("AppStart", 0, "AppStart");
    iEQ = new a("LoadPageFrame", 1, "LoadPageFrame");
    iER = new a("PrepareJsRuntime", 2, "PrepareJsRuntime");
    iES = new a("GetDom", 3, "GetDom");
    iET = new a("ParseDom", 4, "ParseDom");
    iEU = new a("DiffDom", 5, "DiffDom");
    iEV = new a("GetGlobalCss", 6, "GetGlobalCss");
    iEW = new a("GetCss", 7, "GetCss");
    iEX = new a("ParseCss", 8, "ParseCss");
    iEY = new a("GetData", 9, "GetData");
    iEZ = new a("Layout", 10, "Layout");
    iFa = new a("JSEvent", 11, "JSEvent");
    iFb = new a("StartUp", 12, "StartUp");
    iFc = new a[] { iEP, iEQ, iER, iES, iET, iEU, iEV, iEW, iEX, iEY, iEZ, iFa, iFb };
    AppMethodBeat.o(91130);
  }
  
  private c$a(String paramString)
  {
    this.name = paramString;
  }
  
  public final String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.c.a
 * JD-Core Version:    0.7.0.1
 */