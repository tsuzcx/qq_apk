package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderStat;", "", "()V", "TAG", "", "getLongVideoId", "", "id", "idkeyStat", "", "key", "value", "isLongVideo", "", "FolderCapacityStat", "LongVideoStat", "PostMediaProcessStat", "PostStat", "SyncCropVideoStat", "VideoInvalidStat", "plugin-finder_release"})
public final class r
{
  private static final String TAG = "Finder.FinderStat";
  public static final r vgF;
  
  static
  {
    AppMethodBeat.i(166636);
    vgF = new r();
    TAG = "Finder.FinderStat";
    AppMethodBeat.o(166636);
  }
  
  private static long Fi(long paramLong)
  {
    if (paramLong == 1253L) {
      return 1523L;
    }
    return 0L;
  }
  
  public static void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(250793);
    h.CyF.n(paramLong1, paramLong2, paramLong3);
    if ((paramBoolean) && (Fi(paramLong1) > 0L)) {
      h.CyF.n(Fi(paramLong1), paramLong2, paramLong3);
    }
    AppMethodBeat.o(250793);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderStat$FolderCapacityStat;", "", "()V", "id_folder", "", "logId", "", "reportCapacity", "", "folderSizeMap", "", "", "reportNormalFolderClearCost", "costTime", "reportNormalFolderMarkCost", "reportPostFolderClearCost", "plugin-finder_release"})
  public static final class a
  {
    private static final int hhs = 18896;
    private static final long vgG = 1267L;
    public static final a vgH;
    
    static
    {
      AppMethodBeat.i(166608);
      vgH = new a();
      hhs = 18896;
      vgG = 1267L;
      AppMethodBeat.o(166608);
    }
    
    public static void Fj(long paramLong)
    {
      AppMethodBeat.i(166605);
      h.CyF.n(vgG, 1L, 1L);
      h.CyF.n(vgG, 2L, paramLong);
      r localr = r.vgF;
      Log.d(r.dou(), "reportNormalFolderClearCost " + vgG + ", key:1,2, costTime:" + paramLong);
      AppMethodBeat.o(166605);
    }
    
    public static void Fk(long paramLong)
    {
      AppMethodBeat.i(166606);
      h.CyF.n(vgG, 3L, 1L);
      h.CyF.n(vgG, 4L, paramLong);
      r localr = r.vgF;
      Log.d(r.dou(), "reportNormalFolderMarkCost " + vgG + ", key:3,4, costTime:" + paramLong);
      AppMethodBeat.o(166606);
    }
    
    public static void Fl(long paramLong)
    {
      AppMethodBeat.i(166607);
      h.CyF.n(vgG, 5L, 1L);
      h.CyF.n(vgG, 6L, paramLong);
      r localr = r.vgF;
      Log.d(r.dou(), "reportNormalFolderClearCost " + vgG + ", key:5,6, costTime:" + paramLong);
      AppMethodBeat.o(166607);
    }
    
    public static void ai(Map<String, Long> paramMap)
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
        localObject = r.vgF;
        Log.i(r.dou(), "report 18896: ".concat(String.valueOf(paramMap)));
        h.CyF.kvStat(hhs, paramMap);
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
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderStat$LongVideoStat;", "", "()V", "id", "", "key_fileSize", "reportFileSizeOutOfRange", "", "plugin-finder_release"})
  public static final class b
  {
    private static final long id = 1523L;
    private static final long vgI = 101L;
    public static final b vgJ;
    
    static
    {
      AppMethodBeat.i(250757);
      vgJ = new b();
      id = 1523L;
      vgI = 101L;
      AppMethodBeat.o(250757);
    }
    
