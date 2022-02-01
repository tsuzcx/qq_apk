package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.s.a;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.bk;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.l;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

public final class aa
{
  private static String ura;
  
  public static String a(y paramy, aa.a parama)
  {
    AppMethodBeat.i(147726);
    String str = "";
    if (parama == aa.a.urb) {
      str = paramy.arG();
    }
    for (;;)
    {
      AppMethodBeat.o(147726);
      return str;
      if (parama == aa.a.urc) {
        str = paramy.arF();
      }
    }
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString, s.a parama, z.a parama1)
  {
    AppMethodBeat.i(317337);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.ari() == null))
    {
      Log.e("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: virtualAccessScriptPath[%s] runtime or service is null!", new Object[] { paramString });
      AppMethodBeat.o(317337);
      return;
    }
    String str2 = LaunchParcel.Wu(parama.fileName).replace('/', '_') + "_" + parama.qEr;
    String str3 = parama.qEs;
    Object localObject = aa.a.urc;
    String str1 = a(paramAppBrandRuntime.ari(), (aa.a)localObject);
    localObject = str1;
    if (str1.endsWith("/")) {
      localObject = str1.substring(0, str1.length() - 1);
    }
    localObject = (String)localObject + t.Wt(paramString);
    if (bk.c(paramAppBrandRuntime, paramString))
    {
      Log.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject sourceMap appId[%s] virtualAccessScriptPath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString });
      z.a(parami, bk.h(parama.qEu, parama.fileName + ".map", cND(), (String)localObject), null, null, null, null);
    }
    Log.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject wxa script with appId:%s, virtualPath:%s, fileEntry.name:%s, sourceURL:%s, cacheCategory:%s, cacheKey:%s", new Object[] { paramAppBrandRuntime.mAppId, paramString, parama.fileName, localObject, str2, str3 });
    paramAppBrandRuntime = new ScriptPartObject();
    paramAppBrandRuntime.type = 2;
    paramAppBrandRuntime.wxaPkgPath = parama.qEu;
    paramAppBrandRuntime.wxaFileName = parama.fileName;
    paramAppBrandRuntime.wxaPkgKeyFilePath = cND();
    paramString = new ArrayList(2);
    paramString.add(paramAppBrandRuntime);
    z.a(parami, paramString, (String)localObject, str2, str3, parama1);
    AppMethodBeat.o(317337);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString1, String paramString2, String paramString3, String paramString4, aa.a parama, z.a parama1)
  {
    AppMethodBeat.i(169540);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.ari() == null))
    {
      Log.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
      AppMethodBeat.o(169540);
      return;
    }
    String str = t.as(paramString2, true);
    if (str.startsWith("/__APP__")) {
      str = t.as(str.substring(8), true);
    }
    for (;;)
    {
      parama = a(paramAppBrandRuntime.ari(), parama);
      if (bk.c(paramAppBrandRuntime, paramString2))
      {
        Log.i("MicroMsg.JsValidationInjectorWC", "inject sourceMap appId[%s] filePath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString2 });
        z.a(parami, bk.h(paramString1, str + ".map", cND(), parama + paramString2), parama + paramString2, paramString3, paramString4, parama1);
      }
      paramAppBrandRuntime = new ScriptPartObject();
      paramAppBrandRuntime.type = 2;
      paramAppBrandRuntime.wxaPkgPath = paramString1;
      paramAppBrandRuntime.wxaFileName = str;
      paramAppBrandRuntime.wxaPkgKeyFilePath = cND();
      paramString1 = new ArrayList(2);
      paramString1.add(paramAppBrandRuntime);
      z.a(parami, paramString1, parama + paramString2, paramString3, paramString4, parama1);
      AppMethodBeat.o(169540);
      return;
    }
  }
  
  public static void a(i parami, String paramString)
  {
    AppMethodBeat.i(317345);
    parami = (l)parami.Z(l.class);
    if (parami == null)
    {
      AppMethodBeat.o(317345);
      return;
    }
    parami.acL(paramString);
    AppMethodBeat.o(317345);
  }
  
  public static void a(y paramy, i parami, String paramString1, String paramString2, aa.a parama, z.a parama1)
  {
    AppMethodBeat.i(317349);
    if (Util.isNullOrNil(paramString2))
    {
      parama1.eW("isNullOrNil script");
      AppMethodBeat.o(317349);
      return;
    }
    parami = (l)parami.Z(l.class);
    if (parami == null)
    {
      AppMethodBeat.o(317349);
      return;
    }
    paramString2 = paramString2 + String.format(Locale.ENGLISH, ";(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    try
    {
      paramy = new URL(a(paramy, parama) + paramString1);
      parami.a(paramString2, paramy.toString(), new ValueCallback() {});
      AppMethodBeat.o(317349);
      return;
    }
    catch (MalformedURLException paramy)
    {
      AppMethodBeat.o(317349);
    }
  }
  
  public static void a(y paramy, i parami, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, aa.a parama, z.a parama1)
  {
    AppMethodBeat.i(147723);
    if (paramy == null)
    {
      Log.w("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
      AppMethodBeat.o(147723);
      return;
    }
    parama = a(paramy, parama);
    paramy = paramy.ft(paramString1);
    z.a(parami, parama + paramString1, paramString2, paramString3, paramInt, paramString4, paramy, parama1);
    AppMethodBeat.o(147723);
  }
  
  public static void b(i parami, String paramString)
  {
    AppMethodBeat.i(317353);
    try
    {
      paramString = new URL(paramString + "break.js");
      parami.a(paramString, "breakprogram();", null);
      AppMethodBeat.o(317353);
      return;
    }
    catch (MalformedURLException parami)
    {
      AppMethodBeat.o(317353);
    }
  }
  
  private static String cND()
  {
    AppMethodBeat.i(182997);
    if (Util.isNullOrNil(ura))
    {
      localObject = MMApplicationContext.getContext();
      ura = ((Context)localObject).getFilesDir().getAbsolutePath() + "/wasae.dat";
    }
    Object localObject = ura;
    AppMethodBeat.o(182997);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.aa
 * JD-Core Version:    0.7.0.1
 */