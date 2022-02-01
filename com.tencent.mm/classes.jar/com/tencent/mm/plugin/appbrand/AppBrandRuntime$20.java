package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.m;
import java.util.HashMap;

final class AppBrandRuntime$20
  implements c.a
{
  AppBrandRuntime$20(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(134462);
    AppBrandRuntime localAppBrandRuntime = this.iEc;
    HashMap localHashMap = new HashMap();
    switch (com.tencent.mm.plugin.appbrand.page.m.1.iRi[paramb.ordinal()])
    {
    default: 
      AppMethodBeat.o(134462);
      return;
    case 1: 
      paramString = "background";
    }
    for (;;)
    {
      localHashMap.put("status", paramString);
      new m().B(localHashMap).g(localAppBrandRuntime.Du()).aXQ();
      AppMethodBeat.o(134462);
      return;
      paramString = "active";
      continue;
      paramString = "suspend";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.20
 * JD-Core Version:    0.7.0.1
 */