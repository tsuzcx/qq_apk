package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderStat$FolderCapacityStat;", "", "()V", "id_folder", "", "logId", "", "reportCapacity", "", "folderSizeMap", "", "", "reportNormalFolderClearCost", "costTime", "reportNormalFolderMarkCost", "reportPostFolderClearCost", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah$a
{
  public static final a Fts;
  private static final long Ftt;
  private static final int mtI;
  
  static
  {
    AppMethodBeat.i(166608);
    Fts = new a();
    mtI = 18896;
    Ftt = 1267L;
    AppMethodBeat.o(166608);
  }
  
  public static void ao(Map<String, Long> paramMap)
  {
    long l2 = 0L;
    AppMethodBeat.i(166604);
    s.u(paramMap, "folderSizeMap");
    StringBuilder localStringBuilder = new StringBuilder();
    Long localLong = (Long)paramMap.get("finderAccPath");
    if (localLong == null)
    {
      l1 = 0L;
      localStringBuilder = localStringBuilder.append(l1).append(',');
      localLong = (Long)paramMap.get("finderPostPath");
      if (localLong != null) {
        break label384;
      }
      l1 = 0L;
      label75:
      localStringBuilder = localStringBuilder.append(l1).append(',');
      localLong = (Long)paramMap.get("finderImgPath");
      if (localLong != null) {
        break label393;
      }
      l1 = 0L;
      label108:
      localStringBuilder = localStringBuilder.append(l1).append(',');
      localLong = (Long)paramMap.get("finderVideoPath");
      if (localLong != null) {
        break label402;
      }
      l1 = 0L;
      label141:
      localStringBuilder = localStringBuilder.append(l1).append(',');
      localLong = (Long)paramMap.get("finderAvatarPath");
      if (localLong != null) {
        break label411;
      }
      l1 = 0L;
      label174:
      localStringBuilder = localStringBuilder.append(l1).append(',');
      localLong = (Long)paramMap.get("finderCoverImagePath");
      if (localLong != null) {
        break label420;
      }
      l1 = 0L;
      label207:
      localStringBuilder = localStringBuilder.append(l1).append(',');
      localLong = (Long)paramMap.get("finderTmpPath");
      if (localLong != null) {
        break label429;
      }
      l1 = 0L;
      label240:
      localStringBuilder = localStringBuilder.append(l1).append(',');
      localLong = (Long)paramMap.get("finderCapturePath");
      if (localLong != null) {
        break label438;
      }
      l1 = 0L;
      label273:
      localStringBuilder = localStringBuilder.append(l1).append(',');
      localLong = (Long)paramMap.get("finderPostMediaDir");
      if (localLong != null) {
        break label447;
      }
      l1 = 0L;
      label306:
      localStringBuilder = localStringBuilder.append(l1).append(',');
      paramMap = (Long)paramMap.get("finderPostMediaTmpDir");
      if (paramMap != null) {
        break label456;
      }
    }
    label384:
    label393:
    label402:
    label411:
    label420:
    label429:
    label438:
    label447:
    label456:
    for (long l1 = l2;; l1 = paramMap.longValue())
    {
      paramMap = l1;
      Log.i(ah.aUw(), s.X("report 18896: ", paramMap));
      h.OAn.kvStat(mtI, paramMap);
      AppMethodBeat.o(166604);
      return;
      l1 = localLong.longValue();
      break;
      l1 = localLong.longValue();
      break label75;
      l1 = localLong.longValue();
      break label108;
      l1 = localLong.longValue();
      break label141;
      l1 = localLong.longValue();
      break label174;
      l1 = localLong.longValue();
      break label207;
      l1 = localLong.longValue();
      break label240;
      l1 = localLong.longValue();
      break label273;
      l1 = localLong.longValue();
      break label306;
    }
  }
  
  public static void pN(long paramLong)
  {
    AppMethodBeat.i(166607);
    h.OAn.p(Ftt, 5L, 1L);
    h.OAn.p(Ftt, 6L, paramLong);
    Log.d(ah.aUw(), "reportNormalFolderClearCost " + Ftt + ", key:5,6, costTime:" + paramLong);
    AppMethodBeat.o(166607);
  }
  
  public static void pr(long paramLong)
  {
    AppMethodBeat.i(166606);
    h.OAn.p(Ftt, 3L, 1L);
    h.OAn.p(Ftt, 4L, paramLong);
    Log.d(ah.aUw(), "reportNormalFolderMarkCost " + Ftt + ", key:3,4, costTime:" + paramLong);
    AppMethodBeat.o(166606);
  }
  
  public static void ps(long paramLong)
  {
    AppMethodBeat.i(166605);
    h.OAn.p(Ftt, 1L, 1L);
    h.OAn.p(Ftt, 2L, paramLong);
    Log.d(ah.aUw(), "reportNormalFolderClearCost " + Ftt + ", key:1,2, costTime:" + paramLong);
    AppMethodBeat.o(166605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ah.a
 * JD-Core Version:    0.7.0.1
 */