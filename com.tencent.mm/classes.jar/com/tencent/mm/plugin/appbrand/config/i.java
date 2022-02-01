package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import android.webkit.WebSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.concurrent.atomic.AtomicReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandNetworkConfigUserAgentHelper;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_KEY", "", "MMKV_NAME", "TAG", "mMemoryCachedUA", "Ljava/util/concurrent/atomic/AtomicReference;", "getByMMKV", "getByWebkit", "getSystemUserAgent", "setMMKV", "", "ua", "warmUpMemoryCache", "_ua", "luggage-wechat-full-sdk_release"})
public final class i
{
  private static final AtomicReference<String> jXW;
  public static final i jXX;
  
  static
  {
    AppMethodBeat.i(169550);
    jXX = new i();
    jXW = new AtomicReference();
    AppMethodBeat.o(169550);
  }
  
  public static final String Nm(String paramString)
  {
    AppMethodBeat.i(192343);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramString = bea();
      }
      localObject = (String)jXW.getAndSet(paramString);
      com.tencent.mm.sdk.platformtools.ad.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "warmUpMemoryCache updated value = [ " + paramString + " ]");
      if ((p.i(paramString, localObject) ^ true)) {
        ax.gh("AppBrandNetworkConfigUserAgentHelper", 2).encode("UserAgent", paramString);
      }
      AppMethodBeat.o(192343);
      return paramString;
    }
  }
  
  public static final String bdZ()
  {
    AppMethodBeat.i(169547);
    Object localObject = (String)jXW.get();
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "getSystemUserAgent by memory cache");
      AppMethodBeat.o(169547);
      return localObject;
    }
    localObject = a.jXY;
    localObject = a.bed();
    jXW.set(localObject);
    AppMethodBeat.o(169547);
    return localObject;
  }
  
  private static String bea()
  {
    AppMethodBeat.i(169549);
    try
    {
      String str1 = WebSettings.getDefaultUserAgent(aj.getContext());
      p.g(str1, "WebSettings.getDefaultUs…tionContext.getContext())");
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"getByHeavyInvoke", "", "invoke"})
  static final class a
    extends q
    implements a<String>
  {
    public static final a jXY;
    
    static
    {
      AppMethodBeat.i(169546);
      jXY = new a();
      AppMethodBeat.o(169546);
    }
    
    a()
    {
      super();
    }
    
    public static String bed()
    {
      AppMethodBeat.i(169545);
      long l = SystemClock.elapsedRealtime();
      Object localObject = i.jXX;
      String str2 = i.beb();
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
      boolean bool = com.tencent.mm.plugin.appbrand.utils.ad.Ch();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        com.tencent.mm.sdk.platformtools.ad.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
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
        com.tencent.mm.sdk.platformtools.ad.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
        break;
      }
      label234:
      l = SystemClock.elapsedRealtime();
      localObject = i.jXX;
      str2 = i.bec();
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
      bool = com.tencent.mm.plugin.appbrand.utils.ad.Ch();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool)) {
        com.tencent.mm.sdk.platformtools.ad.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
      }
      for (;;)
      {
        if (str2 == null) {
          p.gfZ();
        }
        AppMethodBeat.o(169545);
        return str2;
        com.tencent.mm.sdk.platformtools.ad.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.i
 * JD-Core Version:    0.7.0.1
 */