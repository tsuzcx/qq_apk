package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public final class l
{
  public static void ar(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89438);
    int i;
    try
    {
      if (k.vOq == null) {
        break label207;
      }
      i = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString)).optInt("videoBitrate");
      if (paramInt2 == 1)
      {
        if (paramInt1 == 1)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 189L, i, false);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 190L, 1L, false);
          AppMethodBeat.o(89438);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 184L, i, false);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 185L, 1L, false);
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
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 194L, i, false);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 195L, 1L, false);
        AppMethodBeat.o(89438);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 199L, i, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 200L, 1L, false);
    }
    label207:
    AppMethodBeat.o(89438);
  }
  
  public static void auH()
  {
    AppMethodBeat.i(89435);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 16L, 1L, false);
    AppMethodBeat.o(89435);
  }
  
  public static void auI()
  {
    AppMethodBeat.i(89436);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 21L, 1L, false);
    AppMethodBeat.o(89436);
  }
  
  public static void auz()
  {
    AppMethodBeat.i(89432);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 2L, 1L, false);
    AppMethodBeat.o(89432);
  }
  
  public static void awB()
  {
    AppMethodBeat.i(89440);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 140L, 0L, false);
    AppMethodBeat.o(89440);
  }
  
  public static void dmW()
  {
    AppMethodBeat.i(89431);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    int j;
    if (k.vOq != null)
    {
      if (k.vOq.gbj == 1) {
        i = 39;
      }
      if (k.vOq.hpj != 720) {
        break label81;
      }
      j = i + 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, j, 1L, false);
      AppMethodBeat.o(89431);
      return;
      label81:
      j = i;
      if (k.vOq.dne()) {
        j = i + 2;
      }
    }
  }
  
  public static void dmX()
  {
    AppMethodBeat.i(89433);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 7L, 1L, false);
    AppMethodBeat.o(89433);
  }
  
  public static void dmY()
  {
    AppMethodBeat.i(89434);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 8L, 1L, false);
    AppMethodBeat.o(89434);
  }
  
  public static void dmZ()
  {
    AppMethodBeat.i(89437);
    ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 31L, 1L, false);
    AppMethodBeat.o(89437);
  }
  
  public static void g(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(89439);
    ad.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    b.dmG().vNw = paramLong;
    b localb = b.dmG();
    com.tencent.mm.modelsns.g localg1 = new com.tencent.mm.modelsns.g();
    com.tencent.mm.modelsns.g localg2 = new com.tencent.mm.modelsns.g();
    localg1.l("model", localb.model + ",");
    localg1.l("apiLevel", localb.vMY + ",");
    localg1.l("memoryClass", localb.iuX + ",");
    localg1.l("totalMemory", localb.htG + ",");
    localg1.l("maxCpu", localb.vMZ + ",");
    localg1.l("screenW", localb.vNa + ",");
    localg1.l("screenH", localb.vNb + ",");
    localg2.l("model", localb.model + ",");
    localg2.l("apiLevel", localb.vMY + ",");
    localg2.l("memoryClass", localb.iuX + ",");
    localg2.l("totalMemory", localb.htG + ",");
    localg2.l("maxCpu", localb.vMZ + ",");
    localg2.l("screenW", localb.vNa + ",");
    localg2.l("screenH", localb.vNb + ",");
    localg1.l("cropx", localb.vNg + ",");
    localg1.l("cropy", localb.vNh + ",");
    localg1.l("previewx", localb.vNi + ",");
    localg1.l("previewy", localb.vNj + ",");
    localg1.l("encoderx", localb.vNk + ",");
    localg1.l("encodery", localb.vNl + ",");
    localg1.l("rotate", localb.dGc + ",");
    localg1.l("deviceoutfps", localb.vNm + ",");
    localg1.l("recordfps", localb.vNn + ",");
    localg1.l("recordertype", localb.vNo + ",");
    localg1.l("videoBitrate", localb.videoBitrate + ",");
    localg1.l("needRotateEachFrame", localb.gbk + ",");
    localg1.l("isNeedRealtimeScale", localb.vNp + ",");
    localg1.l("resolutionLimit", localb.hpj + ",");
    localg1.l("outfps", localb.vNq + ",");
    localg1.l("recordTime", localb.vNr + ",");
    localg1.l("avgcpu", localb.vNs + ",");
    localg1.l("outx", localb.vNt + ",");
    localg1.l("outy", localb.vNu + ",");
    localg1.l("outbitrate", localb.vNv + ",");
    localg1.l("fileSize", localb.fileSize + ",");
    localg1.l("wait2playtime", localb.vNw + ",");
    localg1.l("useback", localb.vNx + ",");
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
      localg1.l("mIsCharging", i + ",");
      localg1.l("level", k + ",");
      localg1.l("scale", j + ",");
      localg1.l("createTime", System.currentTimeMillis() + ",");
      localg2.l("prewViewlist1", localb.vNc + ",");
      localg2.l("pictureSize1", localb.vNd + ",");
      localg2.l("prewViewlist2", localb.vNe + ",");
      localg2.l("pictureSize2", localb.vNf + ",");
      ad.i("MicroMsg.CaptureStatistics", "report " + localg1.RE());
      ad.v("MicroMsg.CaptureStatistics", "report " + localg2.RE());
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(13947, localg1.toString());
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(13949, localg2.toString());
      if (!paramBoolean) {
        break label1738;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 119L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 120L, paramLong, false);
      if (k.vOq.hpj != 720) {
        break label1689;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 122L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
      i = 0;
      break;
      i = 0;
    }
    label1689:
    if (k.vOq.dne())
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 123L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 121L, paramLong, false);
    AppMethodBeat.o(89439);
    return;
    label1738:
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 124L, 1L, false);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 125L, paramLong, false);
    if (k.vOq.gbj == 1)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 127L, paramLong, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 131L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 126L, paramLong, false);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 130L, paramLong, false);
    AppMethodBeat.o(89439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.l
 * JD-Core Version:    0.7.0.1
 */