package com.tencent.mm.plugin.flutter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/flutter/lite/WxaLiteAppCrashReportHandler;", "", "()V", "TAG", "", "handleCrash", "", "crashInfoMap", "", "killSelf", "", "plugin-flutter_release"})
public final class a
{
  private static final String TAG = "MicroMsg.WxaLiteAppCrashReportHandler";
  public static final a wZq;
  
  static
  {
    AppMethodBeat.i(210549);
    wZq = new a();
    TAG = "MicroMsg.WxaLiteAppCrashReportHandler";
    AppMethodBeat.o(210549);
  }
  
  public static void b(Map<String, ? extends Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(210548);
    k.h(paramMap, "crashInfoMap");
    Object localObject = (Map)paramMap.get("customParameters");
    if (localObject == null) {
      k.fOy();
    }
    String str;
    label271:
    label302:
    h localh;
    if (((Map)localObject).containsKey("WxaLiteApp"))
    {
      localObject = aw.eVA();
      str = ((aw)localObject).getString("wxa_lite_app_game_center_version", "");
      if (str != null)
      {
        int i;
        if (paramBoolean)
        {
          i = ((aw)localObject).getInt("count_".concat(String.valueOf(str)), 0);
          long l1 = ((aw)localObject).getLong("time_".concat(String.valueOf(str)), 0L);
          long l2 = System.currentTimeMillis();
          if (l2 - l1 > 3600000L)
          {
            ((aw)localObject).putInt("count_".concat(String.valueOf(str)), 1);
            ((aw)localObject).putLong("time_".concat(String.valueOf(str)), l2);
            ac.i(TAG, "WxaLiteApp handle crash. version:%s count%d time:%s now:%s", new Object[] { str, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2) });
            ((aw)localObject).commit();
          }
        }
        for (;;)
        {
          paramMap = paramMap.get("error");
          if (paramMap != null) {
            break label271;
          }
          paramMap = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(210548);
          throw paramMap;
          ((aw)localObject).putInt("count_".concat(String.valueOf(str)), i + 1);
          break;
          ac.i(TAG, "WxaLiteApp handle state error . version:%s", new Object[] { str });
        }
        paramMap = (String)paramMap;
        if (paramMap.length() >= 10) {
          break label347;
        }
        if (!paramBoolean) {
          break label385;
        }
        h.wUl.n(1293L, 103L, 1L);
        localh = h.wUl;
        if (!paramBoolean) {
          break label401;
        }
      }
    }
    label385:
    label401:
    for (localObject = "crash";; localObject = "bad state only")
    {
      localh.f(20315, new Object[] { str, localObject, paramMap });
      AppMethodBeat.o(210548);
      return;
      label347:
      if (paramMap == null)
      {
        paramMap = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(210548);
        throw paramMap;
      }
      paramMap = paramMap.substring(0, 10);
      k.g(paramMap, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      break;
      h.wUl.n(1293L, 104L, 1L);
      break label302;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a
 * JD-Core Version:    0.7.0.1
 */