package com.tencent.mm.plugin.flutter.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/lite/WxaLiteAppCrashReportHandler;", "", "()V", "TAG", "", "handleCrash", "", "crashInfoMap", "", "killSelf", "", "plugin-flutter_release"})
public final class a
{
  private static final String TAG = "MicroMsg.WxaLiteAppCrashReportHandler";
  public static final a wJq;
  
  static
  {
    AppMethodBeat.i(240993);
    wJq = new a();
    TAG = "MicroMsg.WxaLiteAppCrashReportHandler";
    AppMethodBeat.o(240993);
  }
  
  public static void b(Map<String, ? extends Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(240992);
    p.h(paramMap, "crashInfoMap");
    Object localObject = (Map)paramMap.get("customParameters");
    if (localObject == null) {
      p.hyc();
    }
    String str;
    label271:
    label302:
    h localh;
    if (((Map)localObject).containsKey("WxaLiteApp"))
    {
      localObject = MultiProcessMMKV.getMultiDefault();
      str = ((MultiProcessMMKV)localObject).getString("wxa_lite_app_game_center_version", "");
      if (str != null)
      {
        int i;
        if (paramBoolean)
        {
          i = ((MultiProcessMMKV)localObject).getInt("count_".concat(String.valueOf(str)), 0);
          long l1 = ((MultiProcessMMKV)localObject).getLong("time_".concat(String.valueOf(str)), 0L);
          long l2 = System.currentTimeMillis();
          if (l2 - l1 > 3600000L)
          {
            ((MultiProcessMMKV)localObject).putInt("count_".concat(String.valueOf(str)), 1);
            ((MultiProcessMMKV)localObject).putLong("time_".concat(String.valueOf(str)), l2);
            Log.i(TAG, "WxaLiteApp handle crash. version:%s count%d time:%s now:%s", new Object[] { str, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2) });
            ((MultiProcessMMKV)localObject).commit();
          }
        }
        for (;;)
        {
          paramMap = paramMap.get("error");
          if (paramMap != null) {
            break label271;
          }
          paramMap = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(240992);
          throw paramMap;
          ((MultiProcessMMKV)localObject).putInt("count_".concat(String.valueOf(str)), i + 1);
          break;
          Log.i(TAG, "WxaLiteApp handle state error . version:%s", new Object[] { str });
        }
        paramMap = (String)paramMap;
        if (paramMap.length() >= 10) {
          break label347;
        }
        if (!paramBoolean) {
          break label385;
        }
        h.CyF.n(1293L, 103L, 1L);
        localh = h.CyF;
        if (!paramBoolean) {
          break label401;
        }
      }
    }
    label385:
    label401:
    for (localObject = "crash";; localObject = "bad state only")
    {
      localh.a(20315, new Object[] { str, localObject, paramMap });
      AppMethodBeat.o(240992);
      return;
      label347:
      if (paramMap == null)
      {
        paramMap = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(240992);
        throw paramMap;
      }
      paramMap = paramMap.substring(0, 10);
      p.g(paramMap, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      break;
      h.CyF.n(1293L, 104L, 1L);
      break label302;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.c.a
 * JD-Core Version:    0.7.0.1
 */