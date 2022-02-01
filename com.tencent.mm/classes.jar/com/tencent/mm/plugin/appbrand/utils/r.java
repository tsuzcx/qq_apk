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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.File;
import java.util.ArrayList;

public final class r
{
  private static String mot;
  
  public static String a(com.tencent.mm.plugin.appbrand.q paramq, a parama)
  {
    AppMethodBeat.i(147726);
    String str = "";
    if (parama == a.mou) {
      str = paramq.Dr();
    }
    for (;;)
    {
      AppMethodBeat.o(147726);
      return str;
      if (parama == a.mov) {
        str = paramq.Dq();
      }
    }
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString, com.tencent.mm.plugin.appbrand.appcache.q.a parama, q.a parama1)
  {
    AppMethodBeat.i(206195);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.CX() == null))
    {
      ac.e("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: virtualAccessScriptPath[%s] runtime or service is null!", new Object[] { paramString });
      AppMethodBeat.o(206195);
      return;
    }
    String str2 = LaunchParcel.IZ(parama.fileName).replace('/', '_') + "_" + parama.jlU;
    String str3 = parama.jlV;
    Object localObject = a.mov;
    String str1 = a(paramAppBrandRuntime.CX(), (a)localObject);
    localObject = str1;
    if (str1.endsWith("/")) {
      localObject = str1.substring(0, str1.length() - 1);
    }
    localObject = (String)localObject + m.IY(paramString);
    if (ap.c(paramAppBrandRuntime, paramString))
    {
      ac.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject sourceMap appId[%s] virtualAccessScriptPath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString });
      q.a(parami, ap.h(parama.jlX, parama.fileName + ".map", bxr(), (String)localObject), null, null, null, null);
    }
    ac.i("MicroMsg.JsValidationInjectorWC", "injectWxaScriptWithSourceMapUsingFileEntry: inject wxa script with appId:%s, virtualPath:%s, fileEntry.name:%s, sourceURL:%s, cacheCategory:%s, cacheKey:%s", new Object[] { paramAppBrandRuntime.mAppId, paramString, parama.fileName, localObject, str2, str3 });
    paramAppBrandRuntime = new ScriptPartObject();
    paramAppBrandRuntime.type = 2;
    paramAppBrandRuntime.wxaPkgPath = parama.jlX;
    paramAppBrandRuntime.wxaFileName = parama.fileName;
    paramAppBrandRuntime.wxaPkgKeyFilePath = bxr();
    paramString = new ArrayList(2);
    paramString.add(paramAppBrandRuntime);
    q.a(parami, paramString, (String)localObject, str2, str3, parama1);
    AppMethodBeat.o(206195);
  }
  
  public static void a(AppBrandRuntime paramAppBrandRuntime, i parami, String paramString1, String paramString2, String paramString3, String paramString4, a parama, q.a parama1)
  {
    AppMethodBeat.i(169540);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.CX() == null))
    {
      ac.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
      AppMethodBeat.o(169540);
      return;
    }
    String str = m.IY(paramString2);
    if (str.startsWith("/__APP__")) {
      str = m.IY(str.substring(8));
    }
    for (;;)
    {
      parama = a(paramAppBrandRuntime.CX(), parama);
      if (ap.c(paramAppBrandRuntime, paramString2))
      {
        ac.i("MicroMsg.JsValidationInjectorWC", "inject sourceMap appId[%s] filePath[%s]", new Object[] { paramAppBrandRuntime.mAppId, paramString2 });
        q.a(parami, ap.h(paramString1, str + ".map", bxr(), parama + paramString2), parama + paramString2, paramString3, paramString4, parama1);
      }
      paramAppBrandRuntime = new ScriptPartObject();
      paramAppBrandRuntime.type = 2;
      paramAppBrandRuntime.wxaPkgPath = paramString1;
      paramAppBrandRuntime.wxaFileName = str;
      paramAppBrandRuntime.wxaPkgKeyFilePath = bxr();
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
      ac.w("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
      AppMethodBeat.o(147723);
      return;
    }
    parama = a(paramq, parama);
    paramq = paramq.ck(paramString1);
    q.a(parami, parama + paramString1, paramString2, paramString3, paramInt, paramString4, paramq, parama1);
    AppMethodBeat.o(147723);
  }
  
  private static String bxr()
  {
    AppMethodBeat.i(182997);
    if (bs.isNullOrNil(mot))
    {
      localObject = ai.getContext();
      mot = ((Context)localObject).getFilesDir().getAbsolutePath() + "/wasae.dat";
    }
    Object localObject = mot;
    AppMethodBeat.o(182997);
    return localObject;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(147722);
      mou = new a("LIB", 0);
      mov = new a("USR", 1);
      mow = new a[] { mou, mov };
      AppMethodBeat.o(147722);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.r
 * JD-Core Version:    0.7.0.1
 */