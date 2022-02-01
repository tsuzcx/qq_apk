package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.webkit.ValueCallback;
import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.q.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.ar;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.File;
import java.util.ArrayList;

public final class t
{
  private static String mUa;
  
  public static String a(r paramr, a parama)
  {
    AppMethodBeat.i(147726);
    String str = "";
    if (parama == a.mUb) {
      str = paramr.ES();
    }
    for (;;)
    {
      AppMethodBeat.o(147726);
      return str;
      if (parama == a.mUc) {
        str = paramr.ER();
      }
    }
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString, q.a parama, s.a parama1)
  {
    AppMethodBeat.i(220901);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.Ey() == null))
    {
      ae.e("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: virtualAccessScriptPath[%s] runtime or service is null!", new Object[] { paramString });
      AppMethodBeat.o(220901);
      return;
    }
    String str2 = LaunchParcel.MW(parama.fileName).replace('/', '_') + "_" + parama.jIJ;
    String str3 = parama.jIK;
    Object localObject = a.mUc;
    String str1 = a(paramAppBrandRuntime.Ey(), (a)localObject);
    localObject = str1;
    if (str1.endsWith("/")) {
      localObject = str1.substring(0, str1.length() - 1);
    }
    localObject = (String)localObject + n.MV(paramString);
    if (ar.c(paramAppBrandRuntime, paramString))
    {
      ae.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject sourceMap appId[%s] virtualAccessScriptPath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString });
      s.a(parami, ar.g(parama.jIM, parama.fileName + ".map", bCp(), (String)localObject), null, null, null, null);
    }
    ae.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject wxa script with appId:%s, virtualPath:%s, fileEntry.name:%s, sourceURL:%s, cacheCategory:%s, cacheKey:%s", new Object[] { paramAppBrandRuntime.mAppId, paramString, parama.fileName, localObject, str2, str3 });
    paramAppBrandRuntime = new ScriptPartObject();
    paramAppBrandRuntime.type = 2;
    paramAppBrandRuntime.wxaPkgPath = parama.jIM;
    paramAppBrandRuntime.wxaFileName = parama.fileName;
    paramAppBrandRuntime.wxaPkgKeyFilePath = bCp();
    paramString = new ArrayList(2);
    paramString.add(paramAppBrandRuntime);
    s.a(parami, paramString, (String)localObject, str2, str3, parama1);
    AppMethodBeat.o(220901);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString1, String paramString2, String paramString3, String paramString4, a parama, s.a parama1)
  {
    AppMethodBeat.i(169540);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.Ey() == null))
    {
      ae.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
      AppMethodBeat.o(169540);
      return;
    }
    String str = n.MV(paramString2);
    if (str.startsWith("/__APP__")) {
      str = n.MV(str.substring(8));
    }
    for (;;)
    {
      parama = a(paramAppBrandRuntime.Ey(), parama);
      if (ar.c(paramAppBrandRuntime, paramString2))
      {
        ae.i("MicroMsg.JsValidationInjectorWC", "inject sourceMap appId[%s] filePath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString2 });
        s.a(parami, ar.g(paramString1, str + ".map", bCp(), parama + paramString2), parama + paramString2, paramString3, paramString4, parama1);
      }
      paramAppBrandRuntime = new ScriptPartObject();
      paramAppBrandRuntime.type = 2;
      paramAppBrandRuntime.wxaPkgPath = paramString1;
      paramAppBrandRuntime.wxaFileName = str;
      paramAppBrandRuntime.wxaPkgKeyFilePath = bCp();
      paramString1 = new ArrayList(2);
      paramString1.add(paramAppBrandRuntime);
      s.a(parami, paramString1, parama + paramString2, paramString3, paramString4, parama1);
      AppMethodBeat.o(169540);
      return;
    }
  }
  
  public static void a(r paramr, i parami, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, a parama, s.a parama1)
  {
    AppMethodBeat.i(147723);
    if (paramr == null)
    {
      ae.w("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
      AppMethodBeat.o(147723);
      return;
    }
    parama = a(paramr, parama);
    paramr = paramr.jdMethod_do(paramString1);
    s.a(parami, parama + paramString1, paramString2, paramString3, paramInt, paramString4, paramr, parama1);
    AppMethodBeat.o(147723);
  }
  
  private static String bCp()
  {
    AppMethodBeat.i(182997);
    if (bu.isNullOrNil(mUa))
    {
      localObject = ak.getContext();
      mUa = ((Context)localObject).getFilesDir().getAbsolutePath() + "/wasae.dat";
    }
    Object localObject = mUa;
    AppMethodBeat.o(182997);
    return localObject;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(147722);
      mUb = new a("LIB", 0);
      mUc = new a("USR", 1);
      mUd = new a[] { mUb, mUc };
      AppMethodBeat.o(147722);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.t
 * JD-Core Version:    0.7.0.1
 */