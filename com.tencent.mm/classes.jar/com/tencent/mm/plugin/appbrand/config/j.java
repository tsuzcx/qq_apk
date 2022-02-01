package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import android.webkit.WebSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandNetworkConfigUserAgentHelper;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_KEY", "", "MMKV_NAME", "TAG", "mMemoryCachedUA", "Ljava/util/concurrent/atomic/AtomicReference;", "getByMMKV", "getByWebkit", "getSystemUserAgent", "setMMKV", "", "ua", "warmUpMemoryCache", "_ua", "luggage-wechat-full-sdk_release"})
public final class j
{
  private static final AtomicReference<String> let;
  public static final j leu;
  
  static
  {
    AppMethodBeat.i(169550);
    leu = new j();
    let = new AtomicReference();
    AppMethodBeat.o(169550);
  }
  
  public static final String Xb(String paramString)
  {
    AppMethodBeat.i(230054);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramString = bzX();
      }
      localObject = (String)let.getAndSet(paramString);
      Log.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "warmUpMemoryCache updated value = [ " + paramString + " ]");
      if ((p.j(paramString, localObject) ^ true)) {
        MultiProcessMMKV.getMMKV("AppBrandNetworkConfigUserAgentHelper", 2).encode("UserAgent", paramString);
      }
      AppMethodBeat.o(230054);
      return paramString;
    }
  }
  
  public static final String bzW()
  {
    AppMethodBeat.i(169547);
    Object localObject = (String)let.get();
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "getSystemUserAgent by memory cache");
      AppMethodBeat.o(169547);
      return localObject;
    }
    localObject = a.lev;
    localObject = a.bAa();
    let.set(localObject);
    AppMethodBeat.o(169547);
    return localObject;
  }
  
  private static String bzX()
  {
    AppMethodBeat.i(169549);
    try
    {
      String str1 = WebSettings.getDefaultUserAgent(MMApplicationContext.getContext());
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"getByHeavyInvoke", "", "invoke"})
  static final class a
    extends q
    implements a<String>
  {
    public static final a lev;
    
    static
    {
      AppMethodBeat.i(169546);
      lev = new a();
      AppMethodBeat.o(169546);
    }
    
    a()
    {
      super();
    }
    
    public static String bAa()
    {
      AppMethodBeat.i(169545);
      long l = SystemClock.elapsedRealtime();
      Object localObject = j.leu;
      String str2 = j.bzY();
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
      boolean bool = ag.LB();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
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
        Log.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
        break;
      }
      label234:
      l = SystemClock.elapsedRealtime();
      localObject = j.leu;
      str2 = j.bzZ();
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
      bool = ag.LB();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool)) {
        Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
      }
      for (;;)
      {
        if (str2 == null) {
          p.hyc();
        }
        AppMethodBeat.o(169545);
        return str2;
        Log.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.j
 * JD-Core Version:    0.7.0.1
 */