package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderStat;", "", "()V", "TAG", "", "FolderCapacityStat", "PostMediaProcessStat", "PostStat", "SyncCropVideoStat", "VideoInvalidStat", "plugin-finder_release"})
public final class n
{
  private static final String TAG = "Finder.FinderStat";
  public static final n spL;
  
  static
  {
    AppMethodBeat.i(166636);
    spL = new n();
    TAG = "Finder.FinderStat";
    AppMethodBeat.o(166636);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderStat$FolderCapacityStat;", "", "()V", "id_folder", "", "logId", "", "reportCapacity", "", "folderSizeMap", "", "", "reportNormalFolderClearCost", "costTime", "reportNormalFolderMarkCost", "reportPostFolderClearCost", "plugin-finder_release"})
  public static final class a
  {
    private static final int gsc = 18896;
    private static final long spM = 1267L;
    public static final a spN;
    
    static
    {
      AppMethodBeat.i(166608);
      spN = new a();
      gsc = 18896;
      spM = 1267L;
      AppMethodBeat.o(166608);
    }
    
    public static void Z(Map<String, Long> paramMap)
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
        localObject = n.spL;
        ad.i(n.cDF(), "report 18896: ".concat(String.valueOf(paramMap)));
        g.yhR.kvStat(gsc, paramMap);
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
    
    public static void wv(long paramLong)
    {
      AppMethodBeat.i(166605);
      g.yhR.n(spM, 1L, 1L);
      g.yhR.n(spM, 2L, paramLong);
      n localn = n.spL;
      ad.d(n.cDF(), "reportNormalFolderClearCost " + spM + ", key:1,2, costTime:" + paramLong);
      AppMethodBeat.o(166605);
    }
    
    public static void ww(long paramLong)
    {
      AppMethodBeat.i(166606);
      g.yhR.n(spM, 3L, 1L);
      g.yhR.n(spM, 4L, paramLong);
      n localn = n.spL;
      ad.d(n.cDF(), "reportNormalFolderMarkCost " + spM + ", key:3,4, costTime:" + paramLong);
      AppMethodBeat.o(166606);
    }
    
    public static void wx(long paramLong)
    {
      AppMethodBeat.i(166607);
      g.yhR.n(spM, 5L, 1L);
      g.yhR.n(spM, 6L, paramLong);
      n localn = n.spL;
      ad.d(n.cDF(), "reportNormalFolderClearCost " + spM + ", key:5,6, costTime:" + paramLong);
      AppMethodBeat.o(166607);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderStat$PostMediaProcessStat;", "", "()V", "id_remux", "", "key_postTotalCost", "key_postTotalCostCount", "key_postUploadCost", "key_postUploadCostCount", "key_remuxCost", "key_remuxCount", "key_remuxFailed", "key_remuxSize", "key_remux_file_error", "key_remux_skip", "key_videoDuration", "key_zipCost", "key_zipCount", "key_zipFailed", "key_zipSize", "reportPostTotalCost", "", "cost", "reportPostUploadCost", "reportRemuxCost", "reportRemuxCount", "reportRemuxFailed", "reportRemuxOutputFileError", "reportRemuxSize", "size", "reportSkipRemuxCount", "reportVideoDuration", "durationMs", "reportZipCost", "reportZipCount", "reportZipFailed", "reportZipSize", "plugin-finder_release"})
  public static final class b
  {
    private static final long spO = 1253L;
    private static final long spP = 0L;
    private static final long spQ = 1L;
    private static final long spR = 2L;
    private static final long spS = 3L;
    private static final long spT = 4L;
    private static final long spU = 5L;
    private static final long spV = 6L;
    private static final long spW = 7L;
    private static final long spX = 8L;
    private static final long spY = 34L;
    private static final long spZ = 36L;
    private static final long sqa = 9L;
    private static final long sqb = 10L;
    private static final long sqc = 11L;
    private static final long sqd = 12L;
    public static final b sqe;
    
    static
    {
      AppMethodBeat.i(166620);
      sqe = new b();
      spO = 1253L;
      spQ = 1L;
      spR = 2L;
      spS = 3L;
      spT = 4L;
      spU = 5L;
      spV = 6L;
      spW = 7L;
      spX = 8L;
      spY = 34L;
      spZ = 36L;
      sqa = 9L;
      sqb = 10L;
      sqc = 11L;
      sqd = 12L;
      AppMethodBeat.o(166620);
    }
    
    public static void cDG()
    {
      AppMethodBeat.i(166609);
      g.yhR.n(spO, spP, 1L);
      AppMethodBeat.o(166609);
    }
    
    public static void cDH()
    {
      AppMethodBeat.i(166611);
      g.yhR.n(spO, spR, 1L);
      AppMethodBeat.o(166611);
    }
    
    public static void cDI()
    {
      AppMethodBeat.i(203338);
      g.yhR.n(spO, spY, 1L);
      AppMethodBeat.o(203338);
    }
    
    public static void cDJ()
    {
      AppMethodBeat.i(203339);
      g.yhR.n(spO, spZ, 1L);
      AppMethodBeat.o(203339);
    }
    
    public static void cDK()
    {
      AppMethodBeat.i(166613);
      g.yhR.n(spO, spT, 1L);
      AppMethodBeat.o(166613);
    }
    
    public static void cDL()
    {
      AppMethodBeat.i(166615);
      g.yhR.n(spO, spV, 1L);
      AppMethodBeat.o(166615);
    }
    
    public static void wA(long paramLong)
    {
      AppMethodBeat.i(166614);
      g.yhR.n(spO, spU, paramLong);
      AppMethodBeat.o(166614);
    }
    
    public static void wB(long paramLong)
    {
      AppMethodBeat.i(166616);
      g.yhR.n(spO, spW, paramLong);
      AppMethodBeat.o(166616);
    }
    
    public static void wC(long paramLong)
    {
      AppMethodBeat.i(166617);
      g.yhR.n(spO, spX, paramLong);
      AppMethodBeat.o(166617);
    }
    
    public static void wD(long paramLong)
    {
      AppMethodBeat.i(166618);
      g.yhR.n(spO, sqc, 1L);
      g.yhR.n(spO, sqd, paramLong);
      AppMethodBeat.o(166618);
    }
    
    public static void wE(long paramLong)
    {
      AppMethodBeat.i(166619);
      g.yhR.n(spO, sqa, 1L);
      g.yhR.n(spO, sqb, paramLong);
      AppMethodBeat.o(166619);
    }
    
    public static void wy(long paramLong)
    {
      AppMethodBeat.i(166610);
      g.yhR.n(spO, spQ, paramLong);
      AppMethodBeat.o(166610);
    }
    
    public static void wz(long paramLong)
    {
      AppMethodBeat.i(166612);
      g.yhR.n(spO, spS, paramLong);
      AppMethodBeat.o(166612);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderStat$PostStat;", "", "()V", "id_remux", "", "key_postCount", "key_postFailed1", "key_postFailed2", "key_postFailed3", "key_postFailed4", "key_postFailedCount", "key_postFailedDelete", "key_postMediaProcCount", "key_postMediaProcFailedCount", "key_postNetSceneCount", "key_postNetSceneFailedCount", "key_postNetSceneSafeFailedCount", "key_postTryCount", "key_postTryFailedCount", "key_postUploadCount", "key_postUploadFailedCount", "key_postingDelete", "key_repost", "reportPostCount", "", "reportPostFailedCount", "reportPostFailedDeleteCount", "reportPostFailedStage1", "reportPostFailedStage2", "reportPostFailedStage3", "reportPostFailedStage4", "reportPostMediaProcCount", "reportPostMediaProcFailedCount", "reportPostNetSceneCount", "reportPostNetSceneFailedCount", "reportPostNetSceneSafeFailedCount", "reportPostTryCount", "reportPostTryFailedCount", "reportPostUploadCount", "reportPostUploadFailedCount", "reportPostingDeleteCount", "reportRepostCount", "plugin-finder_release"})
  public static final class c
  {
    private static final long spO = 1253L;
    private static final long sqf = 15L;
    private static final long sqg = 16L;
    private static final long sqh = 17L;
    private static final long sqi = 18L;
    private static final long sqj = 19L;
    private static final long sqk = 20L;
    private static final long sqm = 21L;
    private static final long sqn = 22L;
    private static final long sqo = 23L;
    private static final long sqp = 24L;
    private static final long sqq = 25L;
    private static final long sqr = 40L;
    private static final long sqs = 41L;
    private static final long sqt = 42L;
    private static final long squ = 43L;
    private static final long sqv = 44L;
    private static final long sqw = 45L;
    private static final long sqx = 46L;
    public static final c sqy;
    
    static
    {
      AppMethodBeat.i(166632);
      sqy = new c();
      spO = 1253L;
      sqf = 15L;
      sqg = 16L;
      sqh = 17L;
      sqi = 18L;
      sqj = 19L;
      sqk = 20L;
      sqm = 21L;
      sqn = 22L;
      sqo = 23L;
      sqp = 24L;
      sqq = 25L;
      sqr = 40L;
      sqs = 41L;
      sqt = 42L;
      squ = 43L;
      sqv = 44L;
      sqw = 45L;
      sqx = 46L;
      AppMethodBeat.o(166632);
    }
    
    public static void cDM()
    {
      AppMethodBeat.i(166621);
      g.yhR.n(spO, sqf, 1L);
      AppMethodBeat.o(166621);
    }
    
    public static void cDN()
    {
      AppMethodBeat.i(166622);
      g.yhR.n(spO, sqg, 1L);
      AppMethodBeat.o(166622);
    }
    
    public static void cDO()
    {
      AppMethodBeat.i(166623);
      g.yhR.n(spO, sqh, 1L);
      AppMethodBeat.o(166623);
    }
    
    public static void cDP()
    {
      AppMethodBeat.i(166624);
      g.yhR.n(spO, sqi, 1L);
      AppMethodBeat.o(166624);
    }
    
    public static void cDQ()
    {
      AppMethodBeat.i(166625);
      g.yhR.n(spO, sqj, 1L);
      AppMethodBeat.o(166625);
    }
    
    public static void cDR()
    {
      AppMethodBeat.i(166626);
      g.yhR.n(spO, sqk, 1L);
      AppMethodBeat.o(166626);
    }
    
    public static void cDS()
    {
      AppMethodBeat.i(166627);
      g.yhR.n(spO, sqm, 1L);
      AppMethodBeat.o(166627);
    }
    
    public static void cDT()
    {
      AppMethodBeat.i(166628);
      g.yhR.n(spO, sqn, 1L);
      AppMethodBeat.o(166628);
    }
    
    public static void cDU()
    {
      AppMethodBeat.i(166629);
      g.yhR.n(spO, sqo, 1L);
      AppMethodBeat.o(166629);
    }
    
    public static void cDV()
    {
      AppMethodBeat.i(166630);
      g.yhR.n(spO, sqp, 1L);
      AppMethodBeat.o(166630);
    }
    
    public static void cDW()
    {
      AppMethodBeat.i(166631);
      g.yhR.n(spO, sqq, 1L);
      AppMethodBeat.o(166631);
    }
    
    public static void cDX()
    {
      AppMethodBeat.i(203340);
      g.yhR.n(spO, sqr, 1L);
      AppMethodBeat.o(203340);
    }
    
    public static void cDY()
    {
      AppMethodBeat.i(203341);
      g.yhR.n(spO, sqs, 1L);
      AppMethodBeat.o(203341);
    }
    
    public static void cDZ()
    {
      AppMethodBeat.i(203342);
      g.yhR.n(spO, sqt, 1L);
      AppMethodBeat.o(203342);
    }
    
    public static void cEa()
    {
      AppMethodBeat.i(203343);
      g.yhR.n(spO, squ, 1L);
      AppMethodBeat.o(203343);
    }
    
    public static void cEb()
    {
      AppMethodBeat.i(203344);
      g.yhR.n(spO, sqv, 1L);
      AppMethodBeat.o(203344);
    }
    
    public static void cEc()
    {
      AppMethodBeat.i(203345);
      g.yhR.n(spO, sqw, 1L);
      AppMethodBeat.o(203345);
    }
    
    public static void cEd()
    {
      AppMethodBeat.i(203346);
      g.yhR.n(spO, sqx, 1L);
      AppMethodBeat.o(203346);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderStat$SyncCropVideoStat;", "", "()V", "id_syncCrop", "", "key_syncCropCost", "key_syncCropCount", "logId", "", "reportSyncCrop", "", "cost", "reportSyncCropKv", "originMediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "targetMediaInfo", "originFileSize", "targetFileSize", "ret", "plugin-finder_release"})
  public static final class d
  {
    private static final int gsc = 19063;
    private static final long sqA = 30L;
    private static final long sqB = 31L;
    public static final d sqC;
    private static final long sqz = 1253L;
    
    static
    {
      AppMethodBeat.i(166635);
      sqC = new d();
      sqz = 1253L;
      sqA = 30L;
      sqB = 31L;
      gsc = 19063;
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
        parama2 = n.spL;
        ad.i(n.cDF(), "report 19063: ".concat(String.valueOf(parama1)));
        g.yhR.kvStat(gsc, parama1);
        AppMethodBeat.o(166634);
        return;
      }
    }
    
    public static void wF(long paramLong)
    {
      AppMethodBeat.i(166633);
      g.yhR.n(sqz, sqA, 1L);
      g.yhR.n(sqz, sqB, paramLong);
      AppMethodBeat.o(166633);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderStat$VideoInvalidStat;", "", "()V", "idkeyId", "", "kvLogId", "", "reportVideo", "", "videoMime", "", "audioMime", "path", "plugin-finder_release"})
  public static final class e
  {
    private static final int sqD = 19441;
    private static final long sqE = 1253L;
    public static final e sqF;
    
    static
    {
      AppMethodBeat.i(178399);
      sqF = new e();
      sqD = 19441;
      sqE = 1253L;
      AppMethodBeat.o(178399);
    }
    
    public static void ab(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(178398);
      g localg = g.yhR;
      int i = sqD;
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
      g.yhR.n(sqE, 33L, 1L);
      AppMethodBeat.o(178398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.n
 * JD-Core Version:    0.7.0.1
 */