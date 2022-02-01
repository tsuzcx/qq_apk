package com.tencent.mm.plugin.m.a.c;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.p;
import d.l;
import java.util.LinkedHashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/luggage/natives/util/WxaNativeTimeProfiler;", "", "()V", "EVENT_INIT_FLUTTER_END", "", "EVENT_INIT_FLUTTER_START", "EVENT_INJECT_JS_END", "EVENT_INJECT_JS_START", "EVENT_INJECT_PAGE_JS", "EVENT_ONFOREGROUND", "EVENT_ONSHOW", "getEVENT_ONSHOW", "()Ljava/lang/String;", "EVENT_PAGE_READY", "EVENT_UI_CREATE", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "records", "", "", "addEvent", "", "name", "clear", "", "getPreloadFlutterEnable", "getPreloadJsEnable", "printTimeSpent", "from", "to", "setPreloadFlutterEnable", "enable", "setPreloadJsEnable", "luggage-native-view_release"})
public final class c
{
  private static final ax cBy;
  private static final String vCW = "onShow";
  private static final Map<String, Long> vCX;
  public static final c vCY;
  
  static
  {
    AppMethodBeat.i(123877);
    vCY = new c();
    ax localax = ax.aQz("WxaNativeTimeProfiler_mmkv");
    p.g(localax, "MultiProcessMMKV.getMMKV…NativeTimeProfiler_mmkv\")");
    cBy = localax;
    vCW = "onShow";
    vCX = (Map)new LinkedHashMap();
    AppMethodBeat.o(123877);
  }
  
  public static boolean api(String paramString)
  {
    AppMethodBeat.i(123870);
    p.h(paramString, "name");
    if (vCX.containsKey(paramString))
    {
      AppMethodBeat.o(123870);
      return false;
    }
    vCX.put(paramString, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(123870);
    return true;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(123872);
    vCX.clear();
    AppMethodBeat.o(123872);
  }
  
  public static String djW()
  {
    return vCW;
  }
  
  public static boolean djX()
  {
    AppMethodBeat.i(123875);
    boolean bool = cBy.getBoolean("setPreloadJsEnable", true);
    AppMethodBeat.o(123875);
    return bool;
  }
  
  public static boolean djY()
  {
    AppMethodBeat.i(123876);
    boolean bool = cBy.getBoolean("setPreloadFlutterEnable", true);
    AppMethodBeat.o(123876);
    return bool;
  }
  
  public static void hN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123871);
    p.h(paramString1, "from");
    p.h(paramString2, "to");
    StringBuilder localStringBuilder = new StringBuilder("Event:").append(paramString1).append(" -- Event:").append(paramString2).append("  cost:");
    paramString2 = (Long)vCX.get(paramString2);
    long l2;
    long l1;
    if (paramString2 != null)
    {
      l2 = paramString2.longValue();
      paramString1 = (Long)vCX.get(paramString1);
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
  
  public static void oi(boolean paramBoolean)
  {
    AppMethodBeat.i(123873);
    cBy.putBoolean("setPreloadJsEnable", paramBoolean).apply();
    AppMethodBeat.o(123873);
  }
  
  public static void oj(boolean paramBoolean)
  {
    AppMethodBeat.i(123874);
    cBy.putBoolean("setPreloadFlutterEnable", paramBoolean).apply();
    AppMethodBeat.o(123874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.c.c
 * JD-Core Version:    0.7.0.1
 */