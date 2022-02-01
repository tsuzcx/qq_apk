package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public final class l
{
  public static void ar(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89438);
    int i;
    try
    {
      if (k.wat == null) {
        break label207;
      }
      i = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString)).optInt("videoBitrate");
      if (paramInt2 == 1)
      {
        if (paramInt1 == 1)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 189L, i, false);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 190L, 1L, false);
          AppMethodBeat.o(89438);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 184L, i, false);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 185L, 1L, false);
        AppMethodBeat.o(89438);
        return;
      }
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(89438);
      return;
    }
    if (paramInt2 == 2)
    {
      if (paramInt1 == 1)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 194L, i, false);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 195L, 1L, false);
        AppMethodBeat.o(89438);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 199L, i, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 200L, 1L, false);
    }
    label207:
    AppMethodBeat.o(89438);
  }
  
  public static void auO()
  {
    AppMethodBeat.i(89432);
    ae.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 2L, 1L, false);
    AppMethodBeat.o(89432);
  }
  
  public static void auW()
  {
    AppMethodBeat.i(89435);
    ae.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 16L, 1L, false);
    AppMethodBeat.o(89435);
  }
  
  public static void auX()
  {
    AppMethodBeat.i(89436);
    ae.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 21L, 1L, false);
    AppMethodBeat.o(89436);
  }
  
  public static void awQ()
  {
    AppMethodBeat.i(89440);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 140L, 0L, false);
    AppMethodBeat.o(89440);
  }
  
  public static void dpU()
  {
    AppMethodBeat.i(89431);
    ae.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    int j;
    if (k.wat != null)
    {
      if (k.wat.gdr == 1) {
        i = 39;
      }
      if (k.wat.hrX != 720) {
        break label81;
      }
      j = i + 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, j, 1L, false);
      AppMethodBeat.o(89431);
      return;
      label81:
      j = i;
      if (k.wat.dqc()) {
        j = i + 2;
      }
    }
  }
  
  public static void dpV()
  {
    AppMethodBeat.i(89433);
    ae.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 7L, 1L, false);
    AppMethodBeat.o(89433);
  }
  
  public static void dpW()
  {
    AppMethodBeat.i(89434);
    ae.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 8L, 1L, false);
    AppMethodBeat.o(89434);
  }
  
  public static void dpX()
  {
    AppMethodBeat.i(89437);
    ae.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 31L, 1L, false);
    AppMethodBeat.o(89437);
  }
  
  public static void g(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(89439);
    ae.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    b.dpE().vZz = paramLong;
    b localb = b.dpE();
    com.tencent.mm.modelsns.g localg1 = new com.tencent.mm.modelsns.g();
    com.tencent.mm.modelsns.g localg2 = new com.tencent.mm.modelsns.g();
    localg1.l("model", localb.model + ",");
    localg1.l("apiLevel", localb.vZb + ",");
    localg1.l("memoryClass", localb.ixR + ",");
    localg1.l("totalMemory", localb.hwu + ",");
    localg1.l("maxCpu", localb.vZc + ",");
    localg1.l("screenW", localb.vZd + ",");
    localg1.l("screenH", localb.vZe + ",");
    localg2.l("model", localb.model + ",");
    localg2.l("apiLevel", localb.vZb + ",");
    localg2.l("memoryClass", localb.ixR + ",");
    localg2.l("totalMemory", localb.hwu + ",");
    localg2.l("maxCpu", localb.vZc + ",");
    localg2.l("screenW", localb.vZd + ",");
    localg2.l("screenH", localb.vZe + ",");
    localg1.l("cropx", localb.vZj + ",");
    localg1.l("cropy", localb.vZk + ",");
    localg1.l("previewx", localb.vZl + ",");
    localg1.l("previewy", localb.vZm + ",");
    localg1.l("encoderx", localb.vZn + ",");
    localg1.l("encodery", localb.vZo + ",");
    localg1.l("rotate", localb.dHi + ",");
    localg1.l("deviceoutfps", localb.vZp + ",");
    localg1.l("recordfps", localb.vZq + ",");
    localg1.l("recordertype", localb.vZr + ",");
    localg1.l("videoBitrate", localb.videoBitrate + ",");
    localg1.l("needRotateEachFrame", localb.gds + ",");
    localg1.l("isNeedRealtimeScale", localb.vZs + ",");
    localg1.l("resolutionLimit", localb.hrX + ",");
    localg1.l("outfps", localb.vZt + ",");
    localg1.l("recordTime", localb.vZu + ",");
    localg1.l("avgcpu", localb.vZv + ",");
    localg1.l("outx", localb.vZw + ",");
    localg1.l("outy", localb.vZx + ",");
    localg1.l("outbitrate", localb.vZy + ",");
    localg1.l("fileSize", localb.fileSize + ",");
    localg1.l("wait2playtime", localb.vZz + ",");
    localg1.l("useback", localb.vZA + ",");
    int k = 0;
    int j = 0;
    Intent localIntent = ak.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
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
      ae.i("MicroMsg.CaptureStatistics", "battery %s %s %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      localg1.l("mIsCharging", i + ",");
      localg1.l("level", k + ",");
      localg1.l("scale", j + ",");
      localg1.l("createTime", System.currentTimeMillis() + ",");
      localg2.l("prewViewlist1", localb.vZf + ",");
      localg2.l("pictureSize1", localb.vZg + ",");
      localg2.l("prewViewlist2", localb.vZh + ",");
      localg2.l("pictureSize2", localb.vZi + ",");
      ae.i("MicroMsg.CaptureStatistics", "report " + localg1.RD());
      ae.v("MicroMsg.CaptureStatistics", "report " + localg2.RD());
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(13947, localg1.toString());
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(13949, localg2.toString());
      if (!paramBoolean) {
        break label1738;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 119L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 120L, paramLong, false);
      if (k.wat.hrX != 720) {
        break label1689;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 122L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
      i = 0;
      break;
      i = 0;
    }
    label1689:
    if (k.wat.dqc())
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 123L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 121L, paramLong, false);
    AppMethodBeat.o(89439);
    return;
    label1738:
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 124L, 1L, false);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 125L, paramLong, false);
    if (k.wat.gdr == 1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 127L, paramLong, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 131L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 126L, paramLong, false);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 130L, paramLong, false);
    AppMethodBeat.o(89439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.l
 * JD-Core Version:    0.7.0.1
 */