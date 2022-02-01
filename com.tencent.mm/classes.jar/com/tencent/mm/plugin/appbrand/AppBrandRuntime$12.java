package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.n;
import java.util.HashMap;

final class AppBrandRuntime$12
  implements c.a
{
  AppBrandRuntime$12(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(197172);
    AppBrandRuntime localAppBrandRuntime = this.jxm;
    HashMap localHashMap = new HashMap();
    switch (com.tencent.mm.plugin.appbrand.page.n.1.jLm[paramb.ordinal()])
    {
    default: 
      AppMethodBeat.o(197172);
      return;
    case 1: 
      paramString = "background";
    }
    for (;;)
    {
      localHashMap.put("status", paramString);
      new n().A(localHashMap).g(localAppBrandRuntime.Ew()).bir();
      AppMethodBeat.o(197172);
      return;
      paramString = "active";
      continue;
      paramString = "suspend";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.12
 * JD-Core Version:    0.7.0.1
 */