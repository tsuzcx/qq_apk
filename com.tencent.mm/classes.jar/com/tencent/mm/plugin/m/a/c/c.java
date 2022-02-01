package com.tencent.mm.plugin.m.a.c;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.k;
import d.l;
import java.util.LinkedHashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/util/WxaNativeTimeProfiler;", "", "()V", "EVENT_INIT_FLUTTER_END", "", "EVENT_INIT_FLUTTER_START", "EVENT_INJECT_JS_END", "EVENT_INJECT_JS_START", "EVENT_INJECT_PAGE_JS", "EVENT_ONFOREGROUND", "EVENT_ONSHOW", "getEVENT_ONSHOW", "()Ljava/lang/String;", "EVENT_PAGE_READY", "EVENT_UI_CREATE", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "records", "", "", "addEvent", "", "name", "clear", "", "getPreloadFlutterEnable", "getPreloadJsEnable", "printTimeSpent", "from", "to", "setPreloadFlutterEnable", "enable", "setPreloadJsEnable", "luggage-native-view_release"})
public final class c
{
  private static final aw cqB;
  private static final String uAt = "onShow";
  private static final Map<String, Long> uAu;
  public static final c uAv;
  
  static
  {
    AppMethodBeat.i(123877);
    uAv = new c();
    aw localaw = aw.aKT("WxaNativeTimeProfiler_mmkv");
    k.g(localaw, "MultiProcessMMKV.getMMKV…NativeTimeProfiler_mmkv\")");
    cqB = localaw;
    uAt = "onShow";
    uAu = (Map)new LinkedHashMap();
    AppMethodBeat.o(123877);
  }
  
  public static boolean akv(String paramString)
  {
    AppMethodBeat.i(123870);
    k.h(paramString, "name");
    if (uAu.containsKey(paramString))
    {
      AppMethodBeat.o(123870);
      return false;
    }
    uAu.put(paramString, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(123870);
    return true;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(123872);
    uAu.clear();
    AppMethodBeat.o(123872);
  }
  
  public static String daJ()
  {
    return uAt;
  }
  
  public static boolean daK()
  {
    AppMethodBeat.i(123875);
    boolean bool = cqB.getBoolean("setPreloadJsEnable", true);
    AppMethodBeat.o(123875);
    return bool;
  }
  
  public static boolean daL()
  {
    AppMethodBeat.i(123876);
    boolean bool = cqB.getBoolean("setPreloadFlutterEnable", true);
    AppMethodBeat.o(123876);
    return bool;
  }
  
  public static void hB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123871);
    k.h(paramString1, "from");
    k.h(paramString2, "to");
    StringBuilder localStringBuilder = new StringBuilder("Event:").append(paramString1).append(" -- Event:").append(paramString2).append("  cost:");
    paramString2 = (Long)uAu.get(paramString2);
    long l2;
    long l1;
    if (paramString2 != null)
    {
      l2 = paramString2.longValue();
      paramString1 = (Long)uAu.get(paramString1);
      if (paramString1 != null) {
        l1 = paramString1.longValue();
      }
    }
    for (paramString1 = Long.valueOf(l2 - l1);; paramString1 = null)
    {
      ac.i("WxaNativeTimeProfiler", paramString1);
      AppMethodBeat.o(123871);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public static void nO(boolean paramBoolean)
  {
    AppMethodBeat.i(123873);
    cqB.putBoolean("setPreloadJsEnable", paramBoolean).apply();
    AppMethodBeat.o(123873);
  }
  
  public static void nP(boolean paramBoolean)
  {
    AppMethodBeat.i(123874);
    cqB.putBoolean("setPreloadFlutterEnable", paramBoolean).apply();
    AppMethodBeat.o(123874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.c.c
 * JD-Core Version:    0.7.0.1
 */