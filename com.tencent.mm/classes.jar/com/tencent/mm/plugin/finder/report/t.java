package com.tencent.mm.plugin.finder.report;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/IDKey1371;", "", "()V", "CAPTURE_PHOTO", "", "CAPTURE_PHOTO_BACK", "CAPTURE_PHOTO_FRONT", "CAPTURE_PHOTO_WITH_BEAUTY", "ID", "SINGLE_VIDEO_BACK", "SINGLE_VIDEO_BEAUTY", "SINGLE_VIDEO_FRONT", "SINGLE_VIDEO_LENGTH_0_5", "SINGLE_VIDEO_LENGTH_10_15", "SINGLE_VIDEO_LENGTH_15_20", "SINGLE_VIDEO_LENGTH_20_30", "SINGLE_VIDEO_LENGTH_30_40", "SINGLE_VIDEO_LENGTH_40_50", "SINGLE_VIDEO_LENGTH_50_60", "SINGLE_VIDEO_LENGTH_5_10", "SINGLE_VIDEO_LENGTH_TOTAL", "SINGLE_VIDEO_NOT_ENOUGH", "SINGLE_VIDEO_SUCCESS", "SINGLE_VIDEO_TIME", "SUBVIDEO_AUTO_FINISH", "SUBVIDEO_CLICK_FINISH", "SUBVIDEO_NUM_0_3", "SUBVIDEO_NUM_10_15", "SUBVIDEO_NUM_15_20", "SUBVIDEO_NUM_3_6", "SUBVIDEO_NUM_6_10", "SUBVIDEO_PREPARE_DELETE", "SUBVIDEO_PRERARE_EXIT", "SUBVIDEO_SINGLE_LENGTH_0_5", "SUBVIDEO_SINGLE_LENGTH_10_15", "SUBVIDEO_SINGLE_LENGTH_15_20", "SUBVIDEO_SINGLE_LENGTH_20_30", "SUBVIDEO_SINGLE_LENGTH_30_40", "SUBVIDEO_SINGLE_LENGTH_40_50", "SUBVIDEO_SINGLE_LENGTH_50_60", "SUBVIDEO_SINGLE_LENGTH_5_10", "SUBVIDEO_SURE_DELETE", "SUBVIDEO_SURE_EXIT", "SUBVIDEO_TIME", "SUBVIDEO_TIME_NOT_ENOUGH", "SUBVIDEO_TIME_SUCCESS", "SUBVIDEO_TIME_TOTAL_DURATION", "SUBVIDEO_TOTAL_LENGTH_0_5", "SUBVIDEO_TOTAL_LENGTH_10_15", "SUBVIDEO_TOTAL_LENGTH_15_20", "SUBVIDEO_TOTAL_LENGTH_20_30", "SUBVIDEO_TOTAL_LENGTH_30_40", "SUBVIDEO_TOTAL_LENGTH_40_50", "SUBVIDEO_TOTAL_LENGTH_50_60", "SUBVIDEO_TOTAL_LENGTH_5_10", "SUBVIDEO_TOTAL_NUM", "capturePhoto", "", "capturePhotoBack", "capturePhotoCamera", "isBack", "", "capturePhotoFront", "capturePhotoWithBeauty", "captureSingleVideo", "captureSingleVideoBack", "captureSingleVideoBeauty", "captureSingleVideoCamera", "captureSingleVideoDuration", "durationMs", "captureSingleVideoFront", "captureSingleVideoNotEnough", "captureSingleVideoSuccess", "captureSingleVideoTotal", "report", "key", "value", "subVideoAutoFinish", "subVideoClickFinish", "subVideoDuration", "fileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "subVideoNotEnough", "subVideoNum", "num", "subVideoPrepareDelete", "subVideoPrepareExit", "subVideoSingleTime", "subVideoSuccess", "subVideoSureDelete", "subVideoSureExit", "subVideoTime", "subVideoTotalTime", "plugin-finder_release"})
public final class t
{
  public static final t ssb;
  
  static
  {
    AppMethodBeat.i(203386);
    ssb = new t();
    AppMethodBeat.o(203386);
  }
  
  public static void M(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(203384);
    g.yhR.idkeyStat(1371L, paramLong1, paramLong2, false);
    AppMethodBeat.o(203384);
  }
  
  public static void V(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(203383);
    p.h(paramArrayList, "fileList");
    h.LTJ.aR((Runnable)new a(paramArrayList));
    AppMethodBeat.o(203383);
  }
  
  public static void lY(boolean paramBoolean)
  {
    AppMethodBeat.i(203380);
    if (paramBoolean)
    {
      M(202L, 1L);
      AppMethodBeat.o(203380);
      return;
    }
    M(201L, 1L);
    AppMethodBeat.o(203380);
  }
  
  public static void lZ(boolean paramBoolean)
  {
    AppMethodBeat.i(203381);
    if (paramBoolean)
    {
      M(214L, 1L);
      AppMethodBeat.o(203381);
      return;
    }
    M(213L, 1L);
    AppMethodBeat.o(203381);
  }
  
  public static void wG(long paramLong)
  {
    AppMethodBeat.i(203382);
    M(218L, paramLong);
    if (paramLong < 5000L)
    {
      M(220L, 1L);
      AppMethodBeat.o(203382);
      return;
    }
    if (paramLong < 10000L)
    {
      M(221L, 1L);
      AppMethodBeat.o(203382);
      return;
    }
    if (paramLong < 15000L)
    {
      M(222L, 1L);
      AppMethodBeat.o(203382);
      return;
    }
    if (paramLong < 20000L)
    {
      M(223L, 1L);
      AppMethodBeat.o(203382);
      return;
    }
    if (paramLong < 30000L)
    {
      M(224L, 1L);
      AppMethodBeat.o(203382);
      return;
    }
    if (paramLong < 40000L)
    {
      M(225L, 1L);
      AppMethodBeat.o(203382);
      return;
    }
    if (paramLong < 50000L)
    {
      M(226L, 1L);
      AppMethodBeat.o(203382);
      return;
    }
    M(227L, 1L);
    AppMethodBeat.o(203382);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(203379);
      long l1 = 0L;
      Object localObject1 = ((Iterable)this.ssc).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        Object localObject3 = c.tQu;
        localObject2 = c.aiV((String)localObject2);
        long l2 = ((a)localObject2).videoDuration;
        localObject3 = t.ssb;
        t.wI(((a)localObject2).videoDuration);
        l1 = l2 + l1;
      }
      localObject1 = t.ssb;
      t.wJ(l1);
      localObject1 = t.ssb;
      t.wK(this.ssc.size());
      AppMethodBeat.o(203379);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.t
 * JD-Core Version:    0.7.0.1
 */