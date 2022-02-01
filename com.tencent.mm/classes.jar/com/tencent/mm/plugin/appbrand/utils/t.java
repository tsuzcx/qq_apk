package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.webkit.ValueCallback;
import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.q.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.bc;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.util.ArrayList;

public final class t
{
  private static String ohb;
  
  public static String a(com.tencent.mm.plugin.appbrand.s params, a parama)
  {
    AppMethodBeat.i(147726);
    String str = "";
    if (parama == a.ohc) {
      str = params.Ou();
    }
    for (;;)
    {
      AppMethodBeat.o(147726);
      return str;
      if (parama == a.ohd) {
        str = params.Ot();
      }
    }
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString, q.a parama, s.a parama1)
  {
    AppMethodBeat.i(230011);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.NY() == null))
    {
      Log.e("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: virtualAccessScriptPath[%s] runtime or service is null!", new Object[] { paramString });
      AppMethodBeat.o(230011);
      return;
    }
    String str2 = LaunchParcel.Wf(parama.fileName).replace('/', '_') + "_" + parama.kKF;
    String str3 = parama.kKG;
    Object localObject = a.ohd;
    String str1 = a(paramAppBrandRuntime.NY(), (a)localObject);
    localObject = str1;
    if (str1.endsWith("/")) {
      localObject = str1.substring(0, str1.length() - 1);
    }
    localObject = (String)localObject + n.We(paramString);
    if (bc.c(paramAppBrandRuntime, paramString))
    {
      Log.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject sourceMap appId[%s] virtualAccessScriptPath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString });
      s.a(parami, bc.f(parama.kKI, parama.fileName + ".map", bZt(), (String)localObject), null, null, null, null);
    }
    Log.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject wxa script with appId:%s, virtualPath:%s, fileEntry.name:%s, sourceURL:%s, cacheCategory:%s, cacheKey:%s", new Object[] { paramAppBrandRuntime.mAppId, paramString, parama.fileName, localObject, str2, str3 });
    paramAppBrandRuntime = new ScriptPartObject();
    paramAppBrandRuntime.type = 2;
    paramAppBrandRuntime.wxaPkgPath = parama.kKI;
    paramAppBrandRuntime.wxaFileName = parama.fileName;
    paramAppBrandRuntime.wxaPkgKeyFilePath = bZt();
    paramString = new ArrayList(2);
    paramString.add(paramAppBrandRuntime);
    s.a(parami, paramString, (String)localObject, str2, str3, parama1);
    AppMethodBeat.o(230011);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString1, String paramString2, String paramString3, String paramString4, a parama, s.a parama1)
  {
    AppMethodBeat.i(169540);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.NY() == null))
    {
      Log.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
      AppMethodBeat.o(169540);
      return;
    }
    String str = n.We(paramString2);
    if (str.startsWith("/__APP__")) {
      str = n.We(str.substring(8));
    }
    for (;;)
    {
      parama = a(paramAppBrandRuntime.NY(), parama);
      if (bc.c(paramAppBrandRuntime, paramString2))
      {
        Log.i("MicroMsg.JsValidationInjectorWC", "inject sourceMap appId[%s] filePath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString2 });
        s.a(parami, bc.f(paramString1, str + ".map", bZt(), parama + paramString2), parama + paramString2, paramString3, paramString4, parama1);
      }
      paramAppBrandRuntime = new ScriptPartObject();
      paramAppBrandRuntime.type = 2;
      paramAppBrandRuntime.wxaPkgPath = paramString1;
      paramAppBrandRuntime.wxaFileName = str;
      paramAppBrandRuntime.wxaPkgKeyFilePath = bZt();
      paramString1 = new ArrayList(2);
      paramString1.add(paramAppBrandRuntime);
      s.a(parami, paramString1, parama + paramString2, paramString3, paramString4, parama1);
      AppMethodBeat.o(169540);
      return;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.s params, i parami, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, a parama, s.a parama1)
  {
    AppMethodBeat.i(147723);
    if (params == null)
    {
      Log.w("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
      AppMethodBeat.o(147723);
      return;
    }
    parama = a(params, parama);
    params = params.dG(paramString1);
    s.a(parami, parama + paramString1, paramString2, paramString3, paramInt, paramString4, params, parama1);
    AppMethodBeat.o(147723);
  }
  
  private static String bZt()
  {
    AppMethodBeat.i(182997);
    if (Util.isNullOrNil(ohb))
    {
      localObject = MMApplicationContext.getContext();
      ohb = ((Context)localObject).getFilesDir().getAbsolutePath() + "/wasae.dat";
    }
    Object localObject = ohb;
    AppMethodBeat.o(182997);
    return localObject;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(147722);
      ohc = new a("LIB", 0);
      ohd = new a("USR", 1);
      ohe = new a[] { ohc, ohd };
      AppMethodBeat.o(147722);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.t
 * JD-Core Version:    0.7.0.1
 */