package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class l$a
  implements Runnable
{
  float bJg;
  Runnable callback;
  int duration;
  volatile int eUK;
  int fds;
  volatile boolean fdt;
  boolean fdu;
  boolean fdv;
  boolean fdw;
  boolean fdx;
  final Object fdy;
  
  public l$a(l paraml)
  {
    AppMethodBeat.i(76604);
    this.eUK = 0;
    this.fdt = true;
    this.fdu = false;
    this.fdv = false;
    this.fdw = false;
    this.fdx = false;
    this.fdy = new Object();
    this.callback = null;
    synchronized (this.fdy)
    {
      try
      {
        String str2 = com.tencent.mm.vfs.e.avK(paraml.fca);
        String str1 = str2;
        if (!str2.endsWith("/")) {
          str1 = str2 + "/";
        }
        paraml.fco = (str1 + "tempRotate.mp4");
      }
      catch (Exception paraml)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", new Object[] { paraml.getMessage() });
        }
      }
      AppMethodBeat.o(76604);
      return;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(76605);
    if (this.oJt.fdk == -1)
    {
      this.oJt.fdk = Process.myTid();
      Process.setThreadPriority(Process.myTid(), -2);
      ab.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(this.oJt.fdk) });
    }
    int i;
    int j;
    for (;;)
    {
      synchronized (this.fdy)
      {
        if (this.fdv) {
          break label201;
        }
        l = bo.yB();
        i = SightVideoJNI.triggerEncode(this.fds, Math.max(0, this.eUK), false);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.eUK), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
        j = Math.abs(i - this.eUK);
        if (j > 5) {}
      }
      try
      {
        Thread.sleep(100L);
        this.eUK = i;
        continue;
        localObject2 = finally;
        AppMethodBeat.o(76605);
        throw localObject2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
        }
      }
    }
    label201:
    long l = bo.yB();
    if (!this.fdw) {
      this.eUK = SightVideoJNI.triggerEncode(this.fds, this.eUK, true);
    }
    ab.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.eUK), Boolean.valueOf(this.fdw), Long.valueOf(Thread.currentThread().getId()) });
    if (!this.fdw)
    {
      i = Math.max(1000, this.duration);
      if (this.oJt.fcd > 0) {
        i = this.oJt.fcd;
      }
      float f = this.bJg;
      if (this.oJt.fce > 0.0F) {
        f = this.oJt.fce;
      }
      this.oJt.fdg = new m(this.fds, this.oJt.fca, f, this.oJt.fcj, i, this.oJt.fcu.audioSampleRate, false);
      l = bo.yB();
      boolean bool = this.oJt.fdg.bRm();
      ab.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bo.av(l)), Boolean.valueOf(bool) });
      if (!bool)
      {
        ab.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
        SightVideoJNI.releaseBigSightDataBufferLock(this.fds);
        al.d(new l.a.1(this));
        ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
        h.qsU.idkeyStat(440L, 30L, 1L, false);
        AppMethodBeat.o(76605);
        return;
      }
      if (((this.oJt.fcx) && (this.oJt.fdl)) || ((!this.oJt.fdl) && (!this.oJt.fcx)) || ((this.oJt.fcx) && (Math.abs(this.oJt.fcn - this.oJt.fcy) == 0)) || (this.oJt.fcy == 180))
      {
        l = bo.yB();
        if ((this.oJt.fdl) || (this.oJt.fcx)) {
          break label892;
        }
        i = this.oJt.fcn;
      }
    }
    for (;;)
    {
      j = i;
      if (this.oJt.fcy == 180)
      {
        j = i;
        if (!this.oJt.fdl)
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
        SightVideoJNI.tagRotateVideo(this.oJt.fca, this.oJt.fco, j);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.oJt.fcn), Boolean.valueOf(this.oJt.fcx), Integer.valueOf(this.oJt.fcy), Integer.valueOf(j) });
        str = this.oJt.fco;
      }
      try
      {
        com.tencent.mm.vfs.e.C(this.oJt.fco, this.oJt.fca);
        d.post(new l.a.3(this, str), "BigSightFFMpegRecorder_tagRotate_after_process");
        ab.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(bo.av(l)) });
        SightVideoJNI.releaseBigSightDataBufferLock(this.fds);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[] { this.callback });
        this.oJt.reset();
        al.d(this.callback);
        this.fdx = true;
        this.oJt.fdk = -1;
        this.oJt.fdj = -1;
        AppMethodBeat.o(76605);
        return;
      }
      catch (Exception localException2)
      {
        label892:
        ab.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
        SightVideoJNI.releaseBigSightDataBufferLock(this.fds);
        al.d(new l.a.2(this));
        AppMethodBeat.o(76605);
        return;
      }
      if (this.oJt.fdl) {
        i = this.oJt.fcy;
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