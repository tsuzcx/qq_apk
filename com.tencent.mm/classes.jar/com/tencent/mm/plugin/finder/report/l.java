package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderFeedCardReporter;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderFeedCardReporter;", "()V", "ENTERSESSION_MULTI_CHAT", "", "ENTERSESSION_SINGLE_CHAT", "ENTERSESSION_SNS", "enterTimeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "report22144", "", "entersession", "cardType", "sourceUsr", "", "feedIdStr", "updateSceneEnterTime", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements ae
{
  public static final l Fpv;
  private static final HashMap<Integer, Long> Fpw;
  
  static
  {
    AppMethodBeat.i(331395);
    Fpv = new l();
    Fpw = new HashMap();
    AppMethodBeat.o(331395);
  }
  
  public final void E(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(331412);
    s.u(paramString1, "sourceUsr");
    s.u(paramString2, "feedIdStr");
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt).append('-');
    Object localObject2 = ((Map)Fpw).get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(0L);
    }
    localObject1 = ((Number)localObject1).longValue();
    Log.i("FinderFeedCardReporter", "report22144 entersessionId=" + (String)localObject1 + ", entersession=" + paramInt + ", eventTime=" + l + ", cardType=1, sourceUsr=" + paramString1 + ", feedId=" + paramString2);
    h.OAn.b(22144, new Object[] { localObject1, Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(1), paramString1, paramString2 });
    AppMethodBeat.o(331412);
  }
  
  public final void Sh(int paramInt)
  {
    AppMethodBeat.i(331401);
    ((Map)Fpw).put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(331401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.l
 * JD-Core Version:    0.7.0.1
 */