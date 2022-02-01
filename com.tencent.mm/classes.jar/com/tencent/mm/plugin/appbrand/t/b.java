package com.tencent.mm.plugin.appbrand.t;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a.a;

public enum b
  implements c.a.a
{
  static
  {
    AppMethodBeat.i(209175);
    qln = new b("INSTANCE");
    qlo = new b[] { qln };
    AppMethodBeat.o(209175);
  }
  
  private b() {}
  
  public final c a(String paramString, Activity paramActivity, e parame)
  {
    AppMethodBeat.i(209172);
    paramString = new a(paramString, paramActivity, parame);
    AppMethodBeat.o(209172);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.b
 * JD-Core Version:    0.7.0.1
 */