    public static void dov()
    {
      AppMethodBeat.i(250756);
      h.CyF.n(id, vgI, 1L);
      AppMethodBeat.o(250756);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderStat$PostMediaProcessStat;", "", "()V", "id_remux", "", "key_postTotalCost", "key_postTotalCostCount", "key_postUploadCost", "key_postUploadCostCount", "key_progress_exception", "key_remuxCost", "key_remuxCount", "key_remuxFailed", "key_remuxSize", "key_remux_file_error", "key_remux_skip", "key_videoDuration", "key_zipCost", "key_zipCount", "key_zipFailed", "key_zipSize", "reportPostTotalCost", "", "cost", "isLongVideo", "", "reportPostUploadCost", "reportRemuxCost", "reportRemuxCount", "reportRemuxFailed", "reportRemuxOutputFileError", "reportRemuxProgressException", "reportRemuxSize", "size", "reportSkipRemuxCount", "reportVideoDuration", "durationMs", "reportZipCost", "reportZipCount", "reportZipFailed", "reportZipSize", "plugin-finder_release"})
  public static final class c
  {
    private static final long vgK = 1253L;
    private static final long vgL = 0L;
    private static final long vgM = 1L;
    private static final long vgN = 2L;
    private static final long vgO = 3L;
    private static final long vgP = 4L;
    private static final long vgQ = 5L;
    private static final long vgR = 6L;
    private static final long vgS = 7L;
    private static final long vgT = 8L;
    private static final long vgU = 34L;
    private static final long vgV = 36L;
    private static final long vgW = 54L;
    private static final long vgX = 9L;
    private static final long vgY = 10L;
    private static final long vgZ = 11L;
    private static final long vha = 12L;
    public static final c vhb;
    
    static
    {
      AppMethodBeat.i(166620);
      vhb = new c();
      vgK = 1253L;
      vgM = 1L;
      vgN = 2L;
      vgO = 3L;
      vgP = 4L;
      vgQ = 5L;
      vgR = 6L;
      vgS = 7L;
      vgT = 8L;
      vgU = 34L;
      vgV = 36L;
      vgW = 54L;
      vgX = 9L;
      vgY = 10L;
      vgZ = 11L;
      vha = 12L;
      AppMethodBeat.o(166620);
    }
    
    public static void Fm(long paramLong)
    {
      AppMethodBeat.i(250769);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgT, paramLong, false);
      AppMethodBeat.o(250769);
    }
    
    public static void nT(boolean paramBoolean)
    {
      AppMethodBeat.i(250758);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgL, 1L, paramBoolean);
      AppMethodBeat.o(250758);
    }
    
    public static void nU(boolean paramBoolean)
    {
      AppMethodBeat.i(250760);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgN, 1L, paramBoolean);
      AppMethodBeat.o(250760);
    }
    
    public static void nV(boolean paramBoolean)
    {
      AppMethodBeat.i(250762);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgU, 1L, paramBoolean);
      AppMethodBeat.o(250762);
    }
    
