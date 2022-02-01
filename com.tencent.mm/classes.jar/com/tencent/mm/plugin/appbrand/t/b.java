package com.tencent.mm.plugin.appbrand.t;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a.a;

public enum b
  implements c.a.a
{
  static
  {
    AppMethodBeat.i(240916);
    njP = new b("INSTANCE");
    njQ = new b[] { njP };
    AppMethodBeat.o(240916);
  }
  
  private b() {}
  
  public final c a(String paramString, Activity paramActivity, f paramf)
  {
    AppMethodBeat.i(240915);
    paramString = new a(paramString, paramActivity, paramf);
    AppMethodBeat.o(240915);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.b
 * JD-Core Version:    0.7.0.1
 */