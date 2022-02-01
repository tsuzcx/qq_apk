package com.tencent.mm.plugin.flutter.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/lite/WxaLiteAppCrashReportHandler;", "", "()V", "TAG", "", "handleCrash", "", "crashInfoMap", "", "killSelf", "", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Hkw;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(263304);
    Hkw = new a();
    TAG = "MicroMsg.WxaLiteAppCrashReportHandler";
    AppMethodBeat.o(263304);
  }
  
  public static void c(Map<String, ? extends Object> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(263297);
    s.u(paramMap, "crashInfoMap");
    Object localObject = (Map)paramMap.get("customParameters");
    s.checkNotNull(localObject);
    String str;
    label253:
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
          i = ((MultiProcessMMKV)localObject).getInt(s.X("count_", str), 0);
          long l1 = ((MultiProcessMMKV)localObject).getLong(s.X("time_", str), 0L);
          long l2 = System.currentTimeMillis();
          if (l2 - l1 > 3600000L)
          {
            ((MultiProcessMMKV)localObject).putInt(s.X("count_", str), 1);
            ((MultiProcessMMKV)localObject).putLong(s.X("time_", str), l2);
            Log.i(TAG, "WxaLiteApp handle crash. version:%s count%d time:%s now:%s", new Object[] { str, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2) });
            ((MultiProcessMMKV)localObject).commit();
          }
        }
        for (;;)
        {
          paramMap = paramMap.get("error");
          if (paramMap != null) {
            break label253;
          }
          paramMap = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(263297);
          throw paramMap;
          ((MultiProcessMMKV)localObject).putInt(s.X("count_", str), i + 1);
          break;
          Log.i(TAG, "WxaLiteApp handle state error . version:%s", new Object[] { str });
        }
        paramMap = (String)paramMap;
        if (paramMap.length() >= 10) {
          break label329;
        }
        if (!paramBoolean) {
          break label346;
        }
        h.OAn.p(1293L, 103L, 1L);
        label284:
        localh = h.OAn;
        if (!paramBoolean) {
          break label362;
        }
      }
    }
    label329:
    label346:
    label362:
    for (localObject = "crash";; localObject = "bad state only")
    {
      localh.b(20315, new Object[] { str, localObject, paramMap });
      AppMethodBeat.o(263297);
      return;
      paramMap = paramMap.substring(0, 10);
      s.s(paramMap, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      break;
      h.OAn.p(1293L, 104L, 1L);
      break label284;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.c.a
 * JD-Core Version:    0.7.0.1
 */