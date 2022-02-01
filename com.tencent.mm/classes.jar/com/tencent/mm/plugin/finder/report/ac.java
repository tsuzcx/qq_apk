package com.tencent.mm.plugin.finder.report;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.sight.base.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/IDKey1371;", "", "()V", "CAPTURE_PHOTO", "", "CAPTURE_PHOTO_BACK", "CAPTURE_PHOTO_FRONT", "CAPTURE_PHOTO_WITH_BEAUTY", "ID", "SINGLE_VIDEO_BACK", "SINGLE_VIDEO_BEAUTY", "SINGLE_VIDEO_FRONT", "SINGLE_VIDEO_LENGTH_0_5", "SINGLE_VIDEO_LENGTH_10_15", "SINGLE_VIDEO_LENGTH_15_20", "SINGLE_VIDEO_LENGTH_20_30", "SINGLE_VIDEO_LENGTH_30_40", "SINGLE_VIDEO_LENGTH_40_50", "SINGLE_VIDEO_LENGTH_50_60", "SINGLE_VIDEO_LENGTH_5_10", "SINGLE_VIDEO_LENGTH_TOTAL", "SINGLE_VIDEO_NOT_ENOUGH", "SINGLE_VIDEO_SUCCESS", "SINGLE_VIDEO_TIME", "SUBVIDEO_AUTO_FINISH", "SUBVIDEO_CLICK_FINISH", "SUBVIDEO_NUM_0_3", "SUBVIDEO_NUM_10_15", "SUBVIDEO_NUM_15_20", "SUBVIDEO_NUM_3_6", "SUBVIDEO_NUM_6_10", "SUBVIDEO_PREPARE_DELETE", "SUBVIDEO_PRERARE_EXIT", "SUBVIDEO_SINGLE_LENGTH_0_5", "SUBVIDEO_SINGLE_LENGTH_10_15", "SUBVIDEO_SINGLE_LENGTH_15_20", "SUBVIDEO_SINGLE_LENGTH_20_30", "SUBVIDEO_SINGLE_LENGTH_30_40", "SUBVIDEO_SINGLE_LENGTH_40_50", "SUBVIDEO_SINGLE_LENGTH_50_60", "SUBVIDEO_SINGLE_LENGTH_5_10", "SUBVIDEO_SURE_DELETE", "SUBVIDEO_SURE_EXIT", "SUBVIDEO_TIME", "SUBVIDEO_TIME_NOT_ENOUGH", "SUBVIDEO_TIME_SUCCESS", "SUBVIDEO_TIME_TOTAL_DURATION", "SUBVIDEO_TOTAL_LENGTH_0_5", "SUBVIDEO_TOTAL_LENGTH_10_15", "SUBVIDEO_TOTAL_LENGTH_15_20", "SUBVIDEO_TOTAL_LENGTH_20_30", "SUBVIDEO_TOTAL_LENGTH_30_40", "SUBVIDEO_TOTAL_LENGTH_40_50", "SUBVIDEO_TOTAL_LENGTH_50_60", "SUBVIDEO_TOTAL_LENGTH_5_10", "SUBVIDEO_TOTAL_NUM", "capturePhoto", "", "capturePhotoBack", "capturePhotoCamera", "isBack", "", "capturePhotoFront", "capturePhotoWithBeauty", "captureSingleVideo", "captureSingleVideoBack", "captureSingleVideoBeauty", "captureSingleVideoCamera", "captureSingleVideoDuration", "durationMs", "captureSingleVideoFront", "captureSingleVideoNotEnough", "captureSingleVideoSuccess", "captureSingleVideoTotal", "report", "key", "value", "subVideoAutoFinish", "subVideoClickFinish", "subVideoDuration", "fileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "subVideoNotEnough", "subVideoNum", "num", "subVideoPrepareDelete", "subVideoPrepareExit", "subVideoSingleTime", "subVideoSuccess", "subVideoSureDelete", "subVideoSureExit", "subVideoTime", "subVideoTotalTime", "plugin-finder_release"})
public final class ac
{
  public static final ac zZo;
  
  static
  {
    AppMethodBeat.i(283282);
    zZo = new ac();
    AppMethodBeat.o(283282);
  }
  
  public static void Mx(long paramLong)
  {
    AppMethodBeat.i(283278);
    V(218L, paramLong);
    if (paramLong < 5000L)
    {
      V(220L, 1L);
      AppMethodBeat.o(283278);
      return;
    }
    if (paramLong < 10000L)
    {
      V(221L, 1L);
      AppMethodBeat.o(283278);
      return;
    }
    if (paramLong < 15000L)
    {
      V(222L, 1L);
      AppMethodBeat.o(283278);
      return;
    }
    if (paramLong < 20000L)
    {
      V(223L, 1L);
      AppMethodBeat.o(283278);
      return;
    }
    if (paramLong < 30000L)
    {
      V(224L, 1L);
      AppMethodBeat.o(283278);
      return;
    }
    if (paramLong < 40000L)
    {
      V(225L, 1L);
      AppMethodBeat.o(283278);
      return;
    }
    if (paramLong < 50000L)
    {
      V(226L, 1L);
      AppMethodBeat.o(283278);
      return;
    }
    V(227L, 1L);
    AppMethodBeat.o(283278);
  }
  
  public static void V(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(283280);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1371L, paramLong1, paramLong2, false);
    AppMethodBeat.o(283280);
  }
  
  public static void ao(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(283279);
    p.k(paramArrayList, "fileList");
    com.tencent.e.h.ZvG.be((Runnable)new a(paramArrayList));
    AppMethodBeat.o(283279);
  }
  
  public static void qD(boolean paramBoolean)
  {
    AppMethodBeat.i(283276);
    if (paramBoolean)
    {
      V(202L, 1L);
      AppMethodBeat.o(283276);
      return;
    }
    V(201L, 1L);
    AppMethodBeat.o(283276);
  }
  
  public static void qE(boolean paramBoolean)
  {
    AppMethodBeat.i(283277);
    if (paramBoolean)
    {
      V(214L, 1L);
      AppMethodBeat.o(283277);
      return;
    }
    V(213L, 1L);
    AppMethodBeat.o(283277);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(282710);
      long l1 = 0L;
      Object localObject1 = ((Iterable)this.zZp).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        Object localObject3 = d.CeY;
        localObject2 = d.aFG((String)localObject2);
        long l2 = ((b)localObject2).videoDuration;
        localObject3 = ac.zZo;
        ac.Mz(((b)localObject2).videoDuration);
        l1 = l2 + l1;
      }
      localObject1 = ac.zZo;
      ac.MA(l1);
      localObject1 = ac.zZo;
      ac.MB(this.zZp.size());
      AppMethodBeat.o(282710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ac
 * JD-Core Version:    0.7.0.1
 */