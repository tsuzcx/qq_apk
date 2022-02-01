package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.Collection;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderSnsPostReporter;", "", "()V", "SCENE_ENTRANCE_CLICK", "", "SCENE_ENTRANCE_EXPOSE", "SCENE_NO_ACCOUNT_EXIT", "SCENE_NO_ACCOUNT_OK", "SCENE_NO_POST_EXIT", "SCENE_NO_POST_OK", "SCENE_SELECT_EXIT", "SCENE_SELECT_FEED", "SCENE_SNS_POST_CANCEL", "SCENE_SNS_POST_SUCCESS", "reportSessionID", "", "getReportSessionID", "()Ljava/lang/String;", "setReportSessionID", "(Ljava/lang/String;)V", "report20747", "", "sessionID", "scene", "wording", "haveFinderAccount", "", "havePostFinder", "feedId", "", "shootEntranceEndType", "entranceExposeMaxTimes", "entranceExposedTimes", "snsId", "timeStamp", "exposeType", "plugin-finder_release"})
public final class n
{
  private static String szU;
  public static final n szV;
  
  static
  {
    AppMethodBeat.i(203896);
    szV = new n();
    AppMethodBeat.o(203896);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, int paramInt5)
  {
    AppMethodBeat.i(203895);
    p.h(paramString1, "sessionID");
    p.h(paramString2, "wording");
    if (paramInt1 == 2) {
      szU = paramString1;
    }
    bt localbt = new bt();
    localbt.kV(paramString1);
    localbt.gF(paramInt1);
    localbt.gG(paramLong3);
    localbt.gH(paramInt2);
    paramString1 = i.syT;
    localbt.kX(i.wL(paramLong2));
    paramString1 = i.syT;
    localbt.kW(i.wL(paramLong1));
    paramString1 = v.aAK();
    localbt.gK(paramInt3);
    localbt.gL(paramInt4);
    if (bu.isNullOrNil(paramString1))
    {
      paramLong1 = 0L;
      localbt.gI(paramLong1);
      if (localbt.St() != 1L) {
        break label241;
      }
      k.a locala = k.sLb;
      p.g(paramString1, "username");
      if (((Collection)k.a.dx(paramString1, 1)).isEmpty()) {
        break label236;
      }
      paramInt1 = 1;
      label175:
      if (paramInt1 == 0) {
        break label241;
      }
    }
    label236:
    label241:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localbt.gJ(paramLong1);
      localbt.kY(paramString2);
      localbt.gM(paramInt5);
      localbt.aLH();
      paramString1 = i.syT;
      i.a((a)localbt);
      AppMethodBeat.o(203895);
      return;
      paramLong1 = 1L;
      break;
      paramInt1 = 0;
      break label175;
    }
  }
  
  public static String cFA()
  {
    return szU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.n
 * JD-Core Version:    0.7.0.1
 */