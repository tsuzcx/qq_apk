package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderStat;", "", "()V", "TAG", "", "getLongVideoId", "", "id", "idkeyStat", "", "key", "value", "isLongVideo", "", "FolderCapacityStat", "LongVideoStat", "PostMediaProcessStat", "PostStat", "SyncCropVideoStat", "VideoInvalidStat", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
{
  public static final ah Ftr;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(166636);
    Ftr = new ah();
    TAG = "Finder.FinderStat";
    AppMethodBeat.o(166636);
  }
  
  public static void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(331259);
    h.OAn.p(paramLong1, paramLong2, paramLong3);
    if ((paramBoolean) && (pA(paramLong1) > 0L)) {
      h.OAn.p(pA(paramLong1), paramLong2, paramLong3);
    }
    AppMethodBeat.o(331259);
  }
  
  private static long pA(long paramLong)
  {
    if (paramLong == 1253L) {
      return 1523L;
    }
    return 0L;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderStat$LongVideoStat;", "", "()V", "id", "", "key_fileSize", "reportFileSizeOutOfRange", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private static final long Fow;
    public static final b Ftu;
    private static final long id;
    
    static
    {
      AppMethodBeat.i(331184);
      Ftu = new b();
      id = 1523L;
      Fow = 101L;
      AppMethodBeat.o(331184);
    }
    
    public static void eMq()
    {
      AppMethodBeat.i(331173);
      h.OAn.p(id, Fow, 1L);
      AppMethodBeat.o(331173);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderStat$PostStat;", "", "()V", "id_remux", "", "key_postCount", "key_postFailed1", "key_postFailed2", "key_postFailed3", "key_postFailed4", "key_postFailedCount", "key_postFailedDelete", "key_postFailedDeleteLongVideo", "key_postMediaProcCount", "key_postMediaProcFailedCount", "key_postNetSceneCount", "key_postNetSceneFailedCount", "key_postNetSceneSafeFailedCount", "key_postTryCount", "key_postTryFailedCount", "key_postUploadCount", "key_postUploadFailedCount", "key_postingDelete", "key_postingDeleteLongVideo", "key_repost", "key_repostLongVideo", "reportPostCount", "", "isLongVideo", "", "reportPostFailedCount", "reportPostFailedDeleteCount", "reportPostFailedDeleteLongVideoCount", "reportPostFailedStage1", "reportPostFailedStage2", "reportPostFailedStage3", "reportPostFailedStage4", "reportPostMediaProcCount", "reportPostMediaProcFailedCount", "reportPostNetSceneCount", "reportPostNetSceneFailedCount", "reportPostNetSceneSafeFailedCount", "reportPostTryCount", "reportPostTryFailedCount", "reportPostUploadCount", "reportPostUploadFailedCount", "reportPostingDeleteCount", "reportPostingDeleteLongVideoCount", "reportRepostCount", "reportRepostLongVideoCount", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
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
    public static final d Ftw;
    
    static
    {
      AppMethodBeat.i(166632);
      Ftw = new d();
      Foy = 1253L;
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
      AppMethodBeat.o(166632);
    }
    
    public static void eMs()
    {
      AppMethodBeat.i(331282);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fpl, 1L, true);
      AppMethodBeat.o(331282);
    }
    
    public static void eNA()
    {
      AppMethodBeat.i(331276);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fpk, 1L, true);
      AppMethodBeat.o(331276);
    }
    
    public static void eNz()
    {
      AppMethodBeat.i(331269);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fpj, 1L, true);
      AppMethodBeat.o(331269);
    }
    
    public static void tB(boolean paramBoolean)
    {
      AppMethodBeat.i(331156);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, FoR, 1L, paramBoolean);
      AppMethodBeat.o(331156);
    }
    
    public static void tC(boolean paramBoolean)
    {
      AppMethodBeat.i(331162);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, FoS, 1L, paramBoolean);
      AppMethodBeat.o(331162);
    }
    
    public static void tD(boolean paramBoolean)
    {
      AppMethodBeat.i(331170);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, FoT, 1L, paramBoolean);
      AppMethodBeat.o(331170);
    }
    
    public static void tE(boolean paramBoolean)
    {
      AppMethodBeat.i(331182);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, FoV, 1L, paramBoolean);
      AppMethodBeat.o(331182);
    }
    
    public static void tF(boolean paramBoolean)
    {
      AppMethodBeat.i(331190);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, FoW, 1L, paramBoolean);
      AppMethodBeat.o(331190);
    }
    
    public static void tG(boolean paramBoolean)
    {
      AppMethodBeat.i(331197);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, FoX, 1L, paramBoolean);
      AppMethodBeat.o(331197);
    }
    
    public static void tH(boolean paramBoolean)
    {
      AppMethodBeat.i(331205);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, FoY, 1L, paramBoolean);
      AppMethodBeat.o(331205);
    }
    
    public static void tI(boolean paramBoolean)
    {
      AppMethodBeat.i(331209);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, FoZ, 1L, paramBoolean);
      AppMethodBeat.o(331209);
    }
    
    public static void tJ(boolean paramBoolean)
    {
      AppMethodBeat.i(331218);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fpa, 1L, paramBoolean);
      AppMethodBeat.o(331218);
    }
    
    public static void tK(boolean paramBoolean)
    {
      AppMethodBeat.i(331241);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fpe, 1L, paramBoolean);
      AppMethodBeat.o(331241);
    }
    
    public static void tU(boolean paramBoolean)
    {
      AppMethodBeat.i(331176);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, FoU, 1L, paramBoolean);
      AppMethodBeat.o(331176);
    }
    
    public static void tV(boolean paramBoolean)
    {
      AppMethodBeat.i(331225);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fpb, 1L, paramBoolean);
      AppMethodBeat.o(331225);
    }
    
    public static void tl(boolean paramBoolean)
    {
      AppMethodBeat.i(331232);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fpc, 1L, paramBoolean);
      AppMethodBeat.o(331232);
    }
    
    public static void tm(boolean paramBoolean)
    {
      AppMethodBeat.i(331237);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fpd, 1L, paramBoolean);
      AppMethodBeat.o(331237);
    }
    
    public static void tn(boolean paramBoolean)
    {
      AppMethodBeat.i(331245);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fpf, 1L, paramBoolean);
      AppMethodBeat.o(331245);
    }
    
    public static void to(boolean paramBoolean)
    {
      AppMethodBeat.i(331250);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fpg, 1L, paramBoolean);
      AppMethodBeat.o(331250);
    }
    
    public static void tp(boolean paramBoolean)
    {
      AppMethodBeat.i(331255);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fph, 1L, paramBoolean);
      AppMethodBeat.o(331255);
    }
    
    public static void tq(boolean paramBoolean)
    {
      AppMethodBeat.i(331262);
      ah localah = ah.Ftr;
      ah.idkeyStat(Foy, Fpi, 1L, paramBoolean);
      AppMethodBeat.o(331262);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderStat$SyncCropVideoStat;", "", "()V", "id_syncCrop", "", "key_syncCropCost", "key_syncCropCount", "logId", "", "reportSyncCrop", "", "cost", "reportSyncCropKv", "originMediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "targetMediaInfo", "originFileSize", "targetFileSize", "ret", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
  {
    private static final long FtA;
    public static final e Ftx;
    private static final long Fty;
    private static final long Ftz;
    private static final int mtI;
    
    static
    {
      AppMethodBeat.i(166635);
      Ftx = new e();
      Fty = 1253L;
      Ftz = 30L;
      FtA = 31L;
      mtI = 19063;
      AppMethodBeat.o(166635);
    }
    
    public static void a(b paramb1, b paramb2, int paramInt1, int paramInt2, long paramLong, int paramInt3)
    {
      AppMethodBeat.i(166634);
      if (paramb1 != null)
      {
        paramb1 = paramb1.getVideoDuration() + ',' + paramb1.width + ',' + paramb1.height + ',' + paramInt1 + ',' + paramb1.videoBitrate + ',';
        if (paramb2 != null) {
          break label146;
        }
      }
      label146:
      for (paramb1 = s.X(paramb1, "0,0,0,0,0,");; paramb1 = paramb1 + paramb2.getVideoDuration() + ',' + paramb2.width + ',' + paramb2.height + ',' + paramInt2 + ',' + paramb2.videoBitrate)
      {
        paramb1 = paramb1 + paramLong + ',' + paramInt3;
        Log.i(ah.aUw(), s.X("report 19063: ", paramb1));
        h.OAn.kvStat(mtI, paramb1);
        AppMethodBeat.o(166634);
        return;
      }
    }
    
    public static void pP(long paramLong)
    {
      AppMethodBeat.i(166633);
      h.OAn.p(Fty, Ftz, 1L);
      h.OAn.p(Fty, FtA, paramLong);
      AppMethodBeat.o(166633);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderStat$VideoInvalidStat;", "", "()V", "idkeyId", "", "kvLogId", "", "reportVideo", "", "videoMime", "", "audioMime", "path", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
  {
    public static final f FtB;
    private static final int FtC;
    private static final long FtD;
    
    static
    {
      AppMethodBeat.i(178399);
      FtB = new f();
      FtC = 19441;
      FtD = 1253L;
      AppMethodBeat.o(178399);
    }
    
    public static void al(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(178398);
      h localh = h.OAn;
      int i = FtC;
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
      localh.b(i, new Object[] { str, paramString1, paramString2 });
      h.OAn.p(FtD, 33L, 1L);
      AppMethodBeat.o(178398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ah
 * JD-Core Version:    0.7.0.1
 */