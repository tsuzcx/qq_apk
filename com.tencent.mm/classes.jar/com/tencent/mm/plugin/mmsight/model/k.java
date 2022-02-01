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
  public static void aD(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89438);
    int i;
    try
    {
      if (j.KVJ == null) {
        break label207;
      }
      i = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString)).optInt("videoBitrate");
      if (paramInt2 == 1)
      {
        if (paramInt1 == 1)
        {
          h.OAn.idkeyStat(440L, 189L, i, false);
          h.OAn.idkeyStat(440L, 190L, 1L, false);
          AppMethodBeat.o(89438);
          return;
        }
        h.OAn.idkeyStat(440L, 184L, i, false);
        h.OAn.idkeyStat(440L, 185L, 1L, false);
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
        h.OAn.idkeyStat(440L, 194L, i, false);
        h.OAn.idkeyStat(440L, 195L, 1L, false);
        AppMethodBeat.o(89438);
        return;
      }
      h.OAn.idkeyStat(440L, 199L, i, false);
      h.OAn.idkeyStat(440L, 200L, 1L, false);
    }
    label207:
    AppMethodBeat.o(89438);
  }
  
  public static void bqN()
  {
    AppMethodBeat.i(89432);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
    h.OAn.idkeyStat(440L, 2L, 1L, false);
    AppMethodBeat.o(89432);
  }
  
  public static void bqV()
  {
    AppMethodBeat.i(89435);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
    h.OAn.idkeyStat(440L, 16L, 1L, false);
    AppMethodBeat.o(89435);
  }
  
  public static void bqW()
  {
    AppMethodBeat.i(89436);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
    h.OAn.idkeyStat(440L, 21L, 1L, false);
    AppMethodBeat.o(89436);
  }
  
  public static void gcj()
  {
    AppMethodBeat.i(89431);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
    h.OAn.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    int j;
    if (j.KVJ != null)
    {
      if (j.KVJ.lWy == 1) {
        i = 39;
      }
      if (j.KVJ.nFY != 720) {
        break label81;
      }
      j = i + 1;
    }
    for (;;)
    {
      h.OAn.idkeyStat(440L, j, 1L, false);
      AppMethodBeat.o(89431);
      return;
      label81:
      j = i;
      if (j.KVJ.gcs()) {
        j = i + 2;
      }
    }
  }
  
  public static void gck()
  {
    AppMethodBeat.i(89433);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
    h.OAn.idkeyStat(440L, 7L, 1L, false);
    AppMethodBeat.o(89433);
  }
  
  public static void gcl()
  {
    AppMethodBeat.i(89434);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
    h.OAn.idkeyStat(440L, 8L, 1L, false);
    AppMethodBeat.o(89434);
  }
  
  public static void gcm()
  {
    AppMethodBeat.i(89437);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
    h.OAn.idkeyStat(440L, 31L, 1L, false);
    AppMethodBeat.o(89437);
  }
  
  public static void gcn()
  {
    AppMethodBeat.i(89440);
    h.OAn.idkeyStat(440L, 140L, 0L, false);
    AppMethodBeat.o(89440);
  }
  
  public static void m(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(89439);
    Log.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    b.gbT().KUO = paramLong;
    b localb = b.gbT();
    n localn1 = new n();
    n localn2 = new n();
    localn1.r("model", localb.model + ",");
    localn1.r("apiLevel", localb.KUq + ",");
    localn1.r("memoryClass", localb.pch + ",");
    localn1.r("totalMemory", localb.nJN + ",");
    localn1.r("maxCpu", localb.KUr + ",");
    localn1.r("screenW", localb.KUs + ",");
    localn1.r("screenH", localb.KUt + ",");
    localn2.r("model", localb.model + ",");
    localn2.r("apiLevel", localb.KUq + ",");
    localn2.r("memoryClass", localb.pch + ",");
    localn2.r("totalMemory", localb.nJN + ",");
    localn2.r("maxCpu", localb.KUr + ",");
    localn2.r("screenW", localb.KUs + ",");
    localn2.r("screenH", localb.KUt + ",");
    localn1.r("cropx", localb.KUy + ",");
    localn1.r("cropy", localb.KUz + ",");
    localn1.r("previewx", localb.KUA + ",");
    localn1.r("previewy", localb.KUB + ",");
    localn1.r("encoderx", localb.KUC + ",");
    localn1.r("encodery", localb.KUD + ",");
    localn1.r("rotate", localb.hYK + ",");
    localn1.r("deviceoutfps", localb.KUE + ",");
    localn1.r("recordfps", localb.KUF + ",");
    localn1.r("recordertype", localb.KUG + ",");
    localn1.r("videoBitrate", localb.videoBitrate + ",");
    localn1.r("needRotateEachFrame", localb.lWz + ",");
    localn1.r("isNeedRealtimeScale", localb.KUH + ",");
    localn1.r("resolutionLimit", localb.nFY + ",");
    localn1.r("outfps", localb.KUI + ",");
    localn1.r("recordTime", localb.KUJ + ",");
    localn1.r("avgcpu", localb.KUK + ",");
    localn1.r("outx", localb.KUL + ",");
    localn1.r("outy", localb.KUM + ",");
    localn1.r("outbitrate", localb.KUN + ",");
    localn1.r("fileSize", localb.fileSize + ",");
    localn1.r("wait2playtime", localb.KUO + ",");
    localn1.r("useback", localb.KUP + ",");
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
      localn1.r("mIsCharging", i + ",");
      localn1.r("level", k + ",");
      localn1.r("scale", j + ",");
      localn1.r("createTime", System.currentTimeMillis() + ",");
      localn2.r("prewViewlist1", localb.KUu + ",");
      localn2.r("pictureSize1", localb.KUv + ",");
      localn2.r("prewViewlist2", localb.KUw + ",");
      localn2.r("pictureSize2", localb.KUx + ",");
      Log.i("MicroMsg.CaptureStatistics", "report " + localn1.aIF());
      Log.v("MicroMsg.CaptureStatistics", "report " + localn2.aIF());
      h.OAn.kvStat(13947, localn1.toString());
      h.OAn.kvStat(13949, localn2.toString());
      if (!paramBoolean) {
        break label1738;
      }
      h.OAn.idkeyStat(440L, 119L, 1L, false);
      h.OAn.idkeyStat(440L, 120L, paramLong, false);
      if (j.KVJ.nFY != 720) {
        break label1689;
      }
      h.OAn.idkeyStat(440L, 122L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
      i = 0;
      break;
      i = 0;
    }
    label1689:
    if (j.KVJ.gcs())
    {
      h.OAn.idkeyStat(440L, 123L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    h.OAn.idkeyStat(440L, 121L, paramLong, false);
    AppMethodBeat.o(89439);
    return;
    label1738:
    h.OAn.idkeyStat(440L, 124L, 1L, false);
    h.OAn.idkeyStat(440L, 125L, paramLong, false);
    if (j.KVJ.lWy == 1)
    {
      h.OAn.idkeyStat(440L, 127L, paramLong, false);
      h.OAn.idkeyStat(440L, 131L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    h.OAn.idkeyStat(440L, 126L, paramLong, false);
    h.OAn.idkeyStat(440L, 130L, paramLong, false);
    AppMethodBeat.o(89439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.k
 * JD-Core Version:    0.7.0.1
 */