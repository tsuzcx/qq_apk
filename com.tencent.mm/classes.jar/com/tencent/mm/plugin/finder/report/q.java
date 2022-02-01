package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ea;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderSnsPostReporter;", "", "()V", "SCENE_ENTRANCE_CLICK", "", "SCENE_ENTRANCE_EXPOSE", "SCENE_NO_ACCOUNT_EXIT", "SCENE_NO_ACCOUNT_OK", "SCENE_NO_POST_EXIT", "SCENE_NO_POST_OK", "SCENE_SELECT_EXIT", "SCENE_SELECT_FEED", "SCENE_SNS_POST_CANCEL", "SCENE_SNS_POST_SUCCESS", "reportSessionID", "", "getReportSessionID", "()Ljava/lang/String;", "setReportSessionID", "(Ljava/lang/String;)V", "report20747", "", "sessionID", "scene", "wording", "haveFinderAccount", "", "havePostFinder", "feedId", "", "shootEntranceEndType", "entranceExposeMaxTimes", "entranceExposedTimes", "snsId", "timeStamp", "exposeType", "plugin-finder_release"})
public final class q
{
  private static String vgD;
  public static final q vgE;
  
  static
  {
    AppMethodBeat.i(250755);
    vgE = new q();
    AppMethodBeat.o(250755);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, int paramInt5)
  {
    AppMethodBeat.i(250754);
    p.h(paramString1, "sessionID");
    p.h(paramString2, "wording");
    if (paramInt1 == 2) {
      vgD = paramString1;
    }
    ea localea = new ea();
    localea.qm(paramString1);
    localea.lg(paramInt1);
    localea.lh(paramLong3);
    localea.li(paramInt2);
    paramString1 = k.vfA;
    localea.qo(k.Fg(paramLong2));
    paramString1 = k.vfA;
    localea.qn(k.Fg(paramLong1));
    paramString1 = z.aUg();
    localea.ll(paramInt3);
    localea.lm(paramInt4);
    if (Util.isNullOrNil(paramString1))
    {
      paramLong1 = 0L;
      localea.lj(paramLong1);
      if (localea.afk() != 1L) {
        break label243;
      }
      l.a locala = com.tencent.mm.plugin.finder.storage.data.l.vGw;
      p.g(paramString1, "username");
      if (((Collection)locala.dG(paramString1, 1)).isEmpty()) {
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
      localea.lk(paramLong1);
      localea.qp(paramString2);
      localea.ln(paramInt5);
      localea.bfK();
      paramString1 = k.vfA;
      k.a((a)localea);
      AppMethodBeat.o(250754);
      return;
      paramLong1 = 1L;
      break;
      paramInt1 = 0;
      break label177;
    }
  }
  
  public static String dot()
  {
    return vgD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.q
 * JD-Core Version:    0.7.0.1
 */