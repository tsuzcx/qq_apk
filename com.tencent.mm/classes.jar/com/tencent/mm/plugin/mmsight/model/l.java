package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public final class l
{
  public static void akS()
  {
    AppMethodBeat.i(89432);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
    h.vKh.idkeyStat(440L, 2L, 1L, false);
    AppMethodBeat.o(89432);
  }
  
  public static void ala()
  {
    AppMethodBeat.i(89435);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
    h.vKh.idkeyStat(440L, 16L, 1L, false);
    AppMethodBeat.o(89435);
  }
  
  public static void alb()
  {
    AppMethodBeat.i(89436);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
    h.vKh.idkeyStat(440L, 21L, 1L, false);
    AppMethodBeat.o(89436);
  }
  
  public static void amV()
  {
    AppMethodBeat.i(89440);
    h.vKh.idkeyStat(440L, 140L, 0L, false);
    AppMethodBeat.o(89440);
  }
  
  public static void ao(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89438);
    int i;
    try
    {
      if (k.tCN == null) {
        break label207;
      }
      i = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString)).optInt("videoBitrate");
      if (paramInt2 == 1)
      {
        if (paramInt1 == 1)
        {
          h.vKh.idkeyStat(440L, 189L, i, false);
          h.vKh.idkeyStat(440L, 190L, 1L, false);
          AppMethodBeat.o(89438);
          return;
        }
        h.vKh.idkeyStat(440L, 184L, i, false);
        h.vKh.idkeyStat(440L, 185L, 1L, false);
        AppMethodBeat.o(89438);
        return;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(89438);
      return;
    }
    if (paramInt2 == 2)
    {
      if (paramInt1 == 1)
      {
        h.vKh.idkeyStat(440L, 194L, i, false);
        h.vKh.idkeyStat(440L, 195L, 1L, false);
        AppMethodBeat.o(89438);
        return;
      }
      h.vKh.idkeyStat(440L, 199L, i, false);
      h.vKh.idkeyStat(440L, 200L, 1L, false);
    }
    label207:
    AppMethodBeat.o(89438);
  }
  
  public static void cPS()
  {
    AppMethodBeat.i(89431);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
    h.vKh.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    int j;
    if (k.tCN != null)
    {
      if (k.tCN.fEc == 1) {
        i = 39;
      }
      if (k.tCN.gwG != 720) {
        break label81;
      }
      j = i + 1;
    }
    for (;;)
    {
      h.vKh.idkeyStat(440L, j, 1L, false);
      AppMethodBeat.o(89431);
      return;
      label81:
      j = i;
      if (k.tCN.cQa()) {
        j = i + 2;
      }
    }
  }
  
  public static void cPT()
  {
    AppMethodBeat.i(89433);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
    h.vKh.idkeyStat(440L, 7L, 1L, false);
    AppMethodBeat.o(89433);
  }
  
  public static void cPU()
  {
    AppMethodBeat.i(89434);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
    h.vKh.idkeyStat(440L, 8L, 1L, false);
    AppMethodBeat.o(89434);
  }
  
  public static void cPV()
  {
    AppMethodBeat.i(89437);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
    h.vKh.idkeyStat(440L, 31L, 1L, false);
    AppMethodBeat.o(89437);
  }
  
  public static void g(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(89439);
    ad.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    b.cPB().tBT = paramLong;
    b localb = b.cPB();
    f localf1 = new f();
    f localf2 = new f();
    localf1.n("model", localb.model + ",");
    localf1.n("apiLevel", localb.tBv + ",");
    localf1.n("memoryClass", localb.hBa + ",");
    localf1.n("totalMemory", localb.gBc + ",");
    localf1.n("maxCpu", localb.tBw + ",");
    localf1.n("screenW", localb.tBx + ",");
    localf1.n("screenH", localb.tBy + ",");
    localf2.n("model", localb.model + ",");
    localf2.n("apiLevel", localb.tBv + ",");
    localf2.n("memoryClass", localb.hBa + ",");
    localf2.n("totalMemory", localb.gBc + ",");
    localf2.n("maxCpu", localb.tBw + ",");
    localf2.n("screenW", localb.tBx + ",");
    localf2.n("screenH", localb.tBy + ",");
    localf1.n("cropx", localb.tBD + ",");
    localf1.n("cropy", localb.tBE + ",");
    localf1.n("previewx", localb.tBF + ",");
    localf1.n("previewy", localb.tBG + ",");
    localf1.n("encoderx", localb.tBH + ",");
    localf1.n("encodery", localb.tBI + ",");
    localf1.n("rotate", localb.dwp + ",");
    localf1.n("deviceoutfps", localb.tBJ + ",");
    localf1.n("recordfps", localb.tBK + ",");
    localf1.n("recordertype", localb.tBL + ",");
    localf1.n("videoBitrate", localb.videoBitrate + ",");
    localf1.n("needRotateEachFrame", localb.fEd + ",");
    localf1.n("isNeedRealtimeScale", localb.tBM + ",");
    localf1.n("resolutionLimit", localb.gwG + ",");
    localf1.n("outfps", localb.tBN + ",");
    localf1.n("recordTime", localb.tBO + ",");
    localf1.n("avgcpu", localb.tBP + ",");
    localf1.n("outx", localb.tBQ + ",");
    localf1.n("outy", localb.tBR + ",");
    localf1.n("outbitrate", localb.tBS + ",");
    localf1.n("fileSize", localb.fileSize + ",");
    localf1.n("wait2playtime", localb.tBT + ",");
    localf1.n("useback", localb.tBU + ",");
    int k = 0;
    int j = 0;
    Intent localIntent = aj.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    int i;
    if (localIntent != null)
    {
      i = localIntent.getIntExtra("status", -1);
      if ((i == 2) || (i == 5))
      {
        i = 1;
        k = localIntent.getIntExtra("level", -1);
        j = localIntent.getIntExtra("scale", -1);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.CaptureStatistics", "battery %s %s %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      localf1.n("mIsCharging", i + ",");
      localf1.n("level", k + ",");
      localf1.n("scale", j + ",");
      localf1.n("createTime", System.currentTimeMillis() + ",");
      localf2.n("prewViewlist1", localb.tBz + ",");
      localf2.n("pictureSize1", localb.tBA + ",");
      localf2.n("prewViewlist2", localb.tBB + ",");
      localf2.n("pictureSize2", localb.tBC + ",");
      ad.i("MicroMsg.CaptureStatistics", "report " + localf1.PW());
      ad.v("MicroMsg.CaptureStatistics", "report " + localf2.PW());
      h.vKh.kvStat(13947, localf1.toString());
      h.vKh.kvStat(13949, localf2.toString());
      if (!paramBoolean) {
        break label1738;
      }
      h.vKh.idkeyStat(440L, 119L, 1L, false);
      h.vKh.idkeyStat(440L, 120L, paramLong, false);
      if (k.tCN.gwG != 720) {
        break label1689;
      }
      h.vKh.idkeyStat(440L, 122L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
      i = 0;
      break;
      i = 0;
    }
    label1689:
    if (k.tCN.cQa())
    {
      h.vKh.idkeyStat(440L, 123L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    h.vKh.idkeyStat(440L, 121L, paramLong, false);
    AppMethodBeat.o(89439);
    return;
    label1738:
    h.vKh.idkeyStat(440L, 124L, 1L, false);
    h.vKh.idkeyStat(440L, 125L, paramLong, false);
    if (k.tCN.fEc == 1)
    {
      h.vKh.idkeyStat(440L, 127L, paramLong, false);
      h.vKh.idkeyStat(440L, 131L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    h.vKh.idkeyStat(440L, 126L, paramLong, false);
    h.vKh.idkeyStat(440L, 130L, paramLong, false);
    AppMethodBeat.o(89439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.l
 * JD-Core Version:    0.7.0.1
 */