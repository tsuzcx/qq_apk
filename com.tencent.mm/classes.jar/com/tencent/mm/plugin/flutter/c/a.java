package com.tencent.mm.plugin.flutter.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/flutter/lite/WxaLiteAppCrashReportHandler;", "", "()V", "TAG", "", "handleCrash", "", "crashInfoMap", "", "killSelf", "", "plugin-flutter_release"})
public final class a
{
  private static final String TAG = "MicroMsg.WxaLiteAppCrashReportHandler";
  public static final a ttv;
  
  static
  {
    AppMethodBeat.i(213459);
    ttv = new a();
    TAG = "MicroMsg.WxaLiteAppCrashReportHandler";
    AppMethodBeat.o(213459);
  }
  
  public static void b(Map<String, ? extends Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(213458);
    p.h(paramMap, "crashInfoMap");
    Object localObject = (Map)paramMap.get("customParameters");
    if (localObject == null) {
      p.gkB();
    }
    String str;
    label271:
    label302:
    g localg;
    if (((Map)localObject).containsKey("WxaLiteApp"))
    {
      localObject = ay.fpc();
      str = ((ay)localObject).getString("wxa_lite_app_game_center_version", "");
      if (str != null)
      {
        int i;
        if (paramBoolean)
        {
          i = ((ay)localObject).getInt("count_".concat(String.valueOf(str)), 0);
          long l1 = ((ay)localObject).getLong("time_".concat(String.valueOf(str)), 0L);
          long l2 = System.currentTimeMillis();
          if (l2 - l1 > 3600000L)
          {
            ((ay)localObject).putInt("count_".concat(String.valueOf(str)), 1);
            ((ay)localObject).putLong("time_".concat(String.valueOf(str)), l2);
            ae.i(TAG, "WxaLiteApp handle crash. version:%s count%d time:%s now:%s", new Object[] { str, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2) });
            ((ay)localObject).commit();
          }
        }
        for (;;)
        {
          paramMap = paramMap.get("error");
          if (paramMap != null) {
            break label271;
          }
          paramMap = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(213458);
          throw paramMap;
          ((ay)localObject).putInt("count_".concat(String.valueOf(str)), i + 1);
          break;
          ae.i(TAG, "WxaLiteApp handle state error . version:%s", new Object[] { str });
        }
        paramMap = (String)paramMap;
        if (paramMap.length() >= 10) {
          break label347;
        }
        if (!paramBoolean) {
          break label385;
        }
        g.yxI.n(1293L, 103L, 1L);
        localg = g.yxI;
        if (!paramBoolean) {
          break label401;
        }
      }
    }
    label385:
    label401:
    for (localObject = "crash";; localObject = "bad state only")
    {
      localg.f(20315, new Object[] { str, localObject, paramMap });
      AppMethodBeat.o(213458);
      return;
      label347:
      if (paramMap == null)
      {
        paramMap = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(213458);
        throw paramMap;
      }
      paramMap = paramMap.substring(0, 10);
      p.g(paramMap, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      break;
      g.yxI.n(1293L, 104L, 1L);
      break label302;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.c.a
 * JD-Core Version:    0.7.0.1
 */