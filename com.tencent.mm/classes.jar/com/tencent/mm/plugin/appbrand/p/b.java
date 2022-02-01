package com.tencent.mm.plugin.appbrand.p;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a.a;

public enum b
  implements c.a.a
{
  static
  {
    AppMethodBeat.i(198661);
    lXx = new b("INSTANCE");
    lXy = new b[] { lXx };
    AppMethodBeat.o(198661);
  }
  
  private b() {}
  
  public final com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c a(String paramString, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(198660);
    paramString = new a(paramString, paramActivity, paramc);
    AppMethodBeat.o(198660);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.b
 * JD-Core Version:    0.7.0.1
 */