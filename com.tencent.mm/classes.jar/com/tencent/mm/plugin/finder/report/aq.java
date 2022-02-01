package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.g;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/IDKey1371;", "", "()V", "CAPTURE_PHOTO", "", "CAPTURE_PHOTO_BACK", "CAPTURE_PHOTO_FRONT", "CAPTURE_PHOTO_WITH_BEAUTY", "ID", "SINGLE_VIDEO_BACK", "SINGLE_VIDEO_BEAUTY", "SINGLE_VIDEO_FRONT", "SINGLE_VIDEO_LENGTH_0_5", "SINGLE_VIDEO_LENGTH_10_15", "SINGLE_VIDEO_LENGTH_15_20", "SINGLE_VIDEO_LENGTH_20_30", "SINGLE_VIDEO_LENGTH_30_40", "SINGLE_VIDEO_LENGTH_40_50", "SINGLE_VIDEO_LENGTH_50_60", "SINGLE_VIDEO_LENGTH_5_10", "SINGLE_VIDEO_LENGTH_TOTAL", "SINGLE_VIDEO_NOT_ENOUGH", "SINGLE_VIDEO_SUCCESS", "SINGLE_VIDEO_TIME", "SUBVIDEO_AUTO_FINISH", "SUBVIDEO_CLICK_FINISH", "SUBVIDEO_NUM_0_3", "SUBVIDEO_NUM_10_15", "SUBVIDEO_NUM_15_20", "SUBVIDEO_NUM_3_6", "SUBVIDEO_NUM_6_10", "SUBVIDEO_PREPARE_DELETE", "SUBVIDEO_PRERARE_EXIT", "SUBVIDEO_SINGLE_LENGTH_0_5", "SUBVIDEO_SINGLE_LENGTH_10_15", "SUBVIDEO_SINGLE_LENGTH_15_20", "SUBVIDEO_SINGLE_LENGTH_20_30", "SUBVIDEO_SINGLE_LENGTH_30_40", "SUBVIDEO_SINGLE_LENGTH_40_50", "SUBVIDEO_SINGLE_LENGTH_50_60", "SUBVIDEO_SINGLE_LENGTH_5_10", "SUBVIDEO_SURE_DELETE", "SUBVIDEO_SURE_EXIT", "SUBVIDEO_TIME", "SUBVIDEO_TIME_NOT_ENOUGH", "SUBVIDEO_TIME_SUCCESS", "SUBVIDEO_TIME_TOTAL_DURATION", "SUBVIDEO_TOTAL_LENGTH_0_5", "SUBVIDEO_TOTAL_LENGTH_10_15", "SUBVIDEO_TOTAL_LENGTH_15_20", "SUBVIDEO_TOTAL_LENGTH_20_30", "SUBVIDEO_TOTAL_LENGTH_30_40", "SUBVIDEO_TOTAL_LENGTH_40_50", "SUBVIDEO_TOTAL_LENGTH_50_60", "SUBVIDEO_TOTAL_LENGTH_5_10", "SUBVIDEO_TOTAL_NUM", "capturePhoto", "", "capturePhotoBack", "capturePhotoCamera", "isBack", "", "capturePhotoFront", "capturePhotoWithBeauty", "captureSingleVideo", "captureSingleVideoBack", "captureSingleVideoBeauty", "captureSingleVideoCamera", "captureSingleVideoDuration", "durationMs", "captureSingleVideoFront", "captureSingleVideoNotEnough", "captureSingleVideoSuccess", "captureSingleVideoTotal", "report", "key", "value", "subVideoAutoFinish", "subVideoClickFinish", "subVideoDuration", "fileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "subVideoNotEnough", "subVideoNum", "num", "subVideoPrepareDelete", "subVideoPrepareExit", "subVideoSingleTime", "subVideoSuccess", "subVideoSureDelete", "subVideoSureExit", "subVideoTime", "subVideoTotalTime", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq
{
  public static final aq Fuh;
  
  static
  {
    AppMethodBeat.i(331230);
    Fuh = new aq();
    AppMethodBeat.o(331230);
  }
  
  public static void as(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(331181);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1371L, paramLong1, paramLong2, false);
    AppMethodBeat.o(331181);
  }
  
  public static void aw(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(331166);
    s.u(paramArrayList, "fileList");
    com.tencent.threadpool.h.ahAA.bm(new aq..ExternalSyntheticLambda0(paramArrayList));
    AppMethodBeat.o(331166);
  }
  
  private static final void ax(ArrayList paramArrayList)
  {
    AppMethodBeat.i(331220);
    s.u(paramArrayList, "$fileList");
    long l1 = 0L;
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      g localg = g.HRf;
      localObject = g.aBH((String)localObject);
      l1 = ((b)localObject).videoDuration + l1;
      long l2 = ((b)localObject).videoDuration;
      if (l2 < 5000L) {
        as(234L, 1L);
      } else if (l2 < 10000L) {
        as(235L, 1L);
      } else if (l2 < 15000L) {
        as(236L, 1L);
      } else if (l2 < 20000L) {
        as(237L, 1L);
      } else if (l2 < 30000L) {
        as(238L, 1L);
      } else if (l2 < 40000L) {
        as(239L, 1L);
      } else if (l2 < 50000L) {
        as(240L, 1L);
      } else if (l2 < 60000L) {
        as(241L, 1L);
      }
    }
    as(231L, l1);
    if (l1 < 5000L) {
      as(242L, 1L);
    }
    for (;;)
    {
      l1 = paramArrayList.size();
      as(250L, l1);
      if (l1 > 3L) {
        break;
      }
      as(251L, 1L);
      AppMethodBeat.o(331220);
      return;
      if (l1 < 10000L) {
        as(243L, 1L);
      } else if (l1 < 15000L) {
        as(244L, 1L);
      } else if (l1 < 20000L) {
        as(245L, 1L);
      } else if (l1 < 30000L) {
        as(246L, 1L);
      } else if (l1 < 40000L) {
        as(247L, 1L);
      } else if (l1 < 50000L) {
        as(248L, 1L);
      } else if (l1 < 60000L) {
        as(249L, 1L);
      }
    }
    if (l1 <= 6L)
    {
      as(252L, 1L);
      AppMethodBeat.o(331220);
      return;
    }
    if (l1 <= 10L)
    {
      as(253L, 1L);
      AppMethodBeat.o(331220);
      return;
    }
    if (l1 <= 15L)
    {
      as(254L, 1L);
      AppMethodBeat.o(331220);
      return;
    }
    if (l1 <= 20L) {
      as(255L, 1L);
    }
    AppMethodBeat.o(331220);
  }
  
  public static void pQ(long paramLong)
  {
    AppMethodBeat.i(331154);
    as(218L, paramLong);
    if (paramLong < 5000L)
    {
      as(220L, 1L);
      AppMethodBeat.o(331154);
      return;
    }
    if (paramLong < 10000L)
    {
      as(221L, 1L);
      AppMethodBeat.o(331154);
      return;
    }
    if (paramLong < 15000L)
    {
      as(222L, 1L);
      AppMethodBeat.o(331154);
      return;
    }
    if (paramLong < 20000L)
    {
      as(223L, 1L);
      AppMethodBeat.o(331154);
      return;
    }
    if (paramLong < 30000L)
    {
      as(224L, 1L);
      AppMethodBeat.o(331154);
      return;
    }
    if (paramLong < 40000L)
    {
      as(225L, 1L);
      AppMethodBeat.o(331154);
      return;
    }
    if (paramLong < 50000L)
    {
      as(226L, 1L);
      AppMethodBeat.o(331154);
      return;
    }
    as(227L, 1L);
    AppMethodBeat.o(331154);
  }
  
  public static void tW(boolean paramBoolean)
  {
    AppMethodBeat.i(331130);
    if (paramBoolean)
    {
      as(202L, 1L);
      AppMethodBeat.o(331130);
      return;
    }
    as(201L, 1L);
    AppMethodBeat.o(331130);
  }
  
  public static void tX(boolean paramBoolean)
  {
    AppMethodBeat.i(331142);
    if (paramBoolean)
    {
      as(214L, 1L);
      AppMethodBeat.o(331142);
      return;
    }
    as(213L, 1L);
    AppMethodBeat.o(331142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.aq
 * JD-Core Version:    0.7.0.1
 */