package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter;", "", "()V", "TAG", "", "isChangeTab", "", "reportedData", "", "Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter$RecordData;", "kotlin.jvm.PlatformType", "", "videoDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getData", "feedId", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "notifyChangeTab", "", "notifyDecodeStart", "(Ljava/lang/Long;)V", "notifyFirstVideoFrameRendered", "notifyVideoDownload", "notifyVideoFirstFrame", "notifyVideoPause", "notifyVideoPlay", "RecordData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final p FpQ;
  public static final ConcurrentHashMap<Long, p.a> FpR;
  public static final Set<p.a> FpS;
  private static boolean FpT;
  
  static
  {
    AppMethodBeat.i(331506);
    FpQ = new p();
    FpR = new ConcurrentHashMap();
    FpS = Collections.synchronizedSet((Set)new HashSet());
    AppMethodBeat.o(331506);
  }
  
  public static void eMB()
  {
    FpT = true;
  }
  
  public static void h(Long paramLong)
  {
    AppMethodBeat.i(331489);
    if (paramLong == null)
    {
      AppMethodBeat.o(331489);
      return;
    }
    paramLong.longValue();
    p.a locala = pB(paramLong.longValue());
    int i;
    if (locala.FpW == 0L)
    {
      i = 1;
      label39:
      if (i == 0) {
        break label69;
      }
      label43:
      if (locala != null) {
        break label74;
      }
      locala = null;
    }
    for (;;)
    {
      if (locala != null) {
        break label84;
      }
      FpR.remove(paramLong);
      break;
      i = 0;
      break label39;
      label69:
      locala = null;
      break label43;
      label74:
      locala.FpW = cn.bDw();
    }
    label84:
    AppMethodBeat.o(331489);
  }
  
  public static void i(Long paramLong)
  {
    AppMethodBeat.i(331496);
    if (paramLong == null)
    {
      AppMethodBeat.o(331496);
      return;
    }
    paramLong.longValue();
    p.a locala = pB(paramLong.longValue());
    if (locala.FpU == 0L)
    {
      i = 1;
      label39:
      if (i == 0) {
        break label69;
      }
    }
    for (;;)
    {
      if (locala != null) {
        break label74;
      }
      locala = null;
      if (locala != null) {
        break label106;
      }
      FpR.remove(paramLong);
      break;
      i = 0;
      break label39;
      label69:
      locala = null;
    }
    label74:
    locala.FpU = cn.bDw();
    if (FpT) {}
    for (int i = 1;; i = 2)
    {
      locala.Fqa = i;
      FpT = false;
      break;
    }
    label106:
    AppMethodBeat.o(331496);
  }
  
  public static p.a pB(long paramLong)
  {
    AppMethodBeat.i(331500);
    p.a locala2 = (p.a)FpR.get(Long.valueOf(paramLong));
    p.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new p.a();
      ((Map)FpR).put(Long.valueOf(paramLong), locala1);
    }
    AppMethodBeat.o(331500);
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.p
 * JD-Core Version:    0.7.0.1
 */