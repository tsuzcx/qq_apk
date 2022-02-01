package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import android.webkit.WebSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.a.a;
import d.g.b.k;
import java.util.concurrent.atomic.AtomicReference;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandNetworkConfigUserAgentHelper;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_KEY", "", "MMKV_NAME", "TAG", "mMemoryCachedUA", "Ljava/util/concurrent/atomic/AtomicReference;", "getByMMKV", "getByWebkit", "getSystemUserAgent", "setMMKV", "", "ua", "warmUpMemoryCache", "_ua", "luggage-wechat-full-sdk_release"})
public final class i
{
  private static final AtomicReference<String> jdH;
  public static final i jdI;
  
  static
  {
    AppMethodBeat.i(169550);
    jdI = new i();
    jdH = new AtomicReference();
    AppMethodBeat.o(169550);
  }
  
  public static final String FP(String paramString)
  {
    AppMethodBeat.i(186857);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramString = aTC();
      }
      localObject = (String)jdH.getAndSet(paramString);
      ad.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "warmUpMemoryCache updated value = [ " + paramString + " ]");
      if ((k.g(paramString, localObject) ^ true)) {
        ax.fF("AppBrandNetworkConfigUserAgentHelper", 2).encode("UserAgent", paramString);
      }
      AppMethodBeat.o(186857);
      return paramString;
    }
  }
  
  public static final String aTB()
  {
    AppMethodBeat.i(169547);
    Object localObject = (String)jdH.get();
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "getSystemUserAgent by memory cache");
      AppMethodBeat.o(169547);
      return localObject;
    }
    localObject = a.jdJ;
    localObject = a.aTF();
    jdH.set(localObject);
    AppMethodBeat.o(169547);
    return localObject;
  }
  
  private static String aTC()
  {
    AppMethodBeat.i(169549);
    try
    {
      String str1 = WebSettings.getDefaultUserAgent(aj.getContext());
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"getByHeavyInvoke", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<String>
  {
    public static final a jdJ;
    
    static
    {
      AppMethodBeat.i(169546);
      jdJ = new a();
      AppMethodBeat.o(169546);
    }
    
    a()
    {
      super();
    }
    
    public static String aTF()
    {
      AppMethodBeat.i(169545);
      long l = SystemClock.elapsedRealtime();
      Object localObject = i.jdI;
      String str2 = i.aTD();
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
      boolean bool = aa.Be();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        ad.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
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
        ad.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
        break;
      }
      label234:
      l = SystemClock.elapsedRealtime();
      localObject = i.jdI;
      str2 = i.aTE();
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
      bool = aa.Be();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool)) {
        ad.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
      }
      for (;;)
      {
        if (str2 == null) {
          k.fvU();
        }
        AppMethodBeat.o(169545);
        return str2;
        ad.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.i
 * JD-Core Version:    0.7.0.1
 */