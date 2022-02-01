package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import android.webkit.WebSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.concurrent.atomic.AtomicReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandNetworkConfigUserAgentHelper;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_KEY", "", "MMKV_NAME", "TAG", "mMemoryCachedUA", "Ljava/util/concurrent/atomic/AtomicReference;", "getByMMKV", "getByWebkit", "getSystemUserAgent", "setMMKV", "", "ua", "warmUpMemoryCache", "_ua", "luggage-wechat-full-sdk_release"})
public final class i
{
  private static final AtomicReference<String> kbl;
  public static final i kbm;
  
  static
  {
    AppMethodBeat.i(169550);
    kbm = new i();
    kbl = new AtomicReference();
    AppMethodBeat.o(169550);
  }
  
  public static final String NT(String paramString)
  {
    AppMethodBeat.i(220944);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramString = beG();
      }
      localObject = (String)kbl.getAndSet(paramString);
      ae.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "warmUpMemoryCache updated value = [ " + paramString + " ]");
      if ((p.i(paramString, localObject) ^ true)) {
        ay.gq("AppBrandNetworkConfigUserAgentHelper", 2).encode("UserAgent", paramString);
      }
      AppMethodBeat.o(220944);
      return paramString;
    }
  }
  
  public static final String beF()
  {
    AppMethodBeat.i(169547);
    Object localObject = (String)kbl.get();
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      ae.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "getSystemUserAgent by memory cache");
      AppMethodBeat.o(169547);
      return localObject;
    }
    localObject = a.kbn;
    localObject = a.beJ();
    kbl.set(localObject);
    AppMethodBeat.o(169547);
    return localObject;
  }
  
  private static String beG()
  {
    AppMethodBeat.i(169549);
    try
    {
      String str1 = WebSettings.getDefaultUserAgent(ak.getContext());
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"getByHeavyInvoke", "", "invoke"})
  static final class a
    extends q
    implements a<String>
  {
    public static final a kbn;
    
    static
    {
      AppMethodBeat.i(169546);
      kbn = new a();
      AppMethodBeat.o(169546);
    }
    
    a()
    {
      super();
    }
    
    public static String beJ()
    {
      AppMethodBeat.i(169545);
      long l = SystemClock.elapsedRealtime();
      Object localObject = i.kbm;
      String str2 = i.beH();
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
      boolean bool = ag.Ck();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        ae.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
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
        ae.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
        break;
      }
      label234:
      l = SystemClock.elapsedRealtime();
      localObject = i.kbm;
      str2 = i.beI();
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
      bool = ag.Ck();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool)) {
        ae.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
      }
      for (;;)
      {
        if (str2 == null) {
          p.gkB();
        }
        AppMethodBeat.o(169545);
        return str2;
        ae.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject + " isMainThread: " + bool + ' ');
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.i
 * JD-Core Version:    0.7.0.1
 */