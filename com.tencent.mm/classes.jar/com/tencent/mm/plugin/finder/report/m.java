package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.report.a;
import d.g.b.p;
import d.l;
import java.util.Collection;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderSnsPostReporter;", "", "()V", "SCENE_ENTRANCE_CLICK", "", "SCENE_ENTRANCE_EXPOSE", "SCENE_NO_ACCOUNT_EXIT", "SCENE_NO_ACCOUNT_OK", "SCENE_NO_POST_EXIT", "SCENE_NO_POST_OK", "SCENE_SELECT_EXIT", "SCENE_SELECT_FEED", "SCENE_SNS_POST_CANCEL", "SCENE_SNS_POST_SUCCESS", "reportSessionID", "", "getReportSessionID", "()Ljava/lang/String;", "setReportSessionID", "(Ljava/lang/String;)V", "report20747", "", "sessionID", "scene", "wording", "haveFinderAccount", "", "havePostFinder", "feedId", "", "shootEntranceEndType", "entranceExposeMaxTimes", "entranceExposedTimes", "snsId", "timeStamp", "plugin-finder_release"})
public final class m
{
  private static String spJ;
  public static final m spK;
  
  static
  {
    AppMethodBeat.i(203337);
    spK = new m();
    AppMethodBeat.o(203337);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(203336);
    p.h(paramString1, "sessionID");
    p.h(paramString2, "wording");
    if (paramInt1 == 2) {
      spJ = paramString1;
    }
    com.tencent.mm.g.b.a.bt localbt = new com.tencent.mm.g.b.a.bt();
    localbt.kI(paramString1);
    localbt.gB(paramInt1);
    localbt.gC(paramLong3);
    localbt.gD(paramInt2);
    paramString1 = h.soM;
    localbt.kK(h.wu(paramLong2));
    paramString1 = h.soM;
    localbt.kJ(h.wu(paramLong1));
    paramString1 = u.aAu();
    localbt.gG(paramInt3);
    localbt.gH(paramInt4);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString1))
    {
      paramLong1 = 0L;
      localbt.gE(paramLong1);
      if (localbt.Sv() != 1L) {
        break label232;
      }
      k.a locala = k.sAe;
      p.g(paramString1, "username");
      if (((Collection)k.a.ds(paramString1, 1)).isEmpty()) {
        break label227;
      }
      paramInt1 = 1;
      label175:
      if (paramInt1 == 0) {
        break label232;
      }
    }
    label227:
    label232:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localbt.gF(paramLong1);
      localbt.kL(paramString2);
      localbt.aLk();
      paramString1 = h.soM;
      h.a((a)localbt);
      AppMethodBeat.o(203336);
      return;
      paramLong1 = 1L;
      break;
      paramInt1 = 0;
      break label175;
    }
  }
  
  public static String cDE()
  {
    return spJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.m
 * JD-Core Version:    0.7.0.1
 */