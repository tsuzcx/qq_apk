package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONObject;

public final class l
{
  public static void an(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89438);
    int i;
    try
    {
      if (k.uLk == null) {
        break label207;
      }
      i = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString)).optInt("videoBitrate");
      if (paramInt2 == 1)
      {
        if (paramInt1 == 1)
        {
          h.wUl.idkeyStat(440L, 189L, i, false);
          h.wUl.idkeyStat(440L, 190L, 1L, false);
          AppMethodBeat.o(89438);
          return;
        }
        h.wUl.idkeyStat(440L, 184L, i, false);
        h.wUl.idkeyStat(440L, 185L, 1L, false);
        AppMethodBeat.o(89438);
        return;
      }
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(89438);
      return;
    }
    if (paramInt2 == 2)
    {
      if (paramInt1 == 1)
      {
        h.wUl.idkeyStat(440L, 194L, i, false);
        h.wUl.idkeyStat(440L, 195L, 1L, false);
        AppMethodBeat.o(89438);
        return;
      }
      h.wUl.idkeyStat(440L, 199L, i, false);
      h.wUl.idkeyStat(440L, 200L, 1L, false);
    }
    label207:
    AppMethodBeat.o(89438);
  }
  
  public static void arM()
  {
    AppMethodBeat.i(89432);
    ac.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
    h.wUl.idkeyStat(440L, 2L, 1L, false);
    AppMethodBeat.o(89432);
  }
  
  public static void arU()
  {
    AppMethodBeat.i(89435);
    ac.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
    h.wUl.idkeyStat(440L, 16L, 1L, false);
    AppMethodBeat.o(89435);
  }
  
  public static void arV()
  {
    AppMethodBeat.i(89436);
    ac.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
    h.wUl.idkeyStat(440L, 21L, 1L, false);
    AppMethodBeat.o(89436);
  }
  
  public static void atO()
  {
    AppMethodBeat.i(89440);
    h.wUl.idkeyStat(440L, 140L, 0L, false);
    AppMethodBeat.o(89440);
  }
  
  public static void ddA()
  {
    AppMethodBeat.i(89431);
    ac.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
    h.wUl.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    int j;
    if (k.uLk != null)
    {
      if (k.uLk.fHJ == 1) {
        i = 39;
      }
      if (k.uLk.gXd != 720) {
        break label81;
      }
      j = i + 1;
    }
    for (;;)
    {
      h.wUl.idkeyStat(440L, j, 1L, false);
      AppMethodBeat.o(89431);
      return;
      label81:
      j = i;
      if (k.uLk.ddI()) {
        j = i + 2;
      }
    }
  }
  
  public static void ddB()
  {
    AppMethodBeat.i(89433);
    ac.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
    h.wUl.idkeyStat(440L, 7L, 1L, false);
    AppMethodBeat.o(89433);
  }
  
  public static void ddC()
  {
    AppMethodBeat.i(89434);
    ac.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
    h.wUl.idkeyStat(440L, 8L, 1L, false);
    AppMethodBeat.o(89434);
  }
  
  public static void ddD()
  {
    AppMethodBeat.i(89437);
    ac.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
    h.wUl.idkeyStat(440L, 31L, 1L, false);
    AppMethodBeat.o(89437);
  }
  
  public static void g(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(89439);
    ac.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    b.ddk().uKq = paramLong;
    b localb = b.ddk();
    f localf1 = new f();
    f localf2 = new f();
    localf1.m("model", localb.model + ",");
    localf1.m("apiLevel", localb.uJS + ",");
    localf1.m("memoryClass", localb.ibB + ",");
    localf1.m("totalMemory", localb.hby + ",");
    localf1.m("maxCpu", localb.uJT + ",");
    localf1.m("screenW", localb.uJU + ",");
    localf1.m("screenH", localb.uJV + ",");
    localf2.m("model", localb.model + ",");
    localf2.m("apiLevel", localb.uJS + ",");
    localf2.m("memoryClass", localb.ibB + ",");
    localf2.m("totalMemory", localb.hby + ",");
    localf2.m("maxCpu", localb.uJT + ",");
    localf2.m("screenW", localb.uJU + ",");
    localf2.m("screenH", localb.uJV + ",");
    localf1.m("cropx", localb.uKa + ",");
    localf1.m("cropy", localb.uKb + ",");
    localf1.m("previewx", localb.uKc + ",");
    localf1.m("previewy", localb.uKd + ",");
    localf1.m("encoderx", localb.uKe + ",");
    localf1.m("encodery", localb.uKf + ",");
    localf1.m("rotate", localb.duc + ",");
    localf1.m("deviceoutfps", localb.uKg + ",");
    localf1.m("recordfps", localb.uKh + ",");
    localf1.m("recordertype", localb.uKi + ",");
    localf1.m("videoBitrate", localb.videoBitrate + ",");
    localf1.m("needRotateEachFrame", localb.fHK + ",");
    localf1.m("isNeedRealtimeScale", localb.uKj + ",");
    localf1.m("resolutionLimit", localb.gXd + ",");
    localf1.m("outfps", localb.uKk + ",");
    localf1.m("recordTime", localb.uKl + ",");
    localf1.m("avgcpu", localb.uKm + ",");
    localf1.m("outx", localb.uKn + ",");
    localf1.m("outy", localb.uKo + ",");
    localf1.m("outbitrate", localb.uKp + ",");
    localf1.m("fileSize", localb.fileSize + ",");
    localf1.m("wait2playtime", localb.uKq + ",");
    localf1.m("useback", localb.uKr + ",");
    int k = 0;
    int j = 0;
    Intent localIntent = ai.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
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
      ac.i("MicroMsg.CaptureStatistics", "battery %s %s %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      localf1.m("mIsCharging", i + ",");
      localf1.m("level", k + ",");
      localf1.m("scale", j + ",");
      localf1.m("createTime", System.currentTimeMillis() + ",");
      localf2.m("prewViewlist1", localb.uJW + ",");
      localf2.m("pictureSize1", localb.uJX + ",");
      localf2.m("prewViewlist2", localb.uJY + ",");
      localf2.m("pictureSize2", localb.uJZ + ",");
      ac.i("MicroMsg.CaptureStatistics", "report " + localf1.PS());
      ac.v("MicroMsg.CaptureStatistics", "report " + localf2.PS());
      h.wUl.kvStat(13947, localf1.toString());
      h.wUl.kvStat(13949, localf2.toString());
      if (!paramBoolean) {
        break label1738;
      }
      h.wUl.idkeyStat(440L, 119L, 1L, false);
      h.wUl.idkeyStat(440L, 120L, paramLong, false);
      if (k.uLk.gXd != 720) {
        break label1689;
      }
      h.wUl.idkeyStat(440L, 122L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
      i = 0;
      break;
      i = 0;
    }
    label1689:
    if (k.uLk.ddI())
    {
      h.wUl.idkeyStat(440L, 123L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    h.wUl.idkeyStat(440L, 121L, paramLong, false);
    AppMethodBeat.o(89439);
    return;
    label1738:
    h.wUl.idkeyStat(440L, 124L, 1L, false);
    h.wUl.idkeyStat(440L, 125L, paramLong, false);
    if (k.uLk.fHJ == 1)
    {
      h.wUl.idkeyStat(440L, 127L, paramLong, false);
      h.wUl.idkeyStat(440L, 131L, paramLong, false);
      AppMethodBeat.o(89439);
      return;
    }
    h.wUl.idkeyStat(440L, 126L, paramLong, false);
    h.wUl.idkeyStat(440L, 130L, paramLong, false);
    AppMethodBeat.o(89439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.l
 * JD-Core Version:    0.7.0.1
 */