package com.tencent.mm.plugin.appbrand.ag.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"HTTP_HEADER_TO_FFMPEG_OPTION", "", "", "TAG", "THUMB_MEDIA_ERROR_WHAT_UNKNOWN", "", "totalBufferPercent", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "getTotalBufferPercent", "(Lcom/tencent/thumbplayer/api/ITPPlayer;)I", "getSimpleProcessName", "setDataSourceWorkaround", "", "url", "headers", "luggage-tp-video-ext_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final Map<String, String> utc;
  
  static
  {
    AppMethodBeat.i(318035);
    utc = ak.e(new r[] { v.Y("User-Agent", "user_agent"), v.Y("Cookie", "cookies"), v.Y("Referer", "referer") });
    AppMethodBeat.o(318035);
  }
  
  public static final int a(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(318006);
    s.u(paramITPPlayer, "<this>");
    if (0L < paramITPPlayer.getDurationMs())
    {
      int i = (int)(paramITPPlayer.getPlayableDurationMs() * 100L / paramITPPlayer.getDurationMs());
      AppMethodBeat.o(318006);
      return i;
    }
    AppMethodBeat.o(318006);
    return 0;
  }
  
  public static final void a(ITPPlayer paramITPPlayer, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(318018);
    s.u(paramITPPlayer, "<this>");
    s.u(paramString, "url");
    s.u(paramMap, "headers");
    Log.d("MicroMsg.AppBrand.ThumbPlayerExt", "setDataSourceWorkaround, url: " + paramString + ", headers: " + paramMap);
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    label168:
    label331:
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      String str = (String)localEntry.getKey();
      Iterator localIterator2 = ((Iterable)utc.entrySet()).iterator();
      while (localIterator2.hasNext())
      {
        paramMap = localIterator2.next();
        if (n.T(str, (String)((Map.Entry)paramMap).getKey(), true))
        {
          paramMap = (Map.Entry)paramMap;
          if (paramMap != null) {
            break label260;
          }
        }
      }
      for (paramMap = null;; paramMap = (String)localMap.put(paramMap.getValue(), localEntry.getValue()))
      {
        if (paramMap != null) {
          break label331;
        }
        Log.d("MicroMsg.AppBrand.ThumbPlayerExt", "setDataSourceWorkaround, " + (String)localEntry.getKey() + ": " + (String)localEntry.getValue());
        localMap.put(localEntry.getKey(), localEntry.getValue());
        break;
        paramMap = null;
        break label168;
        Log.d("MicroMsg.AppBrand.ThumbPlayerExt", "setDataSourceWorkaround, " + (String)paramMap.getValue() + ": " + (String)localEntry.getValue());
      }
    }
    label260:
    Log.d("MicroMsg.AppBrand.ThumbPlayerExt", s.X("setDataSourceWorkaround, headersSet: ", localMap));
    paramITPPlayer.setDataSource(paramString, localMap);
    AppMethodBeat.o(318018);
  }
  
  public static final String cwY()
  {
    AppMethodBeat.i(318026);
    String str = MMApplicationContext.getProcessName();
    CharSequence localCharSequence = (CharSequence)str;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label104;
      }
      s.s(str, "processName");
      i = n.a((CharSequence)str, ':', 0, false, 6);
      if ((i < 0) || (i + 1 > str.length())) {
        break label104;
      }
      str = str.substring(i + 1);
      s.s(str, "(this as java.lang.String).substring(startIndex)");
    }
    for (;;)
    {
      Log.d("MicroMsg.AppBrand.ThumbPlayerExt", s.X("getSimpleProcessName, simpleProcessName: ", str));
      AppMethodBeat.o(318026);
      return str;
      i = 0;
      break;
      label104:
      str = "main";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.b.a.b
 * JD-Core Version:    0.7.0.1
 */