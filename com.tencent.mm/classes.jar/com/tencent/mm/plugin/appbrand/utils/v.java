package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.q.a;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.be;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

public final class v
{
  private static String riO;
  
  public static String a(com.tencent.mm.plugin.appbrand.v paramv, v.a parama)
  {
    AppMethodBeat.i(147726);
    String str = "";
    if (parama == v.a.riP) {
      str = paramv.Rs();
    }
    for (;;)
    {
      AppMethodBeat.o(147726);
      return str;
      if (parama == v.a.riQ) {
        str = paramv.Rr();
      }
    }
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString, q.a parama, u.a parama1)
  {
    AppMethodBeat.i(233864);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.QW() == null))
    {
      Log.e("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: virtualAccessScriptPath[%s] runtime or service is null!", new Object[] { paramString });
      AppMethodBeat.o(233864);
      return;
    }
    String str2 = LaunchParcel.adT(parama.fileName).replace('/', '_') + "_" + parama.nEu;
    String str3 = parama.nEv;
    Object localObject = v.a.riQ;
    String str1 = a(paramAppBrandRuntime.QW(), (v.a)localObject);
    localObject = str1;
    if (str1.endsWith("/")) {
      localObject = str1.substring(0, str1.length() - 1);
    }
    localObject = (String)localObject + o.adS(paramString);
    if (be.c(paramAppBrandRuntime, paramString))
    {
      Log.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject sourceMap appId[%s] virtualAccessScriptPath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString });
      u.a(parami, be.i(parama.nEx, parama.fileName + ".map", cmj(), (String)localObject), null, null, null, null);
    }
    Log.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject wxa script with appId:%s, virtualPath:%s, fileEntry.name:%s, sourceURL:%s, cacheCategory:%s, cacheKey:%s", new Object[] { paramAppBrandRuntime.mAppId, paramString, parama.fileName, localObject, str2, str3 });
    paramAppBrandRuntime = new ScriptPartObject();
    paramAppBrandRuntime.type = 2;
    paramAppBrandRuntime.wxaPkgPath = parama.nEx;
    paramAppBrandRuntime.wxaFileName = parama.fileName;
    paramAppBrandRuntime.wxaPkgKeyFilePath = cmj();
    paramString = new ArrayList(2);
    paramString.add(paramAppBrandRuntime);
    u.a(parami, paramString, (String)localObject, str2, str3, parama1);
    AppMethodBeat.o(233864);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString1, String paramString2, String paramString3, String paramString4, v.a parama, u.a parama1)
  {
    AppMethodBeat.i(169540);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.QW() == null))
    {
      Log.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
      AppMethodBeat.o(169540);
      return;
    }
    String str = o.adS(paramString2);
    if (str.startsWith("/__APP__")) {
      str = o.adS(str.substring(8));
    }
    for (;;)
    {
      parama = a(paramAppBrandRuntime.QW(), parama);
      if (be.c(paramAppBrandRuntime, paramString2))
      {
        Log.i("MicroMsg.JsValidationInjectorWC", "inject sourceMap appId[%s] filePath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString2 });
        u.a(parami, be.i(paramString1, str + ".map", cmj(), parama + paramString2), parama + paramString2, paramString3, paramString4, parama1);
      }
      paramAppBrandRuntime = new ScriptPartObject();
      paramAppBrandRuntime.type = 2;
      paramAppBrandRuntime.wxaPkgPath = paramString1;
      paramAppBrandRuntime.wxaFileName = str;
      paramAppBrandRuntime.wxaPkgKeyFilePath = cmj();
      paramString1 = new ArrayList(2);
      paramString1.add(paramAppBrandRuntime);
      u.a(parami, paramString1, parama + paramString2, paramString3, paramString4, parama1);
      AppMethodBeat.o(169540);
      return;
    }
  }
  
  public static void a(i parami, String paramString)
  {
    AppMethodBeat.i(233873);
    parami = (l)parami.Q(l.class);
    if (parami == null)
    {
      AppMethodBeat.o(233873);
      return;
    }
    parami.ajL(paramString);
    AppMethodBeat.o(233873);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.v paramv, i parami, String paramString1, String paramString2, v.a parama, u.a parama1)
  {
    AppMethodBeat.i(233876);
    if (Util.isNullOrNil(paramString2))
    {
      parama1.dL("isNullOrNil script");
      AppMethodBeat.o(233876);
      return;
    }
    parami = (l)parami.Q(l.class);
    if (parami == null)
    {
      AppMethodBeat.o(233876);
      return;
    }
    paramString2 = paramString2 + String.format(Locale.ENGLISH, ";(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    try
    {
      paramv = new URL(a(paramv, parama) + paramString1);
      parami.a(paramString2, paramv.toString(), new ValueCallback() {});
      AppMethodBeat.o(233876);
      return;
    }
    catch (MalformedURLException paramv)
    {
      AppMethodBeat.o(233876);
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.v paramv, i parami, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, v.a parama, u.a parama1)
  {
    AppMethodBeat.i(147723);
    if (paramv == null)
    {
      Log.w("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
      AppMethodBeat.o(147723);
      return;
    }
    parama = a(paramv, parama);
    paramv = paramv.ea(paramString1);
    u.a(parami, parama + paramString1, paramString2, paramString3, paramInt, paramString4, paramv, parama1);
    AppMethodBeat.o(147723);
  }
  
  public static void b(i parami, String paramString)
  {
    AppMethodBeat.i(233878);
    try
    {
      paramString = new URL(paramString + "break.js");
      parami.a(paramString, "breakprogram();", null);
      AppMethodBeat.o(233878);
      return;
    }
    catch (MalformedURLException parami)
    {
      AppMethodBeat.o(233878);
    }
  }
  
  private static String cmj()
  {
    AppMethodBeat.i(182997);
    if (Util.isNullOrNil(riO))
    {
      localObject = MMApplicationContext.getContext();
      riO = ((Context)localObject).getFilesDir().getAbsolutePath() + "/wasae.dat";
    }
    Object localObject = riO;
    AppMethodBeat.o(182997);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.v
 * JD-Core Version:    0.7.0.1
 */