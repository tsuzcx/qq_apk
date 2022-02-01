package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class k
{
  public static void aWf()
  {
    AppMethodBeat.i(89432);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
    h.IzE.idkeyStat(440L, 2L, 1L, false);
    AppMethodBeat.o(89432);
  }
  
  public static void aWn()
  {
    AppMethodBeat.i(89435);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
    h.IzE.idkeyStat(440L, 16L, 1L, false);
    AppMethodBeat.o(89435);
  }
  
  public static void aWo()
  {
    AppMethodBeat.i(89436);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
    h.IzE.idkeyStat(440L, 21L, 1L, false);
    AppMethodBeat.o(89436);
  }
  
  public static void aw(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89438);
    int i;
    try
    {
      if (j.EZX == null) {
        break label207;
      }
      i = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString)).optInt("videoBitrate");
      if (paramInt2 == 1)
      {
        if (paramInt1 == 1)
        {
          h.IzE.idkeyStat(440L, 189L, i, false);
          h.IzE.idkeyStat(440L, 190L, 1L, false);
          AppMethodBeat.o(89438);
          return;
        }
        h.IzE.idkeyStat(440L, 184L, i, false);
        h.IzE.idkeyStat(440L, 185L, 1L, false);
        AppMethodBeat.o(89438);
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(89438);
      return;
    }
    if (paramInt2 == 2)
    {
      if (paramInt1 == 1)
      {
        h.IzE.idkeyStat(440L, 194L, i, false);
        h.IzE.idkeyStat(440L, 195L, 1L, false);
        AppMethodBeat.o(89438);
        return;
      }
      h.IzE.idkeyStat(440L, 199L, i, false);
      h.IzE.idkeyStat(440L, 200L, 1L, false);
    }
    label207:
    AppMethodBeat.o(89438);
  }
  
  public static void eTq()
  {
    AppMethodBeat.i(89431);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
    h.IzE.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    int j;
    if (j.EZX != null)
    {
      if (j.EZX.jth == 1) {
        i = 39;
      }
      if (j.EZX.laT != 720) {
        break label81;
      }
      j = i + 1;
    }
    for (;;)
    {
      h.IzE.idkeyStat(440L, j, 1L, false);
      AppMethodBeat.o(89431);
      return;
      label81:
      j = i;
      if (j.EZX.eTz()) {
        j = i + 2;
      }
    }
  }
  
  public static void eTr()
  {
    AppMethodBeat.i(89433);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
    h.IzE.idkeyStat(440L, 7L, 1L, false);
    AppMethodBeat.o(89433);
  }
  
  public static void eTs()
  {
    AppMethodBeat.i(89434);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
    h.IzE.idkeyStat(440L, 8L, 1L, false);
    AppMethodBeat.o(89434);
  }
  
  public static void eTt()
  {
    AppMethodBeat.i(89437);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
    h.IzE.idkeyStat(440L, 31L, 1L, false);
    AppMethodBeat.o(89437);
  }
  
  public static void eTu()
  {
    AppMethodBeat.i(89440);
    h.IzE.idkeyStat(440L, 140L, 0L, false);
    AppMethodBeat.o(89440);
  }
  
  public static void j(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(89439);
    Log.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    b.eTa().EZc = paramLong;
    b localb = b.eTa();
    n localn1 = new n();
    n localn2 = new n();
    localn1.l("model", localb.model + ",");
    localn1.l("apiLevel", localb.EYE + ",");
    localn1.l("memoryClass", localb.miK + ",");
    localn1.l("totalMemory", localb.lfc + ",");
    localn1.l("maxCpu", localb.EYF + ",");
    localn1.l("screenW", localb.EYG + ",");
    localn1.l("screenH", localb.EYH + ",");
    localn2.l("model", localb.model + ",");
    localn2.l("apiLevel", localb.EYE + ",");
    localn2.l("memoryClass", localb.miK + ",");
    localn2.l("totalMemory", localb.lfc + ",");
    localn2.l("maxCpu", localb.EYF + ",");
    localn2.l("screenW", localb.EYG + ",");
    localn2.l("screenH", localb.EYH + ",");
    localn1.l("cropx", localb.EYM + ",");
    localn1.l("cropy", localb.EYN + ",");
    localn1.l("previewx", localb.EYO + ",");
    localn1.l("previewy", localb.EYP + ",");
    localn1.l("encoderx", localb.EYQ + ",");
    localn1.l("encodery", localb.EYR + ",");
    localn1.l("rotate", localb.fSM + ",");
    localn1.l("deviceoutfps", localb.EYS + ",");
    localn1.l("recordfps", localb.EYT + ",");
    localn1.l("recordertype", localb.EYU + ",");
    localn1.l("videoBitrate", localb.videoBitrate + ",");
    localn1.l("needRotateEachFrame", localb.jti + ",");
    localn1.l("isNeedRealtimeScale", localb.EYV + ",");
    localn1.l("resolutionLimit", localb.laT + ",");
    localn1.l("outfps", localb.EYW + ",");
    localn1.l("recordTime", localb.EYX + ",");
    localn1.l("avgcpu", localb.EYY + ",");
    localn1.l("outx", localb.EYZ + ",");
    localn1.l("outy", localb.EZa + ",");
    localn1.l("outbitrate", localb.EZb + ",");
    localn1.l("fileSize", localb.fileSize + ",");
    localn1.l("wait2playtime", localb.EZc + ",");
    localn1.l("useback", localb.EZd + ",");
    int k = 0;
    int j = 0;
    Intent localIntent = MMApplicationContext.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
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
      Log.i("MicroMsg.CaptureStatistics", "battery %s %s %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      localn1.l("mIsCharging", i + ",");
      localn1.l("level", k + ",");
      localn1.l("scale", j + ",");
      localn1.l("createTime", System.currentTimeMillis() + ",");
      localn2.l("prewViewlist1", localb.EYI + ",");
      localn2.l("pictureSize1", localb.EYJ + ",");
      localn2.l("prewViewlist2", localb.EYK + ",");
      localn2.l("pictureSize2", localb.EYL + ",");
      Log.i("MicroMsg.CaptureStatistics", "report " + localn1.agI());
      Log.v("MicroMsg.CaptureStatistics", "report " + localn2.agI());
      h.IzE.kvStat(13947, localn1.toString());
      h.IzE.kvStat(13949, localn2.toString());
      if (!paramBoolean) {
        break label1738;
      }
      h.IzE.idkeyStat(440L, 119L, 1L, false);
      h.IzE.idkeyStat(440L, 120L, paramLong, false);
      if (j.EZX.laT != 720) {
        break label1689;
      }
      h.IzE.idkeyStat(440L, 122L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
      i = 0;
      break;
      i = 0;
    }
    label1689:
    if (j.EZX.eTz())
    {
      h.IzE.idkeyStat(440L, 123L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    h.IzE.idkeyStat(440L, 121L, paramLong, false);
    AppMethodBeat.o(89439);
    return;
    label1738:
    h.IzE.idkeyStat(440L, 124L, 1L, false);
    h.IzE.idkeyStat(440L, 125L, paramLong, false);
    if (j.EZX.jth == 1)
    {
      h.IzE.idkeyStat(440L, 127L, paramLong, false);
      h.IzE.idkeyStat(440L, 131L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    h.IzE.idkeyStat(440L, 126L, paramLong, false);
    h.IzE.idkeyStat(440L, 130L, paramLong, false);
    AppMethodBeat.o(89439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.k
 * JD-Core Version:    0.7.0.1
 */