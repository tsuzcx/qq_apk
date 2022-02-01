package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class l
{
  public static void aNB()
  {
    AppMethodBeat.i(89432);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
    h.CyF.idkeyStat(440L, 2L, 1L, false);
    AppMethodBeat.o(89432);
  }
  
  public static void aNJ()
  {
    AppMethodBeat.i(89435);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
    h.CyF.idkeyStat(440L, 16L, 1L, false);
    AppMethodBeat.o(89435);
  }
  
  public static void aNK()
  {
    AppMethodBeat.i(89436);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
    h.CyF.idkeyStat(440L, 21L, 1L, false);
    AppMethodBeat.o(89436);
  }
  
  public static void au(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89438);
    int i;
    try
    {
      if (k.zuy == null) {
        break label207;
      }
      i = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString)).optInt("videoBitrate");
      if (paramInt2 == 1)
      {
        if (paramInt1 == 1)
        {
          h.CyF.idkeyStat(440L, 189L, i, false);
          h.CyF.idkeyStat(440L, 190L, 1L, false);
          AppMethodBeat.o(89438);
          return;
        }
        h.CyF.idkeyStat(440L, 184L, i, false);
        h.CyF.idkeyStat(440L, 185L, 1L, false);
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
        h.CyF.idkeyStat(440L, 194L, i, false);
        h.CyF.idkeyStat(440L, 195L, 1L, false);
        AppMethodBeat.o(89438);
        return;
      }
      h.CyF.idkeyStat(440L, 199L, i, false);
      h.CyF.idkeyStat(440L, 200L, 1L, false);
    }
    label207:
    AppMethodBeat.o(89438);
  }
  
  public static void ejJ()
  {
    AppMethodBeat.i(89431);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
    h.CyF.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    int j;
    if (k.zuy != null)
    {
      if (k.zuy.gIP == 1) {
        i = 39;
      }
      if (k.zuy.ilT != 720) {
        break label81;
      }
      j = i + 1;
    }
    for (;;)
    {
      h.CyF.idkeyStat(440L, j, 1L, false);
      AppMethodBeat.o(89431);
      return;
      label81:
      j = i;
      if (k.zuy.ejS()) {
        j = i + 2;
      }
    }
  }
  
  public static void ejK()
  {
    AppMethodBeat.i(89433);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
    h.CyF.idkeyStat(440L, 7L, 1L, false);
    AppMethodBeat.o(89433);
  }
  
  public static void ejL()
  {
    AppMethodBeat.i(89434);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
    h.CyF.idkeyStat(440L, 8L, 1L, false);
    AppMethodBeat.o(89434);
  }
  
  public static void ejM()
  {
    AppMethodBeat.i(89437);
    Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
    h.CyF.idkeyStat(440L, 31L, 1L, false);
    AppMethodBeat.o(89437);
  }
  
  public static void ejN()
  {
    AppMethodBeat.i(89440);
    h.CyF.idkeyStat(440L, 140L, 0L, false);
    AppMethodBeat.o(89440);
  }
  
  public static void h(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(89439);
    Log.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    b.ejt().ztB = paramLong;
    b localb = b.ejt();
    m localm1 = new m();
    m localm2 = new m();
    localm1.m("model", localb.model + ",");
    localm1.m("apiLevel", localb.ztd + ",");
    localm1.m("memoryClass", localb.jtg + ",");
    localm1.m("totalMemory", localb.ipW + ",");
    localm1.m("maxCpu", localb.zte + ",");
    localm1.m("screenW", localb.ztf + ",");
    localm1.m("screenH", localb.ztg + ",");
    localm2.m("model", localb.model + ",");
    localm2.m("apiLevel", localb.ztd + ",");
    localm2.m("memoryClass", localb.jtg + ",");
    localm2.m("totalMemory", localb.ipW + ",");
    localm2.m("maxCpu", localb.zte + ",");
    localm2.m("screenW", localb.ztf + ",");
    localm2.m("screenH", localb.ztg + ",");
    localm1.m("cropx", localb.ztl + ",");
    localm1.m("cropy", localb.ztm + ",");
    localm1.m("previewx", localb.ztn + ",");
    localm1.m("previewy", localb.zto + ",");
    localm1.m("encoderx", localb.ztp + ",");
    localm1.m("encodery", localb.ztq + ",");
    localm1.m("rotate", localb.dYT + ",");
    localm1.m("deviceoutfps", localb.ztr + ",");
    localm1.m("recordfps", localb.zts + ",");
    localm1.m("recordertype", localb.ztt + ",");
    localm1.m("videoBitrate", localb.videoBitrate + ",");
    localm1.m("needRotateEachFrame", localb.gIQ + ",");
    localm1.m("isNeedRealtimeScale", localb.ztu + ",");
    localm1.m("resolutionLimit", localb.ilT + ",");
    localm1.m("outfps", localb.ztv + ",");
    localm1.m("recordTime", localb.ztw + ",");
    localm1.m("avgcpu", localb.ztx + ",");
    localm1.m("outx", localb.zty + ",");
    localm1.m("outy", localb.ztz + ",");
    localm1.m("outbitrate", localb.ztA + ",");
    localm1.m("fileSize", localb.fileSize + ",");
    localm1.m("wait2playtime", localb.ztB + ",");
    localm1.m("useback", localb.ztC + ",");
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
      localm1.m("mIsCharging", i + ",");
      localm1.m("level", k + ",");
      localm1.m("scale", j + ",");
      localm1.m("createTime", System.currentTimeMillis() + ",");
      localm2.m("prewViewlist1", localb.zth + ",");
      localm2.m("pictureSize1", localb.zti + ",");
      localm2.m("prewViewlist2", localb.ztj + ",");
      localm2.m("pictureSize2", localb.ztk + ",");
      Log.i("MicroMsg.CaptureStatistics", "report " + localm1.abW());
      Log.v("MicroMsg.CaptureStatistics", "report " + localm2.abW());
      h.CyF.kvStat(13947, localm1.toString());
      h.CyF.kvStat(13949, localm2.toString());
      if (!paramBoolean) {
        break label1738;
      }
      h.CyF.idkeyStat(440L, 119L, 1L, false);
      h.CyF.idkeyStat(440L, 120L, paramLong, false);
      if (k.zuy.ilT != 720) {
        break label1689;
      }
      h.CyF.idkeyStat(440L, 122L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
      i = 0;
      break;
      i = 0;
    }
    label1689:
    if (k.zuy.ejS())
    {
      h.CyF.idkeyStat(440L, 123L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    h.CyF.idkeyStat(440L, 121L, paramLong, false);
    AppMethodBeat.o(89439);
    return;
    label1738:
    h.CyF.idkeyStat(440L, 124L, 1L, false);
    h.CyF.idkeyStat(440L, 125L, paramLong, false);
    if (k.zuy.gIP == 1)
    {
      h.CyF.idkeyStat(440L, 127L, paramLong, false);
      h.CyF.idkeyStat(440L, 131L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    h.CyF.idkeyStat(440L, 126L, paramLong, false);
    h.CyF.idkeyStat(440L, 130L, paramLong, false);
    AppMethodBeat.o(89439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.l
 * JD-Core Version:    0.7.0.1
 */