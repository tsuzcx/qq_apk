package com.tencent.mm.plugin.finder.report;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.plugin.sight.base.a;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/IDKey1371;", "", "()V", "CAPTURE_PHOTO", "", "CAPTURE_PHOTO_BACK", "CAPTURE_PHOTO_FRONT", "CAPTURE_PHOTO_WITH_BEAUTY", "ID", "SINGLE_VIDEO_BACK", "SINGLE_VIDEO_BEAUTY", "SINGLE_VIDEO_FRONT", "SINGLE_VIDEO_LENGTH_0_5", "SINGLE_VIDEO_LENGTH_10_15", "SINGLE_VIDEO_LENGTH_15_20", "SINGLE_VIDEO_LENGTH_20_30", "SINGLE_VIDEO_LENGTH_30_40", "SINGLE_VIDEO_LENGTH_40_50", "SINGLE_VIDEO_LENGTH_50_60", "SINGLE_VIDEO_LENGTH_5_10", "SINGLE_VIDEO_LENGTH_TOTAL", "SINGLE_VIDEO_NOT_ENOUGH", "SINGLE_VIDEO_SUCCESS", "SINGLE_VIDEO_TIME", "SUBVIDEO_AUTO_FINISH", "SUBVIDEO_CLICK_FINISH", "SUBVIDEO_NUM_0_3", "SUBVIDEO_NUM_10_15", "SUBVIDEO_NUM_15_20", "SUBVIDEO_NUM_3_6", "SUBVIDEO_NUM_6_10", "SUBVIDEO_PREPARE_DELETE", "SUBVIDEO_PRERARE_EXIT", "SUBVIDEO_SINGLE_LENGTH_0_5", "SUBVIDEO_SINGLE_LENGTH_10_15", "SUBVIDEO_SINGLE_LENGTH_15_20", "SUBVIDEO_SINGLE_LENGTH_20_30", "SUBVIDEO_SINGLE_LENGTH_30_40", "SUBVIDEO_SINGLE_LENGTH_40_50", "SUBVIDEO_SINGLE_LENGTH_50_60", "SUBVIDEO_SINGLE_LENGTH_5_10", "SUBVIDEO_SURE_DELETE", "SUBVIDEO_SURE_EXIT", "SUBVIDEO_TIME", "SUBVIDEO_TIME_NOT_ENOUGH", "SUBVIDEO_TIME_SUCCESS", "SUBVIDEO_TIME_TOTAL_DURATION", "SUBVIDEO_TOTAL_LENGTH_0_5", "SUBVIDEO_TOTAL_LENGTH_10_15", "SUBVIDEO_TOTAL_LENGTH_15_20", "SUBVIDEO_TOTAL_LENGTH_20_30", "SUBVIDEO_TOTAL_LENGTH_30_40", "SUBVIDEO_TOTAL_LENGTH_40_50", "SUBVIDEO_TOTAL_LENGTH_50_60", "SUBVIDEO_TOTAL_LENGTH_5_10", "SUBVIDEO_TOTAL_NUM", "capturePhoto", "", "capturePhotoBack", "capturePhotoCamera", "isBack", "", "capturePhotoFront", "capturePhotoWithBeauty", "captureSingleVideo", "captureSingleVideoBack", "captureSingleVideoBeauty", "captureSingleVideoCamera", "captureSingleVideoDuration", "durationMs", "captureSingleVideoFront", "captureSingleVideoNotEnough", "captureSingleVideoSuccess", "captureSingleVideoTotal", "report", "key", "value", "subVideoAutoFinish", "subVideoClickFinish", "subVideoDuration", "fileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "subVideoNotEnough", "subVideoNum", "num", "subVideoPrepareDelete", "subVideoPrepareExit", "subVideoSingleTime", "subVideoSuccess", "subVideoSureDelete", "subVideoSureExit", "subVideoTime", "subVideoTotalTime", "plugin-finder_release"})
public final class q
{
  public static final q KVK;
  
  static
  {
    AppMethodBeat.i(198881);
    KVK = new q();
    AppMethodBeat.o(198881);
  }
  
  public static void BO(long paramLong)
  {
    AppMethodBeat.i(198877);
    ay(218L, paramLong);
    if (paramLong < 5000L)
    {
      ay(220L, 1L);
      AppMethodBeat.o(198877);
      return;
    }
    if (paramLong < 10000L)
    {
      ay(221L, 1L);
      AppMethodBeat.o(198877);
      return;
    }
    if (paramLong < 15000L)
    {
      ay(222L, 1L);
      AppMethodBeat.o(198877);
      return;
    }
    if (paramLong < 20000L)
    {
      ay(223L, 1L);
      AppMethodBeat.o(198877);
      return;
    }
    if (paramLong < 30000L)
    {
      ay(224L, 1L);
      AppMethodBeat.o(198877);
      return;
    }
    if (paramLong < 40000L)
    {
      ay(225L, 1L);
      AppMethodBeat.o(198877);
      return;
    }
    if (paramLong < 50000L)
    {
      ay(226L, 1L);
      AppMethodBeat.o(198877);
      return;
    }
    ay(227L, 1L);
    AppMethodBeat.o(198877);
  }
  
  public static void aX(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(198878);
    k.h(paramArrayList, "fileList");
    com.tencent.e.h.Iye.aP((Runnable)new a(paramArrayList));
    AppMethodBeat.o(198878);
  }
  
  public static void ay(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(198879);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1371L, paramLong1, paramLong2, false);
    AppMethodBeat.o(198879);
  }
  
  public static void yE(boolean paramBoolean)
  {
    AppMethodBeat.i(198875);
    if (paramBoolean)
    {
      ay(202L, 1L);
      AppMethodBeat.o(198875);
      return;
    }
    ay(201L, 1L);
    AppMethodBeat.o(198875);
  }
  
  public static void yF(boolean paramBoolean)
  {
    AppMethodBeat.i(198876);
    if (paramBoolean)
    {
      ay(214L, 1L);
      AppMethodBeat.o(198876);
      return;
    }
    ay(213L, 1L);
    AppMethodBeat.o(198876);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(198874);
      long l1 = 0L;
      Object localObject1 = ((Iterable)this.KVL).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        Object localObject3 = c.rMg;
        localObject2 = c.ZP((String)localObject2);
        long l2 = ((a)localObject2).videoDuration;
        localObject3 = q.KVK;
        q.BQ(((a)localObject2).videoDuration);
        l1 = l2 + l1;
      }
      localObject1 = q.KVK;
      q.BR(l1);
      localObject1 = q.KVK;
      q.BS(this.KVL.size());
      AppMethodBeat.o(198874);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.q
 * JD-Core Version:    0.7.0.1
 */