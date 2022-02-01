package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.gl;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderSnsPostReporter;", "", "()V", "SCENE_ENTRANCE_CLICK", "", "SCENE_ENTRANCE_EXPOSE", "SCENE_NO_ACCOUNT_EXIT", "SCENE_NO_ACCOUNT_OK", "SCENE_NO_POST_EXIT", "SCENE_NO_POST_OK", "SCENE_SELECT_EXIT", "SCENE_SELECT_FEED", "SCENE_SNS_POST_CANCEL", "SCENE_SNS_POST_SUCCESS", "reportSessionID", "", "getReportSessionID", "()Ljava/lang/String;", "setReportSessionID", "(Ljava/lang/String;)V", "report20747", "", "sessionID", "scene", "wording", "haveFinderAccount", "", "havePostFinder", "feedId", "", "shootEntranceEndType", "entranceExposeMaxTimes", "entranceExposedTimes", "snsId", "timeStamp", "exposeType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
{
  public static final ag Ftp;
  private static String Ftq;
  
  static
  {
    AppMethodBeat.i(331340);
    Ftp = new ag();
    AppMethodBeat.o(331340);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, int paramInt5)
  {
    AppMethodBeat.i(331333);
    s.u(paramString1, "sessionID");
    s.u(paramString2, "wording");
    if (paramInt1 == 2) {
      Ftq = paramString1;
    }
    gl localgl = new gl();
    localgl.rd(paramString1);
    localgl.iqr = paramInt1;
    localgl.iKV = paramLong3;
    localgl.iKW = paramInt2;
    paramString1 = z.FrZ;
    localgl.re(z.pL(paramLong2));
    paramString1 = z.FrZ;
    localgl.iEf = localgl.F("SnsFeedId", z.pL(paramLong1), true);
    paramString1 = com.tencent.mm.model.z.bAW();
    localgl.iLb = paramInt3;
    localgl.iLc = paramInt4;
    if (Util.isNullOrNil(paramString1))
    {
      paramLong1 = 0L;
      localgl.iKY = paramLong1;
      if (localgl.iKY != 1L) {
        break label242;
      }
      k.a locala = k.FNg;
      s.s(paramString1, "username");
      if (((Collection)locala.eO(paramString1, 1)).isEmpty()) {
        break label237;
      }
      paramInt1 = 1;
      label178:
      if (paramInt1 == 0) {
        break label242;
      }
    }
    label237:
    label242:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localgl.iKZ = paramLong1;
      localgl.rf(paramString2);
      localgl.iCk = paramInt5;
      localgl.bMH();
      paramString1 = z.FrZ;
      z.a((a)localgl);
      AppMethodBeat.o(331333);
      return;
      paramLong1 = 1L;
      break;
      paramInt1 = 0;
      break label178;
    }
  }
  
  public static String eNy()
  {
    return Ftq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ag
 * JD-Core Version:    0.7.0.1
 */