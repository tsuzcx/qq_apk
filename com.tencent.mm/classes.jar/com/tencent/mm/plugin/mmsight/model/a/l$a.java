package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Process;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class l$a
  implements Runnable
{
  Runnable bFJ = null;
  int duration;
  volatile int eJK = 0;
  final Object eJN = new Object();
  int mjP;
  float mjQ;
  volatile boolean mjR = true;
  boolean mjS = false;
  boolean mjT = false;
  boolean mjU = false;
  boolean mjV = false;
  
  public l$a(l paraml)
  {
    synchronized (this.eJN)
    {
      try
      {
        String str2 = com.tencent.mm.vfs.e.aeS(paraml.mjq);
        String str1 = str2;
        if (!str2.endsWith("/")) {
          str1 = str2 + "/";
        }
        paraml.mjA = (str1 + "tempRotate.mp4");
      }
      catch (Exception paraml)
      {
        for (;;)
        {
          y.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", new Object[] { paraml.getMessage() });
        }
      }
      return;
    }
  }
  
  public final void run()
  {
    if (this.mjO.eJL == -1)
    {
      this.mjO.eJL = Process.myTid();
      Process.setThreadPriority(Process.myTid(), -2);
      y.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(this.mjO.eJL) });
    }
    int i;
    int j;
    for (;;)
    {
      synchronized (this.eJN)
      {
        if (this.mjT) {
          break label191;
        }
        l = bk.UZ();
        i = SightVideoJNI.triggerEncode(this.mjP, Math.max(0, this.eJK), false);
        y.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(this.eJK), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
        j = Math.abs(i - this.eJK);
        if (j > 5) {}
      }
      try
      {
        Thread.sleep(100L);
        this.eJK = i;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          y.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
        }
      }
    }
    label191:
    long l = bk.UZ();
    if (!this.mjU) {
      this.eJK = SightVideoJNI.triggerEncode(this.mjP, this.eJK, true);
    }
    y.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(this.eJK), Boolean.valueOf(this.mjU), Long.valueOf(Thread.currentThread().getId()) });
    if (!this.mjU)
    {
      i = Math.max(1000, this.duration);
      if (this.mjO.mjt > 0) {
        i = this.mjO.mjt;
      }
      float f = this.mjQ;
      if (this.mjO.mju > 0.0F) {
        f = this.mjO.mju;
      }
      this.mjO.mjp = new m(this.mjP, this.mjO.mjq, f, this.mjO.mjx, i, this.mjO.mfr.audioSampleRate, false);
      l = bk.UZ();
      boolean bool = this.mjO.mjp.bjx();
      y.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bk.cp(l)), Boolean.valueOf(bool) });
      if (!bool)
      {
        y.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
        SightVideoJNI.releaseBigSightDataBuffer(this.mjP);
        ai.d(new l.a.1(this));
        y.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
        h.nFQ.a(440L, 30L, 1L, false);
        return;
      }
      if (((this.mjO.fwq) && (this.mjO.mhL)) || ((!this.mjO.mhL) && (!this.mjO.fwq)) || ((this.mjO.fwq) && (Math.abs(this.mjO.jWo - this.mjO.mjI) == 0)) || (this.mjO.mjI == 180))
      {
        l = bk.UZ();
        if ((this.mjO.mhL) || (this.mjO.fwq)) {
          break label870;
        }
        i = this.mjO.jWo;
      }
    }
    for (;;)
    {
      j = i;
      if (this.mjO.mjI == 180)
      {
        j = i;
        if (!this.mjO.mhL)
        {
          i += 180;
          j = i;
          if (i > 360) {
            j = i - 360;
          }
        }
      }
      String str;
      if (j > 0)
      {
        SightVideoJNI.tagRotateVideo(this.mjO.mjq, this.mjO.mjA, j);
        y.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(this.mjO.jWo), Boolean.valueOf(this.mjO.fwq), Integer.valueOf(this.mjO.mjI), Integer.valueOf(j) });
        str = this.mjO.mjA;
      }
      try
      {
        com.tencent.mm.vfs.e.r(this.mjO.mjA, this.mjO.mjq);
        com.tencent.mm.sdk.f.e.post(new l.a.3(this, str), "BigSightFFMpegRecorder_tagRotate_after_process");
        y.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
        SightVideoJNI.releaseBigSightDataBuffer(this.mjP);
        y.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[] { this.bFJ });
        this.mjO.reset();
        ai.d(this.bFJ);
        this.mjV = true;
        this.mjO.eJL = -1;
        this.mjO.mjD = -1;
        return;
      }
      catch (Exception localException2)
      {
        label870:
        y.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
        SightVideoJNI.releaseBigSightDataBuffer(this.mjP);
        ai.d(new l.a.2(this));
        return;
      }
      if (this.mjO.mhL) {
        i = this.mjO.mjI;
      } else {
        i = 180;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l.a
 * JD-Core Version:    0.7.0.1
 */