    public static void nW(boolean paramBoolean)
    {
      AppMethodBeat.i(250763);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgV, 1L, paramBoolean);
      AppMethodBeat.o(250763);
    }
    
    public static void nX(boolean paramBoolean)
    {
      AppMethodBeat.i(250764);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgW, 1L, paramBoolean);
      AppMethodBeat.o(250764);
    }
    
    public static void nY(boolean paramBoolean)
    {
      AppMethodBeat.i(250765);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgP, 1L, paramBoolean);
      AppMethodBeat.o(250765);
    }
    
    public static void nZ(boolean paramBoolean)
    {
      AppMethodBeat.i(250767);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgR, 1L, paramBoolean);
      AppMethodBeat.o(250767);
    }
    
    public static void u(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(250759);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgM, paramLong, paramBoolean);
      AppMethodBeat.o(250759);
    }
    
    public static void v(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(250761);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgO, paramLong, paramBoolean);
      AppMethodBeat.o(250761);
    }
    
    public static void w(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(250766);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgQ, paramLong, paramBoolean);
      AppMethodBeat.o(250766);
    }
    
    public static void x(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(250768);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgS, paramLong, paramBoolean);
      AppMethodBeat.o(250768);
    }
    
    public static void y(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(250770);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgZ, 1L, paramBoolean);
      localr = r.vgF;
      r.idkeyStat(vgK, vha, paramLong, paramBoolean);
      AppMethodBeat.o(250770);
    }
    
    public static void z(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(250771);
      r localr = r.vgF;
      r.idkeyStat(vgK, vgX, 1L, paramBoolean);
      localr = r.vgF;
      r.idkeyStat(vgK, vgY, paramLong, paramBoolean);
      AppMethodBeat.o(250771);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderStat$PostStat;", "", "()V", "id_remux", "", "key_postCount", "key_postFailed1", "key_postFailed2", "key_postFailed3", "key_postFailed4", "key_postFailedCount", "key_postFailedDelete", "key_postFailedDeleteLongVideo", "key_postMediaProcCount", "key_postMediaProcFailedCount", "key_postNetSceneCount", "key_postNetSceneFailedCount", "key_postNetSceneSafeFailedCount", "key_postTryCount", "key_postTryFailedCount", "key_postUploadCount", "key_postUploadFailedCount", "key_postingDelete", "key_postingDeleteLongVideo", "key_repost", "key_repostLongVideo", "reportPostCount", "", "isLongVideo", "", "reportPostFailedCount", "reportPostFailedDeleteCount", "reportPostFailedDeleteLongVideoCount", "reportPostFailedStage1", "reportPostFailedStage2", "reportPostFailedStage3", "reportPostFailedStage4", "reportPostMediaProcCount", "reportPostMediaProcFailedCount", "reportPostNetSceneCount", "reportPostNetSceneFailedCount", "reportPostNetSceneSafeFailedCount", "reportPostTryCount", "reportPostTryFailedCount", "reportPostUploadCount", "reportPostUploadFailedCount", "reportPostingDeleteCount", "reportPostingDeleteLongVideoCount", "reportRepostCount", "reportRepostLongVideoCount", "plugin-finder_release"})
  public static final class d
  {
    private static final long vgK = 1253L;
    private static final long vhc = 15L;
    private static final long vhd = 16L;
    private static final long vhe = 17L;
    private static final long vhf = 18L;
    private static final long vhg = 19L;
    private static final long vhh = 20L;
    private static final long vhi = 21L;
    private static final long vhj = 22L;
    private static final long vhk = 23L;
    private static final long vhl = 24L;
    private static final long vhm = 25L;
    private static final long vhn = 40L;
    private static final long vho = 41L;
    private static final long vhp = 42L;
    private static final long vhq = 43L;
    private static final long vhr = 44L;
    private static final long vhs = 45L;
    private static final long vht = 46L;
    private static final long vhu = 51L;
    private static final long vhv = 52L;
    private static final long vhw = 53L;
    public static final d vhx;
    
    static
    {
      AppMethodBeat.i(166632);
      vhx = new d();
      vgK = 1253L;
      vhc = 15L;
      vhd = 16L;
      vhe = 17L;
      vhf = 18L;
      vhg = 19L;
      vhh = 20L;
      vhi = 21L;
      vhj = 22L;
      vhk = 23L;
      vhl = 24L;
      vhm = 25L;
      vhn = 40L;
      vho = 41L;
      vhp = 42L;
      vhq = 43L;
      vhr = 44L;
      vhs = 45L;
      vht = 46L;
      vhu = 51L;
      vhv = 52L;
      vhw = 53L;
      AppMethodBeat.o(166632);
    }
    
    public static void dow()
    {
      AppMethodBeat.i(250790);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhu, 1L, true);
      AppMethodBeat.o(250790);
    }
    
    public static void dox()
    {
      AppMethodBeat.i(250791);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhv, 1L, true);
      AppMethodBeat.o(250791);
    }
    
    public static void doy()
    {
      AppMethodBeat.i(250792);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhw, 1L, true);
      AppMethodBeat.o(250792);
    }
    
    public static void oa(boolean paramBoolean)
    {
      AppMethodBeat.i(250772);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhc, 1L, paramBoolean);
      AppMethodBeat.o(250772);
    }
    
    public static void ob(boolean paramBoolean)
    {
      AppMethodBeat.i(250773);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhd, 1L, paramBoolean);
      AppMethodBeat.o(250773);
    }
    
    public static void oc(boolean paramBoolean)
    {
      AppMethodBeat.i(250774);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhe, 1L, paramBoolean);
      AppMethodBeat.o(250774);
    }
    
    public static void od(boolean paramBoolean)
    {
      AppMethodBeat.i(250775);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhf, 1L, paramBoolean);
      AppMethodBeat.o(250775);
    }
    
    public static void oe(boolean paramBoolean)
    {
      AppMethodBeat.i(250776);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhg, 1L, paramBoolean);
      AppMethodBeat.o(250776);
    }
    
    public static void of(boolean paramBoolean)
    {
      AppMethodBeat.i(250777);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhh, 1L, paramBoolean);
      AppMethodBeat.o(250777);
    }
    
    public static void og(boolean paramBoolean)
    {
      AppMethodBeat.i(250778);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhi, 1L, paramBoolean);
      AppMethodBeat.o(250778);
    }
    
    public static void oh(boolean paramBoolean)
    {
      AppMethodBeat.i(250779);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhj, 1L, paramBoolean);
      AppMethodBeat.o(250779);
    }
    
    public static void oi(boolean paramBoolean)
    {
      AppMethodBeat.i(250780);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhk, 1L, paramBoolean);
      AppMethodBeat.o(250780);
    }
    
    public static void oj(boolean paramBoolean)
    {
      AppMethodBeat.i(250781);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhl, 1L, paramBoolean);
      AppMethodBeat.o(250781);
    }
    
    public static void ok(boolean paramBoolean)
    {
      AppMethodBeat.i(250782);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhm, 1L, paramBoolean);
      AppMethodBeat.o(250782);
    }
    
    public static void ol(boolean paramBoolean)
    {
      AppMethodBeat.i(250783);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhn, 1L, paramBoolean);
      AppMethodBeat.o(250783);
    }
    
    public static void om(boolean paramBoolean)
    {
      AppMethodBeat.i(250784);
      r localr = r.vgF;
      r.idkeyStat(vgK, vho, 1L, paramBoolean);
      AppMethodBeat.o(250784);
    }
    
    public static void on(boolean paramBoolean)
    {
      AppMethodBeat.i(250785);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhp, 1L, paramBoolean);
      AppMethodBeat.o(250785);
    }
    
    public static void oo(boolean paramBoolean)
    {
      AppMethodBeat.i(250786);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhq, 1L, paramBoolean);
      AppMethodBeat.o(250786);
    }
    
    public static void op(boolean paramBoolean)
    {
      AppMethodBeat.i(250787);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhr, 1L, paramBoolean);
      AppMethodBeat.o(250787);
    }
    
    public static void oq(boolean paramBoolean)
    {
      AppMethodBeat.i(250788);
      r localr = r.vgF;
      r.idkeyStat(vgK, vhs, 1L, paramBoolean);
      AppMethodBeat.o(250788);
    }
    
    public static void or(boolean paramBoolean)
    {
      AppMethodBeat.i(250789);
      r localr = r.vgF;
      r.idkeyStat(vgK, vht, 1L, paramBoolean);
      AppMethodBeat.o(250789);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderStat$SyncCropVideoStat;", "", "()V", "id_syncCrop", "", "key_syncCropCost", "key_syncCropCount", "logId", "", "reportSyncCrop", "", "cost", "reportSyncCropKv", "originMediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "targetMediaInfo", "originFileSize", "targetFileSize", "ret", "plugin-finder_release"})
  public static final class e
  {
    private static final int hhs = 19063;
    private static final long vhA = 31L;
    public static final e vhB;
    private static final long vhy = 1253L;
    private static final long vhz = 30L;
    
    static
    {
      AppMethodBeat.i(166635);
      vhB = new e();
      vhy = 1253L;
      vhz = 30L;
      vhA = 31L;
      hhs = 19063;
      AppMethodBeat.o(166635);
    }
    
    public static void Fn(long paramLong)
    {
      AppMethodBeat.i(166633);
      h.CyF.n(vhy, vhz, 1L);
      h.CyF.n(vhy, vhA, paramLong);
      AppMethodBeat.o(166633);
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
        parama2 = r.vgF;
        Log.i(r.dou(), "report 19063: ".concat(String.valueOf(parama1)));
        h.CyF.kvStat(hhs, parama1);
        AppMethodBeat.o(166634);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderStat$VideoInvalidStat;", "", "()V", "idkeyId", "", "kvLogId", "", "reportVideo", "", "videoMime", "", "audioMime", "path", "plugin-finder_release"})
  public static final class f
  {
    private static final int vhC = 19441;
    private static final long vhD = 1253L;
    public static final f vhE;
    
    static
    {
      AppMethodBeat.i(178399);
      vhE = new f();
      vhC = 19441;
      vhD = 1253L;
      AppMethodBeat.o(178399);
    }
    
    public static void ai(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(178398);
      h localh = h.CyF;
      int i = vhC;
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
      localh.a(i, new Object[] { str, paramString1, paramString2 });
      h.CyF.n(vhD, 33L, 1L);
      AppMethodBeat.o(178398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.r
 * JD-Core Version:    0.7.0.1
 */