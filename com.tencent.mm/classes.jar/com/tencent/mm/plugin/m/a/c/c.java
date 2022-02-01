package com.tencent.mm.plugin.m.a.c;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import d.l;
import java.util.LinkedHashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/luggage/natives/util/WxaNativeTimeProfiler;", "", "()V", "EVENT_INIT_FLUTTER_END", "", "EVENT_INIT_FLUTTER_START", "EVENT_INJECT_JS_END", "EVENT_INJECT_JS_START", "EVENT_INJECT_PAGE_JS", "EVENT_ONFOREGROUND", "EVENT_ONSHOW", "getEVENT_ONSHOW", "()Ljava/lang/String;", "EVENT_PAGE_READY", "EVENT_UI_CREATE", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "records", "", "", "addEvent", "", "name", "clear", "", "getPreloadFlutterEnable", "getPreloadJsEnable", "printTimeSpent", "from", "to", "setPreloadFlutterEnable", "enable", "setPreloadJsEnable", "luggage-native-view_release"})
public final class c
{
  private static final ax ctt;
  private static final String tsa = "onShow";
  private static final Map<String, Long> tsb;
  public static final c tsc;
  
  static
  {
    AppMethodBeat.i(123877);
    tsc = new c();
    ax localax = ax.aFC("WxaNativeTimeProfiler_mmkv");
    k.g(localax, "MultiProcessMMKV.getMMKV…NativeTimeProfiler_mmkv\")");
    ctt = localax;
    tsa = "onShow";
    tsb = (Map)new LinkedHashMap();
    AppMethodBeat.o(123877);
  }
  
  public static boolean afB(String paramString)
  {
    AppMethodBeat.i(123870);
    k.h(paramString, "name");
    if (tsb.containsKey(paramString))
    {
      AppMethodBeat.o(123870);
      return false;
    }
    tsb.put(paramString, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(123870);
    return true;
  }
  
  public static String cNc()
  {
    return tsa;
  }
  
  public static boolean cNd()
  {
    AppMethodBeat.i(123875);
    boolean bool = ctt.getBoolean("setPreloadJsEnable", true);
    AppMethodBeat.o(123875);
    return bool;
  }
  
  public static boolean cNe()
  {
    AppMethodBeat.i(123876);
    boolean bool = ctt.getBoolean("setPreloadFlutterEnable", true);
    AppMethodBeat.o(123876);
    return bool;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(123872);
    tsb.clear();
    AppMethodBeat.o(123872);
  }
  
  public static void hi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123871);
    k.h(paramString1, "from");
    k.h(paramString2, "to");
    StringBuilder localStringBuilder = new StringBuilder("Event:").append(paramString1).append(" -- Event:").append(paramString2).append("  cost:");
    paramString2 = (Long)tsb.get(paramString2);
    long l2;
    long l1;
    if (paramString2 != null)
    {
      l2 = paramString2.longValue();
      paramString1 = (Long)tsb.get(paramString1);
      if (paramString1 != null) {
        l1 = paramString1.longValue();
      }
    }
    for (paramString1 = Long.valueOf(l2 - l1);; paramString1 = null)
    {
      ad.i("WxaNativeTimeProfiler", paramString1);
      AppMethodBeat.o(123871);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public static void mV(boolean paramBoolean)
  {
    AppMethodBeat.i(123873);
    ctt.putBoolean("setPreloadJsEnable", paramBoolean).apply();
    AppMethodBeat.o(123873);
  }
  
  public static void mW(boolean paramBoolean)
  {
    AppMethodBeat.i(123874);
    ctt.putBoolean("setPreloadFlutterEnable", paramBoolean).apply();
    AppMethodBeat.o(123874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.c.c
 * JD-Core Version:    0.7.0.1
 */