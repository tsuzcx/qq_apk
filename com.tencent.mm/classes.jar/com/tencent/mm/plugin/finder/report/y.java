package com.tencent.mm.plugin.finder.report;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.sight.base.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/IDKey1371;", "", "()V", "CAPTURE_PHOTO", "", "CAPTURE_PHOTO_BACK", "CAPTURE_PHOTO_FRONT", "CAPTURE_PHOTO_WITH_BEAUTY", "ID", "SINGLE_VIDEO_BACK", "SINGLE_VIDEO_BEAUTY", "SINGLE_VIDEO_FRONT", "SINGLE_VIDEO_LENGTH_0_5", "SINGLE_VIDEO_LENGTH_10_15", "SINGLE_VIDEO_LENGTH_15_20", "SINGLE_VIDEO_LENGTH_20_30", "SINGLE_VIDEO_LENGTH_30_40", "SINGLE_VIDEO_LENGTH_40_50", "SINGLE_VIDEO_LENGTH_50_60", "SINGLE_VIDEO_LENGTH_5_10", "SINGLE_VIDEO_LENGTH_TOTAL", "SINGLE_VIDEO_NOT_ENOUGH", "SINGLE_VIDEO_SUCCESS", "SINGLE_VIDEO_TIME", "SUBVIDEO_AUTO_FINISH", "SUBVIDEO_CLICK_FINISH", "SUBVIDEO_NUM_0_3", "SUBVIDEO_NUM_10_15", "SUBVIDEO_NUM_15_20", "SUBVIDEO_NUM_3_6", "SUBVIDEO_NUM_6_10", "SUBVIDEO_PREPARE_DELETE", "SUBVIDEO_PRERARE_EXIT", "SUBVIDEO_SINGLE_LENGTH_0_5", "SUBVIDEO_SINGLE_LENGTH_10_15", "SUBVIDEO_SINGLE_LENGTH_15_20", "SUBVIDEO_SINGLE_LENGTH_20_30", "SUBVIDEO_SINGLE_LENGTH_30_40", "SUBVIDEO_SINGLE_LENGTH_40_50", "SUBVIDEO_SINGLE_LENGTH_50_60", "SUBVIDEO_SINGLE_LENGTH_5_10", "SUBVIDEO_SURE_DELETE", "SUBVIDEO_SURE_EXIT", "SUBVIDEO_TIME", "SUBVIDEO_TIME_NOT_ENOUGH", "SUBVIDEO_TIME_SUCCESS", "SUBVIDEO_TIME_TOTAL_DURATION", "SUBVIDEO_TOTAL_LENGTH_0_5", "SUBVIDEO_TOTAL_LENGTH_10_15", "SUBVIDEO_TOTAL_LENGTH_15_20", "SUBVIDEO_TOTAL_LENGTH_20_30", "SUBVIDEO_TOTAL_LENGTH_30_40", "SUBVIDEO_TOTAL_LENGTH_40_50", "SUBVIDEO_TOTAL_LENGTH_50_60", "SUBVIDEO_TOTAL_LENGTH_5_10", "SUBVIDEO_TOTAL_NUM", "capturePhoto", "", "capturePhotoBack", "capturePhotoCamera", "isBack", "", "capturePhotoFront", "capturePhotoWithBeauty", "captureSingleVideo", "captureSingleVideoBack", "captureSingleVideoBeauty", "captureSingleVideoCamera", "captureSingleVideoDuration", "durationMs", "captureSingleVideoFront", "captureSingleVideoNotEnough", "captureSingleVideoSuccess", "captureSingleVideoTotal", "report", "key", "value", "subVideoAutoFinish", "subVideoClickFinish", "subVideoDuration", "fileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "subVideoNotEnough", "subVideoNum", "num", "subVideoPrepareDelete", "subVideoPrepareExit", "subVideoSingleTime", "subVideoSuccess", "subVideoSureDelete", "subVideoSureExit", "subVideoTime", "subVideoTotalTime", "plugin-finder_release"})
public final class y
{
  public static final y vih;
  
  static
  {
    AppMethodBeat.i(250824);
    vih = new y();
    AppMethodBeat.o(250824);
  }
  
  public static void Fo(long paramLong)
  {
    AppMethodBeat.i(250820);
    Q(218L, paramLong);
    if (paramLong < 5000L)
    {
      Q(220L, 1L);
      AppMethodBeat.o(250820);
      return;
    }
    if (paramLong < 10000L)
    {
      Q(221L, 1L);
      AppMethodBeat.o(250820);
      return;
    }
    if (paramLong < 15000L)
    {
      Q(222L, 1L);
      AppMethodBeat.o(250820);
      return;
    }
    if (paramLong < 20000L)
    {
      Q(223L, 1L);
      AppMethodBeat.o(250820);
      return;
    }
    if (paramLong < 30000L)
    {
      Q(224L, 1L);
      AppMethodBeat.o(250820);
      return;
    }
    if (paramLong < 40000L)
    {
      Q(225L, 1L);
      AppMethodBeat.o(250820);
      return;
    }
    if (paramLong < 50000L)
    {
      Q(226L, 1L);
      AppMethodBeat.o(250820);
      return;
    }
    Q(227L, 1L);
    AppMethodBeat.o(250820);
  }
  
  public static void Q(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(250822);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1371L, paramLong1, paramLong2, false);
    AppMethodBeat.o(250822);
  }
  
  public static void ah(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(250821);
    p.h(paramArrayList, "fileList");
    com.tencent.f.h.RTc.aX((Runnable)new a(paramArrayList));
    AppMethodBeat.o(250821);
  }
  
  public static void os(boolean paramBoolean)
  {
    AppMethodBeat.i(250818);
    if (paramBoolean)
    {
      Q(202L, 1L);
      AppMethodBeat.o(250818);
      return;
    }
    Q(201L, 1L);
    AppMethodBeat.o(250818);
  }
  
  public static void ot(boolean paramBoolean)
  {
    AppMethodBeat.i(250819);
    if (paramBoolean)
    {
      Q(214L, 1L);
      AppMethodBeat.o(250819);
      return;
    }
    Q(213L, 1L);
    AppMethodBeat.o(250819);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(250817);
      long l1 = 0L;
      Object localObject1 = ((Iterable)this.vii).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        Object localObject3 = c.xsz;
        localObject2 = c.awl((String)localObject2);
        long l2 = ((a)localObject2).videoDuration;
        localObject3 = y.vih;
        y.Fq(((a)localObject2).videoDuration);
        l1 = l2 + l1;
      }
      localObject1 = y.vih;
      y.Fr(l1);
      localObject1 = y.vih;
      y.Fs(this.vii.size());
      AppMethodBeat.o(250817);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.y
 * JD-Core Version:    0.7.0.1
 */