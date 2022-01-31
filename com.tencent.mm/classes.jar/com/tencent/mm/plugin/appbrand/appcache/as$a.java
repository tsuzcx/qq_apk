package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum as$a
{
  static
  {
    AppMethodBeat.i(59516);
    gWs = new a("APP_READY", 0);
    gWt = new a("APP_MANIFEST_NULL", 1);
    gWu = new a("PKG_EXPIRED", 2);
    gWv = new a("APP_NOT_INSTALLED", 3);
    gWw = new a("APP_BROKEN", 4);
    gWx = new a("ENV_ERR", 5);
    gWy = new a[] { gWs, gWt, gWu, gWv, gWw, gWx };
    AppMethodBeat.o(59516);
  }
  
  private as$a() {}
  
  public final int awa()
  {
    AppMethodBeat.i(59515);
    int i = super.ordinal();
    AppMethodBeat.o(59515);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.as.a
 * JD-Core Version:    0.7.0.1
 */