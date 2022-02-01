package com.tencent.mm.plugin.appbrand.ae.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"HTTP_HEADER_TO_FFMPEG_OPTION", "", "", "TAG", "THUMB_MEDIA_ERROR_WHAT_UNKNOWN", "", "totalBufferPercent", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "getTotalBufferPercent", "(Lcom/tencent/thumbplayer/api/ITPPlayer;)I", "setDataSourceWorkaround", "", "url", "headers", "plugin-compat_release"})
public final class b
{
  private static final Map<String, String> rki;
  
  static
  {
    AppMethodBeat.i(207700);
    rki = ae.e(new o[] { s.M("User-Agent", "user_agent"), s.M("Cookie", "cookies"), s.M("Referer", "referer") });
    AppMethodBeat.o(207700);
  }
  
  public static final int a(ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(207694);
    p.k(paramITPPlayer, "$this$totalBufferPercent");
    if (0L < paramITPPlayer.getDurationMs())
    {
      int i = (int)(paramITPPlayer.getPlayableDurationMs() * 100L / paramITPPlayer.getDurationMs());
      AppMethodBeat.o(207694);
      return i;
    }
    AppMethodBeat.o(207694);
    return 0;
  }
  
  public static final void a(ITPPlayer paramITPPlayer, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(207697);
    p.k(paramITPPlayer, "$this$setDataSourceWorkaround");
    p.k(paramString, "url");
    p.k(paramMap, "headers");
    Log.d("MicroMsg.AppBrand.ThumbPlayerExt", "setDataSourceWorkaround, url: " + paramString + ", headers: " + paramMap);
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      String str = (String)localEntry.getKey();
      Iterator localIterator2 = ((Iterable)rki.entrySet()).iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramMap = localIterator2.next();
      } while (!n.L(str, (String)((Map.Entry)paramMap).getKey(), true));
      for (;;)
      {
        paramMap = (Map.Entry)paramMap;
        if (paramMap == null) {
          break;
        }
        localMap.put(paramMap.getValue(), localEntry.getValue());
        break;
        paramMap = null;
      }
    }
    Log.d("MicroMsg.AppBrand.ThumbPlayerExt", "setDataSourceWorkaround, headersSet: ".concat(String.valueOf(localMap)));
    paramITPPlayer.setDataSource(paramString, localMap);
    AppMethodBeat.o(207697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.a.a.b
 * JD-Core Version:    0.7.0.1
 */