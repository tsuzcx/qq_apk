package com.tencent.mm.plugin.appbrand.u;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.s;

public enum c
  implements g.a.a
{
  static
  {
    AppMethodBeat.i(317050);
    tql = new c("INSTANCE");
    tqm = new c[] { tql };
    AppMethodBeat.o(317050);
  }
  
  private c() {}
  
  public final g a(String paramString, Activity paramActivity, com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(317056);
    a locala = a.tqf;
    s.u(paramString, "appId");
    s.u(paramActivity, "activity");
    s.u(paramf, "component");
    Log.i("MicroMsg.AppBrand.WxaNFCDiscoverableFactory", s.X("get#useReaderMode, value: ", Boolean.valueOf(a.tqg)));
    if (a.tqg) {}
    for (paramActivity = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.b)new com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.f(paramString, paramActivity);; paramActivity = (com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.b)new b(paramString, paramActivity, paramf))
    {
      paramString = new g(paramString, paramActivity);
      AppMethodBeat.o(317056);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c
 * JD-Core Version:    0.7.0.1
 */