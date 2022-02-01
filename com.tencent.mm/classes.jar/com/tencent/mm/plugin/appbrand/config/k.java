package com.tencent.mm.plugin.appbrand.config;

import android.os.SystemClock;
import android.webkit.WebSettings;
import com.tencent.luggage.sdk.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandNetworkConfigUserAgentHelper;", "", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_KEY", "", "MMKV_NAME", "TAG", "mMemoryCachedUA", "Ljava/util/concurrent/atomic/AtomicReference;", "getByMMKV", "getByWebkit", "getSystemUserAgent", "setMMKV", "", "ua", "warmUpMemoryCache", "_ua", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k qYK;
  private static final AtomicReference<String> qYL;
  
  static
  {
    AppMethodBeat.i(169550);
    qYK = new k();
    qYL = new AtomicReference();
    AppMethodBeat.o(169550);
  }
  
  public static final String Xp(String paramString)
  {
    AppMethodBeat.i(323380);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramString = ckK();
      }
      localObject = (String)qYL.getAndSet(paramString);
      Log.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "warmUpMemoryCache updated value = [ " + paramString + " ]");
      if (!s.p(paramString, localObject)) {
        MultiProcessMMKV.getMMKV("AppBrandNetworkConfigUserAgentHelper", 2).encode("UserAgent", paramString);
      }
      AppMethodBeat.o(323380);
      return paramString;
    }
  }
  
  public static final String ckJ()
  {
    AppMethodBeat.i(169547);
    Object localObject1 = (String)qYL.get();
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper", "getSystemUserAgent by memory cache");
      s.s(localObject1, "this");
      AppMethodBeat.o(169547);
      return localObject1;
    }
    localObject1 = d.evM;
    long l = SystemClock.elapsedRealtime();
    localObject2 = MultiProcessMMKV.getMMKV("AppBrandNetworkConfigUserAgentHelper", 2).decodeString("UserAgent");
    boolean bool;
    if (localObject2 == null)
    {
      localObject1 = "";
      bool = ao.aoz();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label264;
      }
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
      label193:
      localObject1 = (CharSequence)localObject2;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label322;
      }
    }
    String str;
    label264:
    label322:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label327;
      }
      localObject1 = localObject2;
      qYL.set(localObject1);
      AppMethodBeat.o(169547);
      return localObject1;
      str = localObject2.toString();
      localObject1 = str;
      if (str != null) {
        break;
      }
      localObject1 = "";
      break;
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent try mmkv" + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
      break label193;
    }
    label327:
    localObject1 = d.evM;
    l = SystemClock.elapsedRealtime();
    localObject2 = ckK();
    if (localObject2 == null)
    {
      localObject1 = "";
      label350:
      bool = ao.aoz();
      l = SystemClock.elapsedRealtime() - l;
      if ((l <= 32L) || (!bool)) {
        break label476;
      }
      Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
    }
    for (;;)
    {
      s.checkNotNull(localObject2);
      localObject1 = localObject2;
      break;
      str = localObject2.toString();
      localObject1 = str;
      if (str != null) {
        break label350;
      }
      localObject1 = "";
      break label350;
      label476:
      Log.i("Luggage.Utils.Profile", "runProfiled:log:" + "Luggage.WXA.FULL.AppBrandNetworkConfigUserAgentHelper: getSystemUserAgent by webkit" + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
    }
  }
  
  private static String ckK()
  {
    AppMethodBeat.i(169549);
    try
    {
      String str1 = WebSettings.getDefaultUserAgent(MMApplicationContext.getContext());
      s.s(str1, "{\n            WebSetting…t.getContext())\n        }");
      AppMethodBeat.o(169549);
      return str1;
    }
    finally
    {
      for (;;)
      {
        String str2 = System.getProperty("http.agent");
        Object localObject2 = str2;
        if (str2 == null) {
          localObject2 = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.k
 * JD-Core Version:    0.7.0.1
 */