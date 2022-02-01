package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import android.webkit.WebSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.a.a;
import d.g.b.k;
import java.util.concurrent.atomic.AtomicReference;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandNetworkConfigUserAgentHelper;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_KEY", "", "MMKV_NAME", "TAG", "mMemoryCachedUA", "Ljava/util/concurrent/atomic/AtomicReference;", "getByMMKV", "getByWebkit", "getSystemUserAgent", "setMMKV", "", "ua", "warmUpMemoryCache", "_ua", "luggage-wechat-full-sdk_release"})
public final class i
{
  private static final AtomicReference<String> jDV;
  public static final i jDW;
  
  static
  {
    AppMethodBeat.i(169550);
    jDW = new i();
    jDV = new AtomicReference();
    AppMethodBeat.o(169550);
  }
  
  public static final String JT(String paramString)
  {
    AppMethodBeat.i(206211);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramString = baA();
      }
      localObject = (String)jDV.getAndSet(paramString);
      ac.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "warmUpMemoryCache updated value = [ " + paramString + " ]");
      if ((k.g(paramString, localObject) ^ true)) {
        aw.fK("AppBrandNetworkConfigUserAgentHelper", 2).encode("UserAgent", paramString);
      }
      AppMethodBeat.o(206211);
      return paramString;
    }
  }
  
  private static String baA()
  {
    AppMethodBeat.i(169549);
    try
    {
      String str1 = WebSettings.getDefaultUserAgent(ai.getContext());
      k.g(str1, "WebSettings.getDefaultUs…tionContext.getContext())");
      AppMethodBeat.o(169549);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str2 = System.getProperty("http.agent");
        Object localObject = str2;
        if (str2 == null) {
          localObject = "";
        }
      }
    }
  }
  
  public static final String baz()
  {
    AppMethodBeat.i(169547);
    Object localObject = (String)jDV.get();
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      ac.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "getSystemUserAgent by memory cache");
      AppMethodBeat.o(169547);
      return localObject;
    }
    localObject = a.jDX;
    localObject = a.baD();
    jDV.set(localObject);
    AppMethodBeat.o(169547);
    return localObject;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"getByHeavyInvoke", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<String>
  {
    public static final a jDX;
    
    static
    {
      AppMethodBeat.i(169546);
      jDX = new a();
      AppMethodBeat.o(169546);
    }
    
    a()
    {
      super();
    }
    
    public static String baD()
    {
      AppMethodBeat.i(169545);
      long l = SystemClock.elapsedRealtime();
      Object localObject = i.jDW;
      String str2 = i.baB();
      String str1;
      if (str2 != null)
      {
        str1 = str2.toString();
        localObject = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject = "";
      }
      boolean bool = ab.AI();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        ac.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
        localObject = (CharSequence)str2;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label229;
        }
      }
      label229:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label234;
        }
        AppMethodBeat.o(169545);
        return str2;
        ac.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
        break;
      }
      label234:
      l = SystemClock.elapsedRealtime();
      localObject = i.jDW;
      str2 = i.baC();
      if (str2 != null)
      {
        str1 = str2.toString();
        localObject = str1;
        if (str1 != null) {}
      }
      else
      {
        localObject = "";
      }
      bool = ab.AI();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool)) {
        ac.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
      }
      for (;;)
      {
        if (str2 == null) {
          k.fOy();
        }
        AppMethodBeat.o(169545);
        return str2;
        ac.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.i
 * JD-Core Version:    0.7.0.1
 */