package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/FinderStat$SyncCropVideoStat;", "", "()V", "id_syncCrop", "", "key_syncCropCost", "key_syncCropCount", "logId", "", "reportSyncCrop", "", "cost", "reportSyncCropKv", "originMediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "targetMediaInfo", "originFileSize", "targetFileSize", "ret", "plugin-finder_release"})
public final class e$d
{
  private static final int fUL = 19063;
  private static final long qFW = 1253L;
  private static final long qFX = 30L;
  private static final long qFY = 31L;
  public static final d qFZ;
  
  static
  {
    AppMethodBeat.i(166635);
    qFZ = new d();
    qFW = 1253L;
    qFX = 30L;
    qFY = 31L;
    fUL = 19063;
    AppMethodBeat.o(166635);
  }
  
  public static void a(a parama1, a parama2, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(166634);
    if (parama1 != null)
    {
      parama1 = parama1.getVideoDuration() + ',' + parama1.width + ',' + parama1.height + ',' + paramInt1 + ',' + parama1.videoBitrate + ',';
      if (parama2 != null) {
        break label166;
      }
    }
    label166:
    for (parama1 = parama1 + "0,0,0,0,0,";; parama1 = parama1 + parama2.getVideoDuration() + ',' + parama2.width + ',' + parama2.height + ',' + paramInt2 + ',' + parama2.videoBitrate)
    {
      parama1 = parama1 + paramLong + ',' + paramInt3;
      parama2 = e.qFs;
      ad.i(e.cnC(), "report 19063: ".concat(String.valueOf(parama1)));
      h.vKh.kvStat(fUL, parama1);
      AppMethodBeat.o(166634);
      return;
    }
  }
  
  public static void qt(long paramLong)
  {
    AppMethodBeat.i(166633);
    h.vKh.m(qFW, qFX, 1L);
    h.vKh.m(qFW, qFY, paramLong);
    AppMethodBeat.o(166633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.e.d
 * JD-Core Version:    0.7.0.1
 */