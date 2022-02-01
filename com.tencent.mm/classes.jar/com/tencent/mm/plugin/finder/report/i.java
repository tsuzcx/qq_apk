package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderStat;", "", "()V", "TAG", "", "FolderCapacityStat", "PostMediaProcessStat", "PostStat", "SyncCropVideoStat", "VideoInvalidStat", "plugin-finder_release"})
public final class i
{
  private static final String TAG = "Finder.FinderStat";
  public static final i ryl;
  
  static
  {
    AppMethodBeat.i(166636);
    ryl = new i();
    TAG = "Finder.FinderStat";
    AppMethodBeat.o(166636);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderStat$FolderCapacityStat;", "", "()V", "id_folder", "", "logId", "", "reportCapacity", "", "folderSizeMap", "", "", "reportNormalFolderClearCost", "costTime", "reportNormalFolderMarkCost", "reportPostFolderClearCost", "plugin-finder_release"})
  public static final class a
  {
    private static final int fYG = 18896;
    private static final long rym = 1267L;
    public static final a ryn;
    
    static
    {
      AppMethodBeat.i(166608);
      ryn = new a();
      fYG = 18896;
      rym = 1267L;
      AppMethodBeat.o(166608);
    }
    
    public static void W(Map<String, Long> paramMap)
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
        localObject = i.ryl;
        ac.i(i.cwX(), "report 18896: ".concat(String.valueOf(paramMap)));
        h.wUl.kvStat(fYG, paramMap);
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
    
    public static void uu(long paramLong)
    {
      AppMethodBeat.i(166605);
      h.wUl.n(rym, 1L, 1L);
      h.wUl.n(rym, 2L, paramLong);
      i locali = i.ryl;
      ac.d(i.cwX(), "reportNormalFolderClearCost " + rym + ", key:1,2, costTime:" + paramLong);
      AppMethodBeat.o(166605);
    }
    
    public static void uv(long paramLong)
    {
      AppMethodBeat.i(166606);
      h.wUl.n(rym, 3L, 1L);
      h.wUl.n(rym, 4L, paramLong);
      i locali = i.ryl;
      ac.d(i.cwX(), "reportNormalFolderMarkCost " + rym + ", key:3,4, costTime:" + paramLong);
      AppMethodBeat.o(166606);
    }
    
    public static void uw(long paramLong)
    {
      AppMethodBeat.i(166607);
      h.wUl.n(rym, 5L, 1L);
      h.wUl.n(rym, 6L, paramLong);
      i locali = i.ryl;
      ac.d(i.cwX(), "reportNormalFolderClearCost " + rym + ", key:5,6, costTime:" + paramLong);
      AppMethodBeat.o(166607);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/FinderStat$PostMediaProcessStat;", "", "()V", "id_remux", "", "key_postTotalCost", "key_postTotalCostCount", "key_postUploadCost", "key_postUploadCostCount", "key_remuxCost", "key_remuxCount", "key_remuxFailed", "key_remuxSize", "key_remux_file_error", "key_videoDuration", "key_zipCost", "key_zipCount", "key_zipFailed", "key_zipSize", "reportPostTotalCost", "", "cost", "reportPostUploadCost", "reportRemuxCost", "reportRemuxCount", "reportRemuxFailed", "reportRemuxOutputFileError", "reportRemuxSize", "size", "reportVideoDuration", "durationMs", "reportZipCost", "reportZipCount", "reportZipFailed", "reportZipSize", "plugin-finder_release"})
  public static final class b
  {
    private static final long ryA = 10L;
    private static final long ryB = 11L;
    private static final long ryC = 12L;
    public static final b ryD;
    private static final long ryo = 1253L;
    private static final long ryp = 0L;
    private static final long ryq = 1L;
    private static final long ryr = 2L;
    private static final long rys = 3L;
    private static final long ryt = 4L;
    private static final long ryu = 5L;
    private static final long ryv = 6L;
    private static final long ryw = 7L;
    private static final long ryx = 8L;
    private static final long ryy = 34L;
    private static final long ryz = 9L;
    
    static
    {
      AppMethodBeat.i(166620);
      ryD = new b();
      ryo = 1253L;
      ryq = 1L;
      ryr = 2L;
      rys = 3L;
      ryt = 4L;
      ryu = 5L;
      ryv = 6L;
      ryw = 7L;
      ryx = 8L;
      ryy = 34L;
      ryz = 9L;
      ryA = 10L;
      ryB = 11L;
      ryC = 12L;
      AppMethodBeat.o(166620);
    }
    
    public static void cwY()
    {
      AppMethodBeat.i(166609);
      h.wUl.n(ryo, ryp, 1L);
      AppMethodBeat.o(166609);
    }
    
    public static void cwZ()
    {
      AppMethodBeat.i(166611);
      h.wUl.n(ryo, ryr, 1L);
      AppMethodBeat.o(166611);
    }
    
    public static void cxa()
    {
      AppMethodBeat.i(202795);
      h.wUl.n(ryo, ryy, 1L);
      AppMethodBeat.o(202795);
    }
    
    public static void cxb()
    {
      AppMethodBeat.i(166613);
      h.wUl.n(ryo, ryt, 1L);
      AppMethodBeat.o(166613);
    }
    
    public static void cxc()
    {
      AppMethodBeat.i(166615);
      h.wUl.n(ryo, ryv, 1L);
      AppMethodBeat.o(166615);
    }
    
    public static void uA(long paramLong)
    {
      AppMethodBeat.i(166616);
      h.wUl.n(ryo, ryw, paramLong);
      AppMethodBeat.o(166616);
    }
    
    public static void uB(long paramLong)
    {
      AppMethodBeat.i(166617);
      h.wUl.n(ryo, ryx, paramLong);
      AppMethodBeat.o(166617);
    }
    
    public static void uC(long paramLong)
    {
      AppMethodBeat.i(166618);
      h.wUl.n(ryo, ryB, 1L);
      h.wUl.n(ryo, ryC, paramLong);
      AppMethodBeat.o(166618);
    }
    
    public static void uD(long paramLong)
    {
      AppMethodBeat.i(166619);
      h.wUl.n(ryo, ryz, 1L);
      h.wUl.n(ryo, ryA, paramLong);
      AppMethodBeat.o(166619);
    }
    
    public static void ux(long paramLong)
    {
      AppMethodBeat.i(166610);
      h.wUl.n(ryo, ryq, paramLong);
      AppMethodBeat.o(166610);
    }
    
    public static void uy(long paramLong)
    {
      AppMethodBeat.i(166612);
      h.wUl.n(ryo, rys, paramLong);
      AppMethodBeat.o(166612);
    }
    
    public static void uz(long paramLong)
    {
      AppMethodBeat.i(166614);
      h.wUl.n(ryo, ryu, paramLong);
      AppMethodBeat.o(166614);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.i
 * JD-Core Version:    0.7.0.1
 */