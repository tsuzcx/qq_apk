package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderFeedCardReporter;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderFeedCardReporter;", "()V", "ENTERSESSION_MULTI_CHAT", "", "ENTERSESSION_SINGLE_CHAT", "ENTERSESSION_SNS", "enterTimeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "report22144", "", "entersession", "cardType", "sourceUsr", "", "feedIdStr", "updateSceneEnterTime", "plugin-finder_release"})
public final class f
  implements com.tencent.mm.plugin.findersdk.a.p
{
  private static final HashMap<Integer, Long> zUO;
  public static final f zUP;
  
  static
  {
    AppMethodBeat.i(287305);
    zUP = new f();
    zUO = new HashMap();
    AppMethodBeat.o(287305);
  }
  
  public final void Pf(int paramInt)
  {
    AppMethodBeat.i(287303);
    ((Map)zUO).put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(287303);
  }
  
  public final void y(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(287304);
    kotlin.g.b.p.k(paramString1, "sourceUsr");
    kotlin.g.b.p.k(paramString2, "feedIdStr");
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt).append('-');
    Object localObject2 = ((Map)zUO).get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(0L);
    }
    localObject1 = ((Number)localObject1).longValue();
    Log.i("FinderFeedCardReporter", "report22144 entersessionId=" + (String)localObject1 + ", entersession=" + paramInt + ", eventTime=" + l + ", cardType=1, sourceUsr=" + paramString1 + ", feedId=" + paramString2);
    h.IzE.a(22144, new Object[] { localObject1, Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(1), paramString1, paramString2 });
    AppMethodBeat.o(287304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.f
 * JD-Core Version:    0.7.0.1
 */