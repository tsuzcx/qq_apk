package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderDraftStat;", "", "()V", "TAG", "", "getLongVideoId", "", "id", "idkeyStat", "", "key", "value", "isLongVideo", "", "FolderCapacityStat", "LongVideoStat", "PostMediaProcessStat", "PostStat", "SyncCropVideoStat", "VideoInvalidStat", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i Fou;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(331414);
    Fou = new i();
    TAG = "Finder.FinderDraftStat";
    AppMethodBeat.o(331414);
  }
  
  public static void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(331408);
    h.OAn.p(paramLong1, paramLong2, paramLong3);
    if ((paramBoolean) && (pA(paramLong1) > 0L)) {
      h.OAn.p(pA(paramLong1), paramLong2, paramLong3);
    }
    AppMethodBeat.o(331408);
  }
  
  private static long pA(long paramLong)
  {
    if (paramLong == 1718L) {
      return 1719L;
    }
    return 0L;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderDraftStat$LongVideoStat;", "", "()V", "id", "", "key_fileSize", "reportFileSizeOutOfRange", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a Fov;
    private static final long Fow;
    private static final long id;
    
    static
    {
      AppMethodBeat.i(331488);
      Fov = new a();
      id = 1719L;
      Fow = 101L;
      AppMethodBeat.o(331488);
    }
    
    public static void eMq()
    {
      AppMethodBeat.i(331481);
      h.OAn.p(id, Fow, 1L);
      AppMethodBeat.o(331481);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderDraftStat$PostMediaProcessStat;", "", "()V", "id_remux", "", "key_no_remux_moov", "key_postTotalCost", "key_postTotalCostCount", "key_postUploadCost", "key_postUploadCostCount", "key_progress_exception", "key_remuxCost", "key_remuxCount", "key_remuxFailed", "key_remuxSize", "key_remux_file_error", "key_remux_skip", "key_videoDuration", "key_zipCost", "key_zipCount", "key_zipFailed", "key_zipSize", "reportNoRemuxMoov", "", "isLongVideo", "", "reportPostTotalCost", "cost", "reportPostUploadCost", "reportRemuxCost", "reportRemuxCount", "reportRemuxFailed", "reportRemuxOutputFileError", "reportRemuxProgressException", "reportRemuxSize", "size", "reportSkipRemuxCount", "reportVideoDuration", "durationMs", "reportZipCost", "reportZipCount", "reportZipFailed", "reportZipSize", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private static final long FoA;
    private static final long FoB;
    private static final long FoC;
    private static final long FoD;
    private static final long FoE;
    private static final long FoF;
    private static final long FoG;
    private static final long FoH;
    private static final long FoI;
    private static final long FoJ;
    private static final long FoK;
    private static final long FoL;
    private static final long FoM;
    private static final long FoN;
    private static final long FoO;
    private static final long FoP;
    public static final b Fox;
    private static final long Foy;
    private static final long Foz = 0L;
    
    static
    {
      AppMethodBeat.i(331558);
      Fox = new b();
      Foy = 1718L;
      FoA = 1L;
      FoB = 2L;
      FoC = 3L;
      FoD = 4L;
      FoE = 5L;
      FoF = 6L;
      FoG = 7L;
      FoH = 8L;
      FoI = 34L;
      FoJ = 36L;
      FoK = 54L;
      FoL = 64L;
      FoM = 9L;
      FoN = 10L;
      FoO = 11L;
      FoP = 12L;
      AppMethodBeat.o(331558);
    }
    
    public static void C(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(331517);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoA, paramLong, paramBoolean);
      AppMethodBeat.o(331517);
    }
    
    public static void D(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(331542);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoO, 1L, paramBoolean);
      locali = i.Fou;
      i.idkeyStat(Foy, FoP, paramLong, paramBoolean);
      AppMethodBeat.o(331542);
    }
    
    public static void E(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(331548);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoM, 1L, paramBoolean);
      locali = i.Fou;
      i.idkeyStat(Foy, FoN, paramLong, paramBoolean);
      AppMethodBeat.o(331548);
    }
    
    public static void eMr()
    {
      AppMethodBeat.i(331509);
      i locali = i.Fou;
      i.idkeyStat(Foy, Foz, 1L, true);
      AppMethodBeat.o(331509);
    }
    
    public static void tA(boolean paramBoolean)
    {
      AppMethodBeat.i(331535);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoL, 1L, paramBoolean);
      AppMethodBeat.o(331535);
    }
    
    public static void ty(boolean paramBoolean)
    {
      AppMethodBeat.i(331522);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoB, 1L, paramBoolean);
      AppMethodBeat.o(331522);
    }
    
    public static void tz(boolean paramBoolean)
    {
      AppMethodBeat.i(331529);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoJ, 1L, paramBoolean);
      AppMethodBeat.o(331529);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderDraftStat$PostStat;", "", "()V", "id_remux", "", "key_postCount", "key_postFailed1", "key_postFailed2", "key_postFailed3", "key_postFailed4", "key_postFailedCount", "key_postFailedDelete", "key_postFailedDeleteLongVideo", "key_postMediaProcCount", "key_postMediaProcFailedCount", "key_postNetSceneCount", "key_postNetSceneFailedCount", "key_postNetSceneSafeFailedCount", "key_postTryCount", "key_postTryFailedCount", "key_postUploadCount", "key_postUploadFailedCount", "key_postingDelete", "key_postingDeleteLongVideo", "key_repost", "key_repostLongVideo", "reportPostCount", "", "isLongVideo", "", "reportPostFailedCount", "reportPostFailedDeleteCount", "reportPostFailedDeleteLongVideoCount", "reportPostFailedStage1", "reportPostFailedStage2", "reportPostFailedStage3", "reportPostFailedStage4", "reportPostMediaProcCount", "reportPostMediaProcFailedCount", "reportPostNetSceneCount", "reportPostNetSceneFailedCount", "reportPostNetSceneSafeFailedCount", "reportPostTryCount", "reportPostTryFailedCount", "reportPostUploadCount", "reportPostUploadFailedCount", "reportPostingDeleteCount", "reportPostingDeleteLongVideoCount", "reportRepostCount", "reportRepostLongVideoCount", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static final c FoQ;
    private static final long FoR;
    private static final long FoS;
    private static final long FoT;
    private static final long FoU;
    private static final long FoV;
    private static final long FoW;
    private static final long FoX;
    private static final long FoY;
    private static final long FoZ;
    private static final long Foy;
    private static final long Fpa;
    private static final long Fpb;
    private static final long Fpc;
    private static final long Fpd;
    private static final long Fpe;
    private static final long Fpf;
    private static final long Fpg;
    private static final long Fph;
    private static final long Fpi;
    private static final long Fpj;
    private static final long Fpk;
    private static final long Fpl;
    
    static
    {
      AppMethodBeat.i(331651);
      FoQ = new c();
      Foy = 1718L;
      FoR = 15L;
      FoS = 16L;
      FoT = 17L;
      FoU = 18L;
      FoV = 19L;
      FoW = 20L;
      FoX = 21L;
      FoY = 22L;
      FoZ = 23L;
      Fpa = 24L;
      Fpb = 25L;
      Fpc = 40L;
      Fpd = 41L;
      Fpe = 42L;
      Fpf = 43L;
      Fpg = 44L;
      Fph = 45L;
      Fpi = 46L;
      Fpj = 51L;
      Fpk = 52L;
      Fpl = 53L;
      AppMethodBeat.o(331651);
    }
    
    public static void eMs()
    {
      AppMethodBeat.i(331643);
      i locali = i.Fou;
      i.idkeyStat(Foy, Fpl, 1L, true);
      AppMethodBeat.o(331643);
    }
    
    public static void tB(boolean paramBoolean)
    {
      AppMethodBeat.i(331543);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoR, 1L, paramBoolean);
      AppMethodBeat.o(331543);
    }
    
    public static void tC(boolean paramBoolean)
    {
      AppMethodBeat.i(331553);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoS, 1L, paramBoolean);
      AppMethodBeat.o(331553);
    }
    
    public static void tD(boolean paramBoolean)
    {
      AppMethodBeat.i(331562);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoT, 1L, paramBoolean);
      AppMethodBeat.o(331562);
    }
    
    public static void tE(boolean paramBoolean)
    {
      AppMethodBeat.i(331569);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoV, 1L, paramBoolean);
      AppMethodBeat.o(331569);
    }
    
    public static void tF(boolean paramBoolean)
    {
      AppMethodBeat.i(331573);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoW, 1L, paramBoolean);
      AppMethodBeat.o(331573);
    }
    
    public static void tG(boolean paramBoolean)
    {
      AppMethodBeat.i(331581);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoX, 1L, paramBoolean);
      AppMethodBeat.o(331581);
    }
    
    public static void tH(boolean paramBoolean)
    {
      AppMethodBeat.i(331588);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoY, 1L, paramBoolean);
      AppMethodBeat.o(331588);
    }
    
    public static void tI(boolean paramBoolean)
    {
      AppMethodBeat.i(331596);
      i locali = i.Fou;
      i.idkeyStat(Foy, FoZ, 1L, paramBoolean);
      AppMethodBeat.o(331596);
    }
    
    public static void tJ(boolean paramBoolean)
    {
      AppMethodBeat.i(331599);
      i locali = i.Fou;
      i.idkeyStat(Foy, Fpa, 1L, paramBoolean);
      AppMethodBeat.o(331599);
    }
    
    public static void tK(boolean paramBoolean)
    {
      AppMethodBeat.i(331608);
      i locali = i.Fou;
      i.idkeyStat(Foy, Fpe, 1L, paramBoolean);
      AppMethodBeat.o(331608);
    }
    
    public static void tn(boolean paramBoolean)
    {
      AppMethodBeat.i(331615);
      i locali = i.Fou;
      i.idkeyStat(Foy, Fpf, 1L, paramBoolean);
      AppMethodBeat.o(331615);
    }
    
    public static void to(boolean paramBoolean)
    {
      AppMethodBeat.i(331623);
      i locali = i.Fou;
      i.idkeyStat(Foy, Fpg, 1L, paramBoolean);
      AppMethodBeat.o(331623);
    }
    
    public static void tp(boolean paramBoolean)
    {
      AppMethodBeat.i(331630);
      i locali = i.Fou;
      i.idkeyStat(Foy, Fph, 1L, paramBoolean);
      AppMethodBeat.o(331630);
    }
    
    public static void tq(boolean paramBoolean)
    {
      AppMethodBeat.i(331637);
      i locali = i.Fou;
      i.idkeyStat(Foy, Fpi, 1L, paramBoolean);
      AppMethodBeat.o(331637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.i
 * JD-Core Version:    0.7.0.1
 */