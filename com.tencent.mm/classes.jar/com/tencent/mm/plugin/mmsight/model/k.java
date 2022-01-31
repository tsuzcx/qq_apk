package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import org.json.JSONObject;

public final class k
{
  public static void VF()
  {
    AppMethodBeat.i(76532);
    ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
    h.qsU.idkeyStat(440L, 2L, 1L, false);
    AppMethodBeat.o(76532);
  }
  
  public static void VN()
  {
    AppMethodBeat.i(76535);
    ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
    h.qsU.idkeyStat(440L, 16L, 1L, false);
    AppMethodBeat.o(76535);
  }
  
  public static void VO()
  {
    AppMethodBeat.i(76536);
    ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
    h.qsU.idkeyStat(440L, 21L, 1L, false);
    AppMethodBeat.o(76536);
  }
  
  public static void a(String paramString, bby parambby, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140127);
    for (;;)
    {
      int m;
      int n;
      int i;
      int k;
      int j;
      try
      {
        if (!bo.isNullOrNil(paramString))
        {
          boolean bool = e.cN(paramString);
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(140127);
          return;
        }
        h.qsU.idkeyStat(440L, 87L, 1L, false);
        Object localObject = new JSONObject(SightVideoJNI.getSimpleMp4Info(paramString));
        m = (int)((JSONObject)localObject).getDouble("videoFPS");
        n = ((JSONObject)localObject).optInt("videoBitrate");
        ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        localObject = a.bQG();
        ((a)localObject).oGD = j.oHG.eqK;
        ((a)localObject).videoBitrate = j.oHG.videoBitrate;
        if (!j.oHG.fdl) {
          break label516;
        }
        i = 1;
        ((a)localObject).eqL = i;
        if (!j.oHG.oHS) {
          break label522;
        }
        i = 1;
        ((a)localObject).oGE = i;
        ((a)localObject).eZQ = j.oHG.eZQ;
        ((a)localObject).oGF = m;
        ((a)localObject).fileSize = e.avI(paramString);
        com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.d.Zo(paramString);
        if (locala != null)
        {
          ((a)localObject).oGI = locala.width;
          ((a)localObject).oGJ = locala.height;
          ((a)localObject).oGK = locala.videoBitrate;
          ((a)localObject).oGG = locala.eVA;
        }
        if (paramInt1 != 1) {
          break label528;
        }
        h.qsU.idkeyStat(440L, 89L, 1L, false);
        h.qsU.idkeyStat(440L, 49L, m, false);
        i = 93;
        k = 73;
        j = 69;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(140127);
        return;
      }
      h.qsU.idkeyStat(440L, paramInt2, m, false);
      h.qsU.idkeyStat(440L, i, 1L, false);
      h.qsU.idkeyStat(440L, 47L, m, false);
      ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { paramString, Integer.valueOf(j) });
      if ((m >= 0) && (m <= 10))
      {
        h.qsU.idkeyStat(440L, j, 1L, false);
        label403:
        if (n <= 0) {
          break label851;
        }
        if (paramInt1 != 2) {
          break label735;
        }
        h.qsU.idkeyStat(440L, 175L, n, false);
        h.qsU.idkeyStat(440L, 176L, 1L, false);
        if (parambby == null) {
          break label851;
        }
        if (parambby.xrc != 1) {
          break label691;
        }
        h.qsU.idkeyStat(440L, 184L, n, false);
        h.qsU.idkeyStat(440L, 185L, 1L, false);
        AppMethodBeat.o(140127);
        return;
        label516:
        i = 0;
        continue;
        label522:
        i = 0;
        continue;
        label528:
        h.qsU.idkeyStat(440L, 88L, 1L, false);
        h.qsU.idkeyStat(440L, 48L, m, false);
        i = 90;
        k = 54;
        j = 50;
        break label863;
      }
      for (;;)
      {
        if (!j.oHG.bRg())
        {
          if (paramInt2 == 1080)
          {
            break label892;
            if ((m > 10) && (m <= 15))
            {
              h.qsU.idkeyStat(440L, j + 1, 1L, false);
              break label403;
            }
            if ((m > 15) && (m <= 20))
            {
              h.qsU.idkeyStat(440L, j + 2, 1L, false);
              break label403;
            }
            if ((m <= 20) || (m > 30)) {
              break label403;
            }
            h.qsU.idkeyStat(440L, j + 3, 1L, false);
            break label403;
            label691:
            if (parambby.xrc == 2)
            {
              h.qsU.idkeyStat(440L, 194L, n, false);
              h.qsU.idkeyStat(440L, 195L, 1L, false);
              AppMethodBeat.o(140127);
              return;
              label735:
              h.qsU.idkeyStat(440L, 179L, n, false);
              h.qsU.idkeyStat(440L, 180L, 1L, false);
              if (parambby != null)
              {
                if (parambby.xrc == 1)
                {
                  h.qsU.idkeyStat(440L, 189L, n, false);
                  h.qsU.idkeyStat(440L, 190L, 1L, false);
                  AppMethodBeat.o(140127);
                  return;
                }
                if (parambby.xrc == 2)
                {
                  h.qsU.idkeyStat(440L, 199L, n, false);
                  h.qsU.idkeyStat(440L, 200L, 1L, false);
                }
              }
            }
            label851:
            AppMethodBeat.o(140127);
            return;
          }
          paramInt2 = k;
          break;
          label863:
          if (paramInt2 == 720)
          {
            i += 1;
            paramInt2 = k + 6;
            j += 6;
            break;
          }
        }
      }
      label892:
      i += 2;
      paramInt2 = k + 12;
      j += 12;
    }
  }
  
  public static void ao(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140126);
    int i;
    try
    {
      if (j.oHG == null) {
        break label207;
      }
      i = new JSONObject(SightVideoJNI.getSimpleMp4Info(paramString)).optInt("videoBitrate");
      if (paramInt2 == 1)
      {
        if (paramInt1 == 1)
        {
          h.qsU.idkeyStat(440L, 189L, i, false);
          h.qsU.idkeyStat(440L, 190L, 1L, false);
          AppMethodBeat.o(140126);
          return;
        }
        h.qsU.idkeyStat(440L, 184L, i, false);
        h.qsU.idkeyStat(440L, 185L, 1L, false);
        AppMethodBeat.o(140126);
        return;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(140126);
      return;
    }
    if (paramInt2 == 2)
    {
      if (paramInt1 == 1)
      {
        h.qsU.idkeyStat(440L, 194L, i, false);
        h.qsU.idkeyStat(440L, 195L, 1L, false);
        AppMethodBeat.o(140126);
        return;
      }
      h.qsU.idkeyStat(440L, 199L, i, false);
      h.qsU.idkeyStat(440L, 200L, 1L, false);
    }
    label207:
    AppMethodBeat.o(140126);
  }
  
  public static void bQX()
  {
    AppMethodBeat.i(76531);
    ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
    h.qsU.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    int j;
    if (j.oHG != null)
    {
      if (j.oHG.eqK == 1) {
        i = 39;
      }
      if (j.oHG.eZQ != 720) {
        break label81;
      }
      j = i + 1;
    }
    for (;;)
    {
      h.qsU.idkeyStat(440L, j, 1L, false);
      AppMethodBeat.o(76531);
      return;
      label81:
      j = i;
      if (j.oHG.bRg()) {
        j = i + 2;
      }
    }
  }
  
  public static void bQY()
  {
    AppMethodBeat.i(76533);
    ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
    h.qsU.idkeyStat(440L, 7L, 1L, false);
    AppMethodBeat.o(76533);
  }
  
  public static void bQZ()
  {
    AppMethodBeat.i(76534);
    ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
    h.qsU.idkeyStat(440L, 8L, 1L, false);
    AppMethodBeat.o(76534);
  }
  
  public static void bRa()
  {
    AppMethodBeat.i(76537);
    ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
    h.qsU.idkeyStat(440L, 31L, 1L, false);
    AppMethodBeat.o(76537);
  }
  
  public static void bRb()
  {
    AppMethodBeat.i(76539);
    h.qsU.idkeyStat(440L, 140L, 0L, false);
    AppMethodBeat.o(76539);
  }
  
  public static void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(76538);
    ab.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    a.bQG().oGL = paramLong;
    a locala = a.bQG();
    com.tencent.mm.modelsns.d locald1 = new com.tencent.mm.modelsns.d();
    com.tencent.mm.modelsns.d locald2 = new com.tencent.mm.modelsns.d();
    locald1.j("model", locala.model + ",");
    locald1.j("apiLevel", locala.oGm + ",");
    locald1.j("memoryClass", locala.fYn + ",");
    locald1.j("totalMemory", locala.oGn + ",");
    locald1.j("maxCpu", locala.oGo + ",");
    locald1.j("screenW", locala.oGp + ",");
    locald1.j("screenH", locala.oGq + ",");
    locald2.j("model", locala.model + ",");
    locald2.j("apiLevel", locala.oGm + ",");
    locald2.j("memoryClass", locala.fYn + ",");
    locald2.j("totalMemory", locala.oGn + ",");
    locald2.j("maxCpu", locala.oGo + ",");
    locald2.j("screenW", locala.oGp + ",");
    locald2.j("screenH", locala.oGq + ",");
    locald1.j("cropx", locala.oGv + ",");
    locald1.j("cropy", locala.oGw + ",");
    locald1.j("previewx", locala.oGx + ",");
    locald1.j("previewy", locala.oGy + ",");
    locald1.j("encoderx", locala.oGz + ",");
    locald1.j("encodery", locala.oGA + ",");
    locald1.j("rotate", locala.rotate + ",");
    locald1.j("deviceoutfps", locala.oGB + ",");
    locald1.j("recordfps", locala.oGC + ",");
    locald1.j("recordertype", locala.oGD + ",");
    locald1.j("videoBitrate", locala.videoBitrate + ",");
    locald1.j("needRotateEachFrame", locala.eqL + ",");
    locald1.j("isNeedRealtimeScale", locala.oGE + ",");
    locald1.j("resolutionLimit", locala.eZQ + ",");
    locald1.j("outfps", locala.oGF + ",");
    locald1.j("recordTime", locala.oGG + ",");
    locald1.j("avgcpu", locala.oGH + ",");
    locald1.j("outx", locala.oGI + ",");
    locald1.j("outy", locala.oGJ + ",");
    locald1.j("outbitrate", locala.oGK + ",");
    locald1.j("fileSize", locala.fileSize + ",");
    locald1.j("wait2playtime", locala.oGL + ",");
    locald1.j("useback", locala.oGM + ",");
    int k = 0;
    int j = 0;
    Intent localIntent = ah.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
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
      ab.i("MicroMsg.CaptureStatistics", "battery %s %s %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      locald1.j("mIsCharging", i + ",");
      locald1.j("level", k + ",");
      locald1.j("scale", j + ",");
      locald1.j("createTime", System.currentTimeMillis() + ",");
      locald2.j("prewViewlist1", locala.oGr + ",");
      locald2.j("pictureSize1", locala.oGs + ",");
      locald2.j("prewViewlist2", locala.oGt + ",");
      locald2.j("pictureSize2", locala.oGu + ",");
      ab.i("MicroMsg.CaptureStatistics", "report " + locald1.Fg());
      ab.v("MicroMsg.CaptureStatistics", "report " + locald2.Fg());
      h.qsU.kvStat(13947, locald1.toString());
      h.qsU.kvStat(13949, locald2.toString());
      if (!paramBoolean) {
        break label1807;
      }
      h.qsU.idkeyStat(440L, 119L, 1L, false);
      h.qsU.idkeyStat(440L, 120L, paramLong, false);
      if (j.oHG.eZQ != 720) {
        break label1756;
      }
      h.qsU.idkeyStat(440L, 122L, paramLong, false);
      AppMethodBeat.o(76538);
      return;
      i = 0;
      break;
      i = 0;
    }
    label1756:
    if (j.oHG.bRg())
    {
      h.qsU.idkeyStat(440L, 123L, paramLong, false);
      AppMethodBeat.o(76538);
      return;
    }
    h.qsU.idkeyStat(440L, 121L, paramLong, false);
    AppMethodBeat.o(76538);
    return;
    label1807:
    h.qsU.idkeyStat(440L, 124L, 1L, false);
    h.qsU.idkeyStat(440L, 125L, paramLong, false);
    if (j.oHG.eqK == 1)
    {
      h.qsU.idkeyStat(440L, 127L, paramLong, false);
      h.qsU.idkeyStat(440L, 131L, paramLong, false);
      AppMethodBeat.o(76538);
      return;
    }
    h.qsU.idkeyStat(440L, 126L, paramLong, false);
    h.qsU.idkeyStat(440L, 130L, paramLong, false);
    AppMethodBeat.o(76538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.k
 * JD-Core Version:    0.7.0.1
 */