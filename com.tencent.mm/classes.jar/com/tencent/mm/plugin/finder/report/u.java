package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ex;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderSnsPostReporter;", "", "()V", "SCENE_ENTRANCE_CLICK", "", "SCENE_ENTRANCE_EXPOSE", "SCENE_NO_ACCOUNT_EXIT", "SCENE_NO_ACCOUNT_OK", "SCENE_NO_POST_EXIT", "SCENE_NO_POST_OK", "SCENE_SELECT_EXIT", "SCENE_SELECT_FEED", "SCENE_SNS_POST_CANCEL", "SCENE_SNS_POST_SUCCESS", "reportSessionID", "", "getReportSessionID", "()Ljava/lang/String;", "setReportSessionID", "(Ljava/lang/String;)V", "report20747", "", "sessionID", "scene", "wording", "haveFinderAccount", "", "havePostFinder", "feedId", "", "shootEntranceEndType", "entranceExposeMaxTimes", "entranceExposedTimes", "snsId", "timeStamp", "exposeType", "plugin-finder_release"})
public final class u
{
  private static String zXL;
  public static final u zXM;
  
  static
  {
    AppMethodBeat.i(282141);
    zXM = new u();
    AppMethodBeat.o(282141);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, int paramInt5)
  {
    AppMethodBeat.i(282140);
    p.k(paramString1, "sessionID");
    p.k(paramString2, "wording");
    if (paramInt1 == 2) {
      zXL = paramString1;
    }
    ex localex = new ex();
    localex.to(paramString1);
    localex.ms(paramInt1);
    localex.mt(paramLong3);
    localex.mu(paramInt2);
    paramString1 = n.zWF;
    localex.tq(n.Mp(paramLong2));
    paramString1 = n.zWF;
    localex.tp(n.Mp(paramLong1));
    paramString1 = z.bdh();
    localex.mx(paramInt3);
    localex.my(paramInt4);
    if (Util.isNullOrNil(paramString1))
    {
      paramLong1 = 0L;
      localex.mv(paramLong1);
      if (localex.akh() != 1L) {
        break label243;
      }
      k.a locala = k.Anu;
      p.j(paramString1, "username");
      if (((Collection)locala.ed(paramString1, 1)).isEmpty()) {
        break label238;
      }
      paramInt1 = 1;
      label177:
      if (paramInt1 == 0) {
        break label243;
      }
    }
    label238:
    label243:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localex.mw(paramLong1);
      localex.tr(paramString2);
      localex.mz(paramInt5);
      localex.bpa();
      paramString1 = n.zWF;
      n.a((a)localex);
      AppMethodBeat.o(282140);
      return;
      paramLong1 = 1L;
      break;
      paramInt1 = 0;
      break label177;
    }
  }
  
  public static String dQb()
  {
    return zXL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.u
 * JD-Core Version:    0.7.0.1
 */