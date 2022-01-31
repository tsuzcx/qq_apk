package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class k
{
  public static void biU()
  {
    y.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
    h.nFQ.a(440L, 0L, 1L, false);
    int i = 36;
    if (j.mhB.dys == 1) {
      i = 39;
    }
    int j;
    if (j.mhB.mgf == 720) {
      j = i + 1;
    }
    for (;;)
    {
      h.nFQ.a(440L, j, 1L, false);
      return;
      j = i;
      if (j.mhB.bjd()) {
        j = i + 2;
      }
    }
  }
  
  public static void biV()
  {
    y.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
    h.nFQ.a(440L, 2L, 1L, false);
  }
  
  public static void biW()
  {
    y.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
    h.nFQ.a(440L, 7L, 1L, false);
  }
  
  public static void biX()
  {
    y.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
    h.nFQ.a(440L, 8L, 1L, false);
  }
  
  public static void biY()
  {
    y.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
    h.nFQ.a(440L, 16L, 1L, false);
  }
  
  public static void biZ()
  {
    y.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
    h.nFQ.a(440L, 21L, 1L, false);
  }
  
  public static void d(boolean paramBoolean, long paramLong)
  {
    y.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    a.biE().mgm = paramLong;
    a locala = a.biE();
    d locald1 = new d();
    d locald2 = new d();
    locald1.i("model", locala.model + ",");
    locald1.i("apiLevel", locala.mfM + ",");
    locald1.i("memoryClass", locala.eIy + ",");
    locald1.i("totalMemory", locala.mfN + ",");
    locald1.i("maxCpu", locala.mfO + ",");
    locald1.i("screenW", locala.mfP + ",");
    locald1.i("screenH", locala.mfQ + ",");
    locald2.i("model", locala.model + ",");
    locald2.i("apiLevel", locala.mfM + ",");
    locald2.i("memoryClass", locala.eIy + ",");
    locald2.i("totalMemory", locala.mfN + ",");
    locald2.i("maxCpu", locala.mfO + ",");
    locald2.i("screenW", locala.mfP + ",");
    locald2.i("screenH", locala.mfQ + ",");
    locald1.i("cropx", locala.mfV + ",");
    locald1.i("cropy", locala.mfW + ",");
    locald1.i("previewx", locala.mfX + ",");
    locald1.i("previewy", locala.mfY + ",");
    locald1.i("encoderx", locala.mfZ + ",");
    locald1.i("encodery", locala.mga + ",");
    locald1.i("rotate", locala.rotate + ",");
    locald1.i("deviceoutfps", locala.mgb + ",");
    locald1.i("recordfps", locala.mgc + ",");
    locald1.i("recordertype", locala.mgd + ",");
    locald1.i("videoBitrate", locala.videoBitrate + ",");
    locald1.i("needRotateEachFrame", locala.dyt + ",");
    locald1.i("isNeedRealtimeScale", locala.mge + ",");
    locald1.i("resolutionLimit", locala.mgf + ",");
    locald1.i("outfps", locala.mgg + ",");
    locald1.i("recordTime", locala.mgh + ",");
    locald1.i("avgcpu", locala.mgi + ",");
    locald1.i("outx", locala.mgj + ",");
    locald1.i("outy", locala.mgk + ",");
    locald1.i("outbitrate", locala.mgl + ",");
    locald1.i("fileSize", locala.fileSize + ",");
    locald1.i("wait2playtime", locala.mgm + ",");
    locald1.i("useback", locala.mgn + ",");
    int j = 0;
    Intent localIntent = ae.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    int m;
    int k;
    if (localIntent != null)
    {
      i = localIntent.getIntExtra("status", -1);
      if ((i == 2) || (i == 5))
      {
        i = 1;
        j = localIntent.getIntExtra("level", -1);
        m = localIntent.getIntExtra("scale", -1);
        k = i;
      }
    }
    for (int i = m;; i = 0)
    {
      y.i("MicroMsg.CaptureStatistics", "battery %s %s %s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
      locald1.i("mIsCharging", k + ",");
      locald1.i("level", j + ",");
      locald1.i("scale", i + ",");
      locald1.i("createTime", System.currentTimeMillis() + ",");
      locald2.i("prewViewlist1", locala.mfR + ",");
      locald2.i("pictureSize1", locala.mfS + ",");
      locald2.i("prewViewlist2", locala.mfT + ",");
      locald2.i("pictureSize2", locala.mfU + ",");
      y.i("MicroMsg.CaptureStatistics", "report " + locald1.uJ());
      y.v("MicroMsg.CaptureStatistics", "report " + locald2.uJ());
      h.nFQ.aC(13947, locald1.toString());
      h.nFQ.aC(13949, locald2.toString());
      if (!paramBoolean) {
        break label1710;
      }
      h.nFQ.a(440L, 119L, 1L, false);
      h.nFQ.a(440L, 120L, paramLong, false);
      if (j.mhB.mgf != 720) {
        break label1671;
      }
      h.nFQ.a(440L, 122L, paramLong, false);
      return;
      i = 0;
      break;
      k = 0;
    }
    label1671:
    if (j.mhB.bjd())
    {
      h.nFQ.a(440L, 123L, paramLong, false);
      return;
    }
    h.nFQ.a(440L, 121L, paramLong, false);
    return;
    label1710:
    h.nFQ.a(440L, 124L, 1L, false);
    h.nFQ.a(440L, 125L, paramLong, false);
    if (j.mhB.dys == 1)
    {
      h.nFQ.a(440L, 127L, paramLong, false);
      h.nFQ.a(440L, 131L, paramLong, false);
      return;
    }
    h.nFQ.a(440L, 126L, paramLong, false);
    h.nFQ.a(440L, 130L, paramLong, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.k
 * JD-Core Version:    0.7.0.1
 */