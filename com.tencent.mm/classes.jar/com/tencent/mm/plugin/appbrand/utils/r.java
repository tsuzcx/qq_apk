package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.webkit.ValueCallback;
import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.File;
import java.util.ArrayList;

public final class r
{
  private static String lMw;
  
  public static String a(com.tencent.mm.plugin.appbrand.q paramq, a parama)
  {
    AppMethodBeat.i(147726);
    String str = "";
    if (parama == a.lMx) {
      str = paramq.DO();
    }
    for (;;)
    {
      AppMethodBeat.o(147726);
      return str;
      if (parama == a.lMy) {
        str = paramq.DN();
      }
    }
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString, com.tencent.mm.plugin.appbrand.appcache.q.a parama, q.a parama1)
  {
    AppMethodBeat.i(186910);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.Du() == null))
    {
      ad.e("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: virtualAccessScriptPath[%s] runtime or service is null!", new Object[] { paramString });
      AppMethodBeat.o(186910);
      return;
    }
    String str2 = LaunchParcel.EW(parama.fileName).replace('/', '_') + "_" + parama.iLN;
    String str3 = parama.iLO;
    Object localObject = a.lMy;
    String str1 = a(paramAppBrandRuntime.Du(), (a)localObject);
    localObject = str1;
    if (str1.endsWith("/")) {
      localObject = str1.substring(0, str1.length() - 1);
    }
    localObject = (String)localObject + m.EV(paramString);
    if (ap.c(paramAppBrandRuntime, paramString))
    {
      ad.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject sourceMap appId[%s] virtualAccessScriptPath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString });
      q.a(parami, ap.f(parama.iLQ, parama.fileName + ".map", bqt(), (String)localObject), null, null, null, null);
    }
    ad.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject wxa script with appId:%s, virtualPath:%s, fileEntry.name:%s, sourceURL:%s, cacheCategory:%s, cacheKey:%s", new Object[] { paramAppBrandRuntime.mAppId, paramString, parama.fileName, localObject, str2, str3 });
    paramAppBrandRuntime = new ScriptPartObject();
    paramAppBrandRuntime.type = 2;
    paramAppBrandRuntime.wxaPkgPath = parama.iLQ;
    paramAppBrandRuntime.wxaFileName = parama.fileName;
    paramAppBrandRuntime.wxaPkgKeyFilePath = bqt();
    paramString = new ArrayList(2);
    paramString.add(paramAppBrandRuntime);
    q.a(parami, paramString, (String)localObject, str2, str3, parama1);
    AppMethodBeat.o(186910);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString1, String paramString2, String paramString3, String paramString4, a parama, q.a parama1)
  {
    AppMethodBeat.i(169540);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.Du() == null))
    {
      ad.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
      AppMethodBeat.o(169540);
      return;
    }
    String str = m.EV(paramString2);
    if (str.startsWith("/__APP__")) {
      str = m.EV(str.substring(8));
    }
    for (;;)
    {
      parama = a(paramAppBrandRuntime.Du(), parama);
      if (ap.c(paramAppBrandRuntime, paramString2))
      {
        ad.i("MicroMsg.JsValidationInjectorWC", "inject sourceMap appId[%s] filePath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString2 });
        q.a(parami, ap.f(paramString1, str + ".map", bqt(), parama + paramString2), parama + paramString2, paramString3, paramString4, parama1);
      }
      paramAppBrandRuntime = new ScriptPartObject();
      paramAppBrandRuntime.type = 2;
      paramAppBrandRuntime.wxaPkgPath = paramString1;
      paramAppBrandRuntime.wxaFileName = str;
      paramAppBrandRuntime.wxaPkgKeyFilePath = bqt();
      paramString1 = new ArrayList(2);
      paramString1.add(paramAppBrandRuntime);
      q.a(parami, paramString1, parama + paramString2, paramString3, paramString4, parama1);
      AppMethodBeat.o(169540);
      return;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.q paramq, i parami, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, a parama, q.a parama1)
  {
    AppMethodBeat.i(147723);
    if (paramq == null)
    {
      ad.w("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
      AppMethodBeat.o(147723);
      return;
    }
    parama = a(paramq, parama);
    paramq = paramq.cv(paramString1);
    q.a(parami, parama + paramString1, paramString2, paramString3, paramInt, paramString4, paramq, parama1);
    AppMethodBeat.o(147723);
  }
  
  private static String bqt()
  {
    AppMethodBeat.i(182997);
    if (bt.isNullOrNil(lMw))
    {
      localObject = aj.getContext();
      lMw = ((Context)localObject).getFilesDir().getAbsolutePath() + "/wasae.dat";
    }
    Object localObject = lMw;
    AppMethodBeat.o(182997);
    return localObject;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(147722);
      lMx = new a("LIB", 0);
      lMy = new a("USR", 1);
      lMz = new a[] { lMx, lMy };
      AppMethodBeat.o(147722);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.r
 * JD-Core Version:    0.7.0.1
 */