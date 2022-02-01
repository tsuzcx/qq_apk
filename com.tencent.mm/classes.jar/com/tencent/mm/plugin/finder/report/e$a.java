package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderStat$FolderCapacityStat;", "", "()V", "id_folder", "", "logId", "", "reportCapacity", "", "folderSizeMap", "", "", "reportNormalFolderClearCost", "costTime", "reportNormalFolderMarkCost", "reportPostFolderClearCost", "plugin-finder_release"})
public final class e$a
{
  private static final int fUL = 18896;
  private static final long qFt = 1267L;
  public static final a qFu;
  
  static
  {
    AppMethodBeat.i(166608);
    qFu = new a();
    fUL = 18896;
    qFt = 1267L;
    AppMethodBeat.o(166608);
  }
  
  public static void V(Map<String, Long> paramMap)
  {
    long l2 = 0L;
    AppMethodBeat.i(166604);
    k.h(paramMap, "folderSizeMap");
    Object localObject = new StringBuilder();
    Long localLong = (Long)paramMap.get("finderAccPath");
    if (localLong != null)
    {
      l1 = localLong.longValue();
      localObject = ((StringBuilder)localObject).append(l1).append(',');
      localLong = (Long)paramMap.get("finderPostPath");
      if (localLong == null) {
        break label429;
      }
      l1 = localLong.longValue();
      label83:
      localObject = ((StringBuilder)localObject).append(l1).append(',');
      localLong = (Long)paramMap.get("finderImgPath");
      if (localLong == null) {
        break label434;
      }
      l1 = localLong.longValue();
      label120:
      localObject = ((StringBuilder)localObject).append(l1).append(',');
      localLong = (Long)paramMap.get("finderVideoPath");
      if (localLong == null) {
        break label439;
      }
      l1 = localLong.longValue();
      label157:
      localObject = ((StringBuilder)localObject).append(l1).append(',');
      localLong = (Long)paramMap.get("finderAvatarPath");
      if (localLong == null) {
        break label444;
      }
      l1 = localLong.longValue();
      label194:
      localObject = ((StringBuilder)localObject).append(l1).append(',');
      localLong = (Long)paramMap.get("finderCoverImagePath");
      if (localLong == null) {
        break label449;
      }
      l1 = localLong.longValue();
      label231:
      localObject = ((StringBuilder)localObject).append(l1).append(',');
      localLong = (Long)paramMap.get("finderTmpPath");
      if (localLong == null) {
        break label454;
      }
      l1 = localLong.longValue();
      label268:
      localObject = ((StringBuilder)localObject).append(l1).append(',');
      localLong = (Long)paramMap.get("finderCapturePath");
      if (localLong == null) {
        break label459;
      }
      l1 = localLong.longValue();
      label305:
      localObject = ((StringBuilder)localObject).append(l1).append(',');
      localLong = (Long)paramMap.get("finderPostMediaDir");
      if (localLong == null) {
        break label464;
      }
    }
    label429:
    label434:
    label439:
    label444:
    label449:
    label454:
    label459:
    label464:
    for (long l1 = localLong.longValue();; l1 = 0L)
    {
      localObject = ((StringBuilder)localObject).append(l1).append(',');
      paramMap = (Long)paramMap.get("finderPostMediaTmpDir");
      l1 = l2;
      if (paramMap != null) {
        l1 = paramMap.longValue();
      }
      paramMap = l1;
      localObject = e.qFs;
      ad.i(e.cnC(), "report 18896: ".concat(String.valueOf(paramMap)));
      h.vKh.kvStat(fUL, paramMap);
      AppMethodBeat.o(166604);
      return;
      l1 = 0L;
      break;
      l1 = 0L;
      break label83;
      l1 = 0L;
      break label120;
      l1 = 0L;
      break label157;
      l1 = 0L;
      break label194;
      l1 = 0L;
      break label231;
      l1 = 0L;
      break label268;
      l1 = 0L;
      break label305;
    }
  }
  
  public static void qj(long paramLong)
  {
    AppMethodBeat.i(166605);
    h.vKh.m(qFt, 1L, 1L);
    h.vKh.m(qFt, 2L, paramLong);
    e locale = e.qFs;
    ad.d(e.cnC(), "reportNormalFolderClearCost " + qFt + ", key:1,2, costTime:" + paramLong);
    AppMethodBeat.o(166605);
  }
  
  public static void qk(long paramLong)
  {
    AppMethodBeat.i(166606);
    h.vKh.m(qFt, 3L, 1L);
    h.vKh.m(qFt, 4L, paramLong);
    e locale = e.qFs;
    ad.d(e.cnC(), "reportNormalFolderMarkCost " + qFt + ", key:3,4, costTime:" + paramLong);
    AppMethodBeat.o(166606);
  }
  
  public static void ql(long paramLong)
  {
    AppMethodBeat.i(166607);
    h.vKh.m(qFt, 5L, 1L);
    h.vKh.m(qFt, 6L, paramLong);
    e locale = e.qFs;
    ad.d(e.cnC(), "reportNormalFolderClearCost " + qFt + ", key:5,6, costTime:" + paramLong);
    AppMethodBeat.o(166607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.e.a
 * JD-Core Version:    0.7.0.1
 */