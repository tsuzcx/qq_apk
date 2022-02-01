package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.appstorage.af;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.file.ax;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiClearStorageTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;

public final class bj
{
  public static void a(w paramw, String paramString)
  {
    AppMethodBeat.i(316570);
    bj.a locala = new bj.a();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("currentPath", paramString);
    locala.K(localHashMap).h(paramw.ccO()).cpV();
    AppMethodBeat.o(316570);
  }
  
  static void v(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(316573);
    ((com.tencent.luggage.sdk.customize.a)e.T(com.tencent.luggage.sdk.customize.a.class)).f(paramString1, paramInt, paramString2).ai(2, paramString1);
    AppMethodBeat.o(316573);
  }
  
  public static boolean x(w paramw)
  {
    AppMethodBeat.i(180181);
    if (paramw.getInitConfig().launchMode == 1)
    {
      AppMethodBeat.o(180181);
      return true;
    }
    AppMethodBeat.o(180181);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bj
 * JD-Core Version:    0.7.0.1
 */