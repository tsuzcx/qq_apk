package com.tencent.mm.plugin.appbrand.p;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a.a;

public enum b
  implements c.a.a
{
  static
  {
    AppMethodBeat.i(209720);
    mce = new b("INSTANCE");
    mcf = new b[] { mce };
    AppMethodBeat.o(209720);
  }
  
  private b() {}
  
  public final com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c a(String paramString, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(209719);
    paramString = new a(paramString, paramActivity, paramc);
    AppMethodBeat.o(209719);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.b
 * JD-Core Version:    0.7.0.1
 */