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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/IDKey1371;", "", "()V", "CAPTURE_PHOTO", "", "CAPTURE_PHOTO_BACK", "CAPTURE_PHOTO_FRONT", "CAPTURE_PHOTO_WITH_BEAUTY", "ID", "SINGLE_VIDEO_BACK", "SINGLE_VIDEO_BEAUTY", "SINGLE_VIDEO_FRONT", "SINGLE_VIDEO_LENGTH_0_5", "SINGLE_VIDEO_LENGTH_10_15", "SINGLE_VIDEO_LENGTH_15_20", "SINGLE_VIDEO_LENGTH_20_30", "SINGLE_VIDEO_LENGTH_30_40", "SINGLE_VIDEO_LENGTH_40_50", "SINGLE_VIDEO_LENGTH_50_60", "SINGLE_VIDEO_LENGTH_5_10", "SINGLE_VIDEO_LENGTH_TOTAL", "SINGLE_VIDEO_NOT_ENOUGH", "SINGLE_VIDEO_SUCCESS", "SINGLE_VIDEO_TIME", "SUBVIDEO_AUTO_FINISH", "SUBVIDEO_CLICK_FINISH", "SUBVIDEO_NUM_0_3", "SUBVIDEO_NUM_10_15", "SUBVIDEO_NUM_15_20", "SUBVIDEO_NUM_3_6", "SUBVIDEO_NUM_6_10", "SUBVIDEO_PREPARE_DELETE", "SUBVIDEO_PRERARE_EXIT", "SUBVIDEO_SINGLE_LENGTH_0_5", "SUBVIDEO_SINGLE_LENGTH_10_15", "SUBVIDEO_SINGLE_LENGTH_15_20", "SUBVIDEO_SINGLE_LENGTH_20_30", "SUBVIDEO_SINGLE_LENGTH_30_40", "SUBVIDEO_SINGLE_LENGTH_40_50", "SUBVIDEO_SINGLE_LENGTH_50_60", "SUBVIDEO_SINGLE_LENGTH_5_10", "SUBVIDEO_SURE_DELETE", "SUBVIDEO_SURE_EXIT", "SUBVIDEO_TIME", "SUBVIDEO_TIME_NOT_ENOUGH", "SUBVIDEO_TIME_SUCCESS", "SUBVIDEO_TIME_TOTAL_DURATION", "SUBVIDEO_TOTAL_LENGTH_0_5", "SUBVIDEO_TOTAL_LENGTH_10_15", "SUBVIDEO_TOTAL_LENGTH_15_20", "SUBVIDEO_TOTAL_LENGTH_20_30", "SUBVIDEO_TOTAL_LENGTH_30_40", "SUBVIDEO_TOTAL_LENGTH_40_50", "SUBVIDEO_TOTAL_LENGTH_50_60", "SUBVIDEO_TOTAL_LENGTH_5_10", "SUBVIDEO_TOTAL_NUM", "capturePhoto", "", "capturePhotoBack", "capturePhotoCamera", "isBack", "", "capturePhotoFront", "capturePhotoWithBeauty", "captureSingleVideo", "captureSingleVideoBack", "captureSingleVideoBeauty", "captureSingleVideoCamera", "captureSingleVideoDuration", "durationMs", "captureSingleVideoFront", "captureSingleVideoNotEnough", "captureSingleVideoSuccess", "captureSingleVideoTotal", "report", "key", "value", "subVideoAutoFinish", "subVideoClickFinish", "subVideoDuration", "fileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "subVideoNotEnough", "subVideoNum", "num", "subVideoPrepareDelete", "subVideoPrepareExit", "subVideoSingleTime", "subVideoSuccess", "subVideoSureDelete", "subVideoSureExit", "subVideoTime", "subVideoTotalTime", "plugin-finder_release"})
public final class u
{
  public static final u sCl;
  
  static
  {
    AppMethodBeat.i(203945);
    sCl = new u();
    AppMethodBeat.o(203945);
  }
  
  public static void L(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(203943);
    g.yxI.idkeyStat(1371L, paramLong1, paramLong2, false);
    AppMethodBeat.o(203943);
  }
  
  public static void V(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(203942);
    p.h(paramArrayList, "fileList");
    h.MqF.aO((Runnable)new a(paramArrayList));
    AppMethodBeat.o(203942);
  }
  
  public static void lZ(boolean paramBoolean)
  {
    AppMethodBeat.i(203939);
    if (paramBoolean)
    {
      L(202L, 1L);
      AppMethodBeat.o(203939);
      return;
    }
    L(201L, 1L);
    AppMethodBeat.o(203939);
  }
  
  public static void ma(boolean paramBoolean)
  {
    AppMethodBeat.i(203940);
    if (paramBoolean)
    {
      L(214L, 1L);
      AppMethodBeat.o(203940);
      return;
    }
    L(213L, 1L);
    AppMethodBeat.o(203940);
  }
  
  public static void wX(long paramLong)
  {
    AppMethodBeat.i(203941);
    L(218L, paramLong);
    if (paramLong < 5000L)
    {
      L(220L, 1L);
      AppMethodBeat.o(203941);
      return;
    }
    if (paramLong < 10000L)
    {
      L(221L, 1L);
      AppMethodBeat.o(203941);
      return;
    }
    if (paramLong < 15000L)
    {
      L(222L, 1L);
      AppMethodBeat.o(203941);
      return;
    }
    if (paramLong < 20000L)
    {
      L(223L, 1L);
      AppMethodBeat.o(203941);
      return;
    }
    if (paramLong < 30000L)
    {
      L(224L, 1L);
      AppMethodBeat.o(203941);
      return;
    }
    if (paramLong < 40000L)
    {
      L(225L, 1L);
      AppMethodBeat.o(203941);
      return;
    }
    if (paramLong < 50000L)
    {
      L(226L, 1L);
      AppMethodBeat.o(203941);
      return;
    }
    L(227L, 1L);
    AppMethodBeat.o(203941);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(203938);
      long l1 = 0L;
      Object localObject1 = ((Iterable)this.sCm).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        Object localObject3 = c.ubl;
        localObject2 = c.ajS((String)localObject2);
        long l2 = ((a)localObject2).videoDuration;
        localObject3 = u.sCl;
        u.wZ(((a)localObject2).videoDuration);
        l1 = l2 + l1;
      }
      localObject1 = u.sCl;
      u.xa(l1);
      localObject1 = u.sCl;
      u.xb(this.sCm.size());
      AppMethodBeat.o(203938);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.u
 * JD-Core Version:    0.7.0.1
 */