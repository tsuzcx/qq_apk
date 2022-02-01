package com.tencent.mm.plugin.finder.report;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/IDKey1371;", "", "()V", "CAPTURE_PHOTO", "", "CAPTURE_PHOTO_BACK", "CAPTURE_PHOTO_FRONT", "CAPTURE_PHOTO_WITH_BEAUTY", "ID", "SINGLE_VIDEO_BACK", "SINGLE_VIDEO_BEAUTY", "SINGLE_VIDEO_FRONT", "SINGLE_VIDEO_LENGTH_0_5", "SINGLE_VIDEO_LENGTH_10_15", "SINGLE_VIDEO_LENGTH_15_20", "SINGLE_VIDEO_LENGTH_20_30", "SINGLE_VIDEO_LENGTH_30_40", "SINGLE_VIDEO_LENGTH_40_50", "SINGLE_VIDEO_LENGTH_50_60", "SINGLE_VIDEO_LENGTH_5_10", "SINGLE_VIDEO_LENGTH_TOTAL", "SINGLE_VIDEO_NOT_ENOUGH", "SINGLE_VIDEO_SUCCESS", "SINGLE_VIDEO_TIME", "SUBVIDEO_AUTO_FINISH", "SUBVIDEO_CLICK_FINISH", "SUBVIDEO_NUM_0_3", "SUBVIDEO_NUM_10_15", "SUBVIDEO_NUM_15_20", "SUBVIDEO_NUM_3_6", "SUBVIDEO_NUM_6_10", "SUBVIDEO_PREPARE_DELETE", "SUBVIDEO_PRERARE_EXIT", "SUBVIDEO_SINGLE_LENGTH_0_5", "SUBVIDEO_SINGLE_LENGTH_10_15", "SUBVIDEO_SINGLE_LENGTH_15_20", "SUBVIDEO_SINGLE_LENGTH_20_30", "SUBVIDEO_SINGLE_LENGTH_30_40", "SUBVIDEO_SINGLE_LENGTH_40_50", "SUBVIDEO_SINGLE_LENGTH_50_60", "SUBVIDEO_SINGLE_LENGTH_5_10", "SUBVIDEO_SURE_DELETE", "SUBVIDEO_SURE_EXIT", "SUBVIDEO_TIME", "SUBVIDEO_TIME_NOT_ENOUGH", "SUBVIDEO_TIME_SUCCESS", "SUBVIDEO_TIME_TOTAL_DURATION", "SUBVIDEO_TOTAL_LENGTH_0_5", "SUBVIDEO_TOTAL_LENGTH_10_15", "SUBVIDEO_TOTAL_LENGTH_15_20", "SUBVIDEO_TOTAL_LENGTH_20_30", "SUBVIDEO_TOTAL_LENGTH_30_40", "SUBVIDEO_TOTAL_LENGTH_40_50", "SUBVIDEO_TOTAL_LENGTH_50_60", "SUBVIDEO_TOTAL_LENGTH_5_10", "SUBVIDEO_TOTAL_NUM", "capturePhoto", "", "capturePhotoBack", "capturePhotoCamera", "isBack", "", "capturePhotoFront", "capturePhotoWithBeauty", "captureSingleVideo", "captureSingleVideoBack", "captureSingleVideoBeauty", "captureSingleVideoCamera", "captureSingleVideoDuration", "durationMs", "captureSingleVideoFront", "captureSingleVideoNotEnough", "captureSingleVideoSuccess", "captureSingleVideoTotal", "report", "key", "value", "subVideoAutoFinish", "subVideoClickFinish", "subVideoDuration", "fileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "subVideoNotEnough", "subVideoNum", "num", "subVideoPrepareDelete", "subVideoPrepareExit", "subVideoSingleTime", "subVideoSuccess", "subVideoSureDelete", "subVideoSureExit", "subVideoTime", "subVideoTotalTime", "plugin-finder_release"})
public final class o
{
  public static final o rAq;
  
  static
  {
    AppMethodBeat.i(202834);
    rAq = new o();
    AppMethodBeat.o(202834);
  }
  
  public static void M(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(202832);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1371L, paramLong1, paramLong2, false);
    AppMethodBeat.o(202832);
  }
  
  public static void W(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(202831);
    k.h(paramArrayList, "fileList");
    com.tencent.e.h.JZN.aS((Runnable)new o.a(paramArrayList));
    AppMethodBeat.o(202831);
  }
  
  public static void lD(boolean paramBoolean)
  {
    AppMethodBeat.i(202828);
    if (paramBoolean)
    {
      M(202L, 1L);
      AppMethodBeat.o(202828);
      return;
    }
    M(201L, 1L);
    AppMethodBeat.o(202828);
  }
  
  public static void lE(boolean paramBoolean)
  {
    AppMethodBeat.i(202829);
    if (paramBoolean)
    {
      M(214L, 1L);
      AppMethodBeat.o(202829);
      return;
    }
    M(213L, 1L);
    AppMethodBeat.o(202829);
  }
  
  public static void uF(long paramLong)
  {
    AppMethodBeat.i(202830);
    M(218L, paramLong);
    if (paramLong < 5000L)
    {
      M(220L, 1L);
      AppMethodBeat.o(202830);
      return;
    }
    if (paramLong < 10000L)
    {
      M(221L, 1L);
      AppMethodBeat.o(202830);
      return;
    }
    if (paramLong < 15000L)
    {
      M(222L, 1L);
      AppMethodBeat.o(202830);
      return;
    }
    if (paramLong < 20000L)
    {
      M(223L, 1L);
      AppMethodBeat.o(202830);
      return;
    }
    if (paramLong < 30000L)
    {
      M(224L, 1L);
      AppMethodBeat.o(202830);
      return;
    }
    if (paramLong < 40000L)
    {
      M(225L, 1L);
      AppMethodBeat.o(202830);
      return;
    }
    if (paramLong < 50000L)
    {
      M(226L, 1L);
      AppMethodBeat.o(202830);
      return;
    }
    M(227L, 1L);
    AppMethodBeat.o(202830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.o
 * JD-Core Version:    0.7.0.1
 */