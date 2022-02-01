package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderStat;", "", "()V", "TAG", "", "FolderCapacityStat", "PostMediaProcessStat", "PostStat", "SyncCropVideoStat", "VideoInvalidStat", "plugin-finder_release"})
public final class o
{
  private static final String TAG = "Finder.FinderStat";
  public static final o szW;
  
  static
  {
    AppMethodBeat.i(166636);
    szW = new o();
    TAG = "Finder.FinderStat";
    AppMethodBeat.o(166636);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderStat$FolderCapacityStat;", "", "()V", "id_folder", "", "logId", "", "reportCapacity", "", "folderSizeMap", "", "", "reportNormalFolderClearCost", "costTime", "reportNormalFolderMarkCost", "reportPostFolderClearCost", "plugin-finder_release"})
  public static final class a
  {
    private static final int guD = 18896;
    private static final long szX = 1267L;
    public static final a szY;
    
    static
    {
      AppMethodBeat.i(166608);
      szY = new a();
      guD = 18896;
      szX = 1267L;
      AppMethodBeat.o(166608);
    }
    
    public static void af(Map<String, Long> paramMap)
    {
      long l2 = 0L;
      AppMethodBeat.i(166604);
      p.h(paramMap, "folderSizeMap");
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
        localObject = o.szW;
        ae.i(o.cFB(), "report 18896: ".concat(String.valueOf(paramMap)));
        g.yxI.kvStat(guD, paramMap);
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
    
    public static void wM(long paramLong)
    {
      AppMethodBeat.i(166605);
      g.yxI.n(szX, 1L, 1L);
      g.yxI.n(szX, 2L, paramLong);
      o localo = o.szW;
      ae.d(o.cFB(), "reportNormalFolderClearCost " + szX + ", key:1,2, costTime:" + paramLong);
      AppMethodBeat.o(166605);
    }
    
    public static void wN(long paramLong)
    {
      AppMethodBeat.i(166606);
      g.yxI.n(szX, 3L, 1L);
      g.yxI.n(szX, 4L, paramLong);
      o localo = o.szW;
      ae.d(o.cFB(), "reportNormalFolderMarkCost " + szX + ", key:3,4, costTime:" + paramLong);
      AppMethodBeat.o(166606);
    }
    
    public static void wO(long paramLong)
    {
      AppMethodBeat.i(166607);
      g.yxI.n(szX, 5L, 1L);
      g.yxI.n(szX, 6L, paramLong);
      o localo = o.szW;
      ae.d(o.cFB(), "reportNormalFolderClearCost " + szX + ", key:5,6, costTime:" + paramLong);
      AppMethodBeat.o(166607);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderStat$PostMediaProcessStat;", "", "()V", "id_remux", "", "key_postTotalCost", "key_postTotalCostCount", "key_postUploadCost", "key_postUploadCostCount", "key_remuxCost", "key_remuxCount", "key_remuxFailed", "key_remuxSize", "key_remux_file_error", "key_remux_skip", "key_videoDuration", "key_zipCost", "key_zipCount", "key_zipFailed", "key_zipSize", "reportPostTotalCost", "", "cost", "reportPostUploadCost", "reportRemuxCost", "reportRemuxCount", "reportRemuxFailed", "reportRemuxOutputFileError", "reportRemuxSize", "size", "reportSkipRemuxCount", "reportVideoDuration", "durationMs", "reportZipCost", "reportZipCount", "reportZipFailed", "reportZipSize", "plugin-finder_release"})
  public static final class b
  {
    private static final long sAa = 0L;
    private static final long sAb = 1L;
    private static final long sAc = 2L;
    private static final long sAd = 3L;
    private static final long sAe = 4L;
    private static final long sAf = 5L;
    private static final long sAg = 6L;
    private static final long sAh = 7L;
    private static final long sAi = 8L;
    private static final long sAj = 34L;
    private static final long sAk = 36L;
    private static final long sAl = 9L;
    private static final long sAm = 10L;
    private static final long sAn = 11L;
    private static final long sAo = 12L;
    public static final b sAp;
    private static final long szZ = 1253L;
    
    static
    {
      AppMethodBeat.i(166620);
      sAp = new b();
      szZ = 1253L;
      sAb = 1L;
      sAc = 2L;
      sAd = 3L;
      sAe = 4L;
      sAf = 5L;
      sAg = 6L;
      sAh = 7L;
      sAi = 8L;
      sAj = 34L;
      sAk = 36L;
      sAl = 9L;
      sAm = 10L;
      sAn = 11L;
      sAo = 12L;
      AppMethodBeat.o(166620);
    }
    
    public static void cFC()
    {
      AppMethodBeat.i(166609);
      g.yxI.n(szZ, sAa, 1L);
      AppMethodBeat.o(166609);
    }
    
    public static void cFD()
    {
      AppMethodBeat.i(166611);
      g.yxI.n(szZ, sAc, 1L);
      AppMethodBeat.o(166611);
    }
    
    public static void cFE()
    {
      AppMethodBeat.i(203897);
      g.yxI.n(szZ, sAj, 1L);
      AppMethodBeat.o(203897);
    }
    
    public static void cFF()
    {
      AppMethodBeat.i(203898);
      g.yxI.n(szZ, sAk, 1L);
      AppMethodBeat.o(203898);
    }
    
    public static void cFG()
    {
      AppMethodBeat.i(166613);
      g.yxI.n(szZ, sAe, 1L);
      AppMethodBeat.o(166613);
    }
    
    public static void cFH()
    {
      AppMethodBeat.i(166615);
      g.yxI.n(szZ, sAg, 1L);
      AppMethodBeat.o(166615);
    }
    
    public static void wP(long paramLong)
    {
      AppMethodBeat.i(166610);
      g.yxI.n(szZ, sAb, paramLong);
      AppMethodBeat.o(166610);
    }
    
    public static void wQ(long paramLong)
    {
      AppMethodBeat.i(166612);
      g.yxI.n(szZ, sAd, paramLong);
      AppMethodBeat.o(166612);
    }
    
    public static void wR(long paramLong)
    {
      AppMethodBeat.i(166614);
      g.yxI.n(szZ, sAf, paramLong);
      AppMethodBeat.o(166614);
    }
    
    public static void wS(long paramLong)
    {
      AppMethodBeat.i(166616);
      g.yxI.n(szZ, sAh, paramLong);
      AppMethodBeat.o(166616);
    }
    
    public static void wT(long paramLong)
    {
      AppMethodBeat.i(166617);
      g.yxI.n(szZ, sAi, paramLong);
      AppMethodBeat.o(166617);
    }
    
    public static void wU(long paramLong)
    {
      AppMethodBeat.i(166618);
      g.yxI.n(szZ, sAn, 1L);
      g.yxI.n(szZ, sAo, paramLong);
      AppMethodBeat.o(166618);
    }
    
    public static void wV(long paramLong)
    {
      AppMethodBeat.i(166619);
      g.yxI.n(szZ, sAl, 1L);
      g.yxI.n(szZ, sAm, paramLong);
      AppMethodBeat.o(166619);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderStat$PostStat;", "", "()V", "id_remux", "", "key_postCount", "key_postFailed1", "key_postFailed2", "key_postFailed3", "key_postFailed4", "key_postFailedCount", "key_postFailedDelete", "key_postMediaProcCount", "key_postMediaProcFailedCount", "key_postNetSceneCount", "key_postNetSceneFailedCount", "key_postNetSceneSafeFailedCount", "key_postTryCount", "key_postTryFailedCount", "key_postUploadCount", "key_postUploadFailedCount", "key_postingDelete", "key_repost", "reportPostCount", "", "reportPostFailedCount", "reportPostFailedDeleteCount", "reportPostFailedStage1", "reportPostFailedStage2", "reportPostFailedStage3", "reportPostFailedStage4", "reportPostMediaProcCount", "reportPostMediaProcFailedCount", "reportPostNetSceneCount", "reportPostNetSceneFailedCount", "reportPostNetSceneSafeFailedCount", "reportPostTryCount", "reportPostTryFailedCount", "reportPostUploadCount", "reportPostUploadFailedCount", "reportPostingDeleteCount", "reportRepostCount", "plugin-finder_release"})
  public static final class c
  {
    private static final long sAA = 25L;
    private static final long sAB = 40L;
    private static final long sAC = 41L;
    private static final long sAD = 42L;
    private static final long sAE = 43L;
    private static final long sAF = 44L;
    private static final long sAG = 45L;
    private static final long sAH = 46L;
    public static final c sAI;
    private static final long sAq = 15L;
    private static final long sAr = 16L;
    private static final long sAs = 17L;
    private static final long sAt = 18L;
    private static final long sAu = 19L;
    private static final long sAv = 20L;
    private static final long sAw = 21L;
    private static final long sAx = 22L;
    private static final long sAy = 23L;
    private static final long sAz = 24L;
    private static final long szZ = 1253L;
    
    static
    {
      AppMethodBeat.i(166632);
      sAI = new c();
      szZ = 1253L;
      sAq = 15L;
      sAr = 16L;
      sAs = 17L;
      sAt = 18L;
      sAu = 19L;
      sAv = 20L;
      sAw = 21L;
      sAx = 22L;
      sAy = 23L;
      sAz = 24L;
      sAA = 25L;
      sAB = 40L;
      sAC = 41L;
      sAD = 42L;
      sAE = 43L;
      sAF = 44L;
      sAG = 45L;
      sAH = 46L;
      AppMethodBeat.o(166632);
    }
    
    public static void cFI()
    {
      AppMethodBeat.i(166621);
      g.yxI.n(szZ, sAq, 1L);
      AppMethodBeat.o(166621);
    }
    
    public static void cFJ()
    {
      AppMethodBeat.i(166622);
      g.yxI.n(szZ, sAr, 1L);
      AppMethodBeat.o(166622);
    }
    
    public static void cFK()
    {
      AppMethodBeat.i(166623);
      g.yxI.n(szZ, sAs, 1L);
      AppMethodBeat.o(166623);
    }
    
    public static void cFL()
    {
      AppMethodBeat.i(166624);
      g.yxI.n(szZ, sAt, 1L);
      AppMethodBeat.o(166624);
    }
    
    public static void cFM()
    {
      AppMethodBeat.i(166625);
      g.yxI.n(szZ, sAu, 1L);
      AppMethodBeat.o(166625);
    }
    
    public static void cFN()
    {
      AppMethodBeat.i(166626);
      g.yxI.n(szZ, sAv, 1L);
      AppMethodBeat.o(166626);
    }
    
    public static void cFO()
    {
      AppMethodBeat.i(166627);
      g.yxI.n(szZ, sAw, 1L);
      AppMethodBeat.o(166627);
    }
    
    public static void cFP()
    {
      AppMethodBeat.i(166628);
      g.yxI.n(szZ, sAx, 1L);
      AppMethodBeat.o(166628);
    }
    
    public static void cFQ()
    {
      AppMethodBeat.i(166629);
      g.yxI.n(szZ, sAy, 1L);
      AppMethodBeat.o(166629);
    }
    
    public static void cFR()
    {
      AppMethodBeat.i(166630);
      g.yxI.n(szZ, sAz, 1L);
      AppMethodBeat.o(166630);
    }
    
    public static void cFS()
    {
      AppMethodBeat.i(166631);
      g.yxI.n(szZ, sAA, 1L);
      AppMethodBeat.o(166631);
    }
    
    public static void cFT()
    {
      AppMethodBeat.i(203899);
      g.yxI.n(szZ, sAB, 1L);
      AppMethodBeat.o(203899);
    }
    
    public static void cFU()
    {
      AppMethodBeat.i(203900);
      g.yxI.n(szZ, sAC, 1L);
      AppMethodBeat.o(203900);
    }
    
    public static void cFV()
    {
      AppMethodBeat.i(203901);
      g.yxI.n(szZ, sAD, 1L);
      AppMethodBeat.o(203901);
    }
    
    public static void cFW()
    {
      AppMethodBeat.i(203902);
      g.yxI.n(szZ, sAE, 1L);
      AppMethodBeat.o(203902);
    }
    
    public static void cFX()
    {
      AppMethodBeat.i(203903);
      g.yxI.n(szZ, sAF, 1L);
      AppMethodBeat.o(203903);
    }
    
    public static void cFY()
    {
      AppMethodBeat.i(203904);
      g.yxI.n(szZ, sAG, 1L);
      AppMethodBeat.o(203904);
    }
    
    public static void cFZ()
    {
      AppMethodBeat.i(203905);
      g.yxI.n(szZ, sAH, 1L);
      AppMethodBeat.o(203905);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderStat$SyncCropVideoStat;", "", "()V", "id_syncCrop", "", "key_syncCropCost", "key_syncCropCount", "logId", "", "reportSyncCrop", "", "cost", "reportSyncCropKv", "originMediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "targetMediaInfo", "originFileSize", "targetFileSize", "ret", "plugin-finder_release"})
  public static final class d
  {
    private static final int guD = 19063;
    private static final long sAJ = 1253L;
    private static final long sAK = 30L;
    private static final long sAL = 31L;
    public static final d sAM;
    
    static
    {
      AppMethodBeat.i(166635);
      sAM = new d();
      sAJ = 1253L;
      sAK = 30L;
      sAL = 31L;
      guD = 19063;
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
        parama2 = o.szW;
        ae.i(o.cFB(), "report 19063: ".concat(String.valueOf(parama1)));
        g.yxI.kvStat(guD, parama1);
        AppMethodBeat.o(166634);
        return;
      }
    }
    
    public static void wW(long paramLong)
    {
      AppMethodBeat.i(166633);
      g.yxI.n(sAJ, sAK, 1L);
      g.yxI.n(sAJ, sAL, paramLong);
      AppMethodBeat.o(166633);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderStat$VideoInvalidStat;", "", "()V", "idkeyId", "", "kvLogId", "", "reportVideo", "", "videoMime", "", "audioMime", "path", "plugin-finder_release"})
  public static final class e
  {
    private static final int sAN = 19441;
    private static final long sAO = 1253L;
    public static final e sAP;
    
    static
    {
      AppMethodBeat.i(178399);
      sAP = new e();
      sAN = 19441;
      sAO = 1253L;
      AppMethodBeat.o(178399);
    }
    
    public static void ac(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(178398);
      g localg = g.yxI;
      int i = sAN;
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      paramString2 = paramString3;
      if (paramString3 == null) {
        paramString2 = "";
      }
      localg.f(i, new Object[] { str, paramString1, paramString2 });
      g.yxI.n(sAO, 33L, 1L);
      AppMethodBeat.o(178398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.o
 * JD-Core Version:    0.7.0.1
 */