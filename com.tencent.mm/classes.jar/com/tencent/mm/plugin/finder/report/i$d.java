package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderStat$SyncCropVideoStat;", "", "()V", "id_syncCrop", "", "key_syncCropCost", "key_syncCropCount", "logId", "", "reportSyncCrop", "", "cost", "reportSyncCropKv", "originMediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "targetMediaInfo", "originFileSize", "targetFileSize", "ret", "plugin-finder_release"})
public final class i$d
{
  private static final int fYG = 19063;
  private static final long ryQ = 1253L;
  private static final long ryR = 30L;
  private static final long ryS = 31L;
  public static final d ryT;
  
  static
  {
    AppMethodBeat.i(166635);
    ryT = new d();
    ryQ = 1253L;
    ryR = 30L;
    ryS = 31L;
    fYG = 19063;
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
      parama2 = i.ryl;
      ac.i(i.cwX(), "report 19063: ".concat(String.valueOf(parama1)));
      h.wUl.kvStat(fYG, parama1);
      AppMethodBeat.o(166634);
      return;
    }
  }
  
  public static void uE(long paramLong)
  {
    AppMethodBeat.i(166633);
    h.wUl.n(ryQ, ryR, 1L);
    h.wUl.n(ryQ, ryS, paramLong);
    AppMethodBeat.o(166633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.i.d
 * JD-Core Version:    0.7.0.1
